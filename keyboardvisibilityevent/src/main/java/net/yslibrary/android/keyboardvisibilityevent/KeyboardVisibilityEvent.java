package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.graphics.Rect;
import android.view.*;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

/**
 * Created by yshrsmz on 15/03/17.
 */
public class KeyboardVisibilityEvent {

    private final static double KEYBOARD_MIN_HEIGHT_RATIO = 0.15;

    /**
     * Set keyboard visibility change event listener.
     * This automatically remove registered event listener when the Activity is destroyed
     *
     * @param activity Activity
     * @param listener KeyboardVisibilityEventListener
     */
    public static void setEventListener(final Activity activity,
                                        final KeyboardVisibilityEventListener listener) {

        final Unregistrar unregistrar = registerEventListener(activity, listener);
        activity.getApplication()
                .registerActivityLifecycleCallbacks(new AutoActivityLifecycleCallback(activity) {
                    @Override
                    protected void onTargetActivityDestroyed() {
                        unregistrar.unregister();
                    }
                });
    }

    /**
     * Set keyboard visibility change event listener.
     *
     * @param activity Activity
     * @param listener KeyboardVisibilityEventListener
     * @return Unregistrar
     */
    public static Unregistrar registerEventListener(final Activity activity,
                                                    final KeyboardVisibilityEventListener listener) {

        if (activity == null) {
            throw new NullPointerException("Parameter:activity must not be null");
        }

        int softInputAdjust = activity.getWindow().getAttributes().softInputMode
                & WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;

        // fix for #37 and #38.
        // The window will not be resized in case of SOFT_INPUT_ADJUST_NOTHING
        if ((softInputAdjust & WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
                == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING) {
            throw new IllegalArgumentException("Parameter:activity window SoftInputMethod is SOFT_INPUT_ADJUST_NOTHING. In this case window will not be resized");
        }

        if (listener == null) {
            throw new NullPointerException("Parameter:listener must not be null");
        }

        final View activityRoot = getActivityRoot(activity);

        final ViewTreeObserver.OnGlobalLayoutListener layoutListener =
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    private final Rect r = new Rect();

                    private boolean wasOpened = false;

                    @Override
                    public void onGlobalLayout() {
                        activityRoot.getWindowVisibleDisplayFrame(r);

                        int screenHeight = activityRoot.getRootView().getHeight();

                        int statusBarHeight  = 0;
                        int resourceId = activityRoot.getResources().getIdentifier("status_bar_height", "dimen", "android");
                        if (resourceId > 0) {
                            statusBarHeight  = activityRoot.getResources().getDimensionPixelSize(resourceId);
                        }

                        int heightDiff = screenHeight - statusBarHeight  - r.height();

                        boolean isOpen = heightDiff > screenHeight * KEYBOARD_MIN_HEIGHT_RATIO;

                        if (isOpen == wasOpened) {
                            // keyboard state has not changed
                            return;
                        }

                        wasOpened = isOpen;

                        listener.onVisibilityChanged(isOpen);
                    }
                };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);

        return new SimpleUnregistrar(activity, layoutListener);
    }

    /**
     * Determine if keyboard is visible
     *
     * @param activity Activity
     * @return Whether keyboard is visible or not
     */
    public static boolean isKeyboardVisible(Activity activity) {
        Rect r = new Rect();

        View activityRoot = getActivityRoot(activity);


        activityRoot.getWindowVisibleDisplayFrame(r);

        int statusBarHeight  = 0;
        int resourceId = activityRoot.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight  = activityRoot.getResources().getDimensionPixelSize(resourceId);
        }

        int screenHeight = activityRoot.getRootView().getHeight();
        int heightDiff = screenHeight - statusBarHeight  - r.height();

        return heightDiff > screenHeight * KEYBOARD_MIN_HEIGHT_RATIO;
    }

    static View getActivityRoot(Activity activity) {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }
}
