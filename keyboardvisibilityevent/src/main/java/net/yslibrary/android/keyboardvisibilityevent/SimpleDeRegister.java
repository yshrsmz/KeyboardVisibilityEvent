package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/**
 * @author Anoop S S
 *         anoopss@cyware.com
 *         on 28/02/2017
 */

public class SimpleDeRegister implements Deregister {

  private WeakReference<Activity> mActivityWeakReference;

  private WeakReference<ViewTreeObserver.OnGlobalLayoutListener> mOnGlobalLayoutListenerWeakReference;

  public SimpleDeRegister(Activity activity, ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener){
    this.mActivityWeakReference = new WeakReference<Activity>(activity);
    this.mOnGlobalLayoutListenerWeakReference = new WeakReference<ViewTreeObserver.OnGlobalLayoutListener>(globalLayoutListener);
  }

  @Override public void deRegister() {
    Activity activity = mActivityWeakReference.get();
    ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = mOnGlobalLayoutListenerWeakReference.get();

    if(null != activity && null != globalLayoutListener){
      View activityRoot = KeyboardVisibilityEvent.getActivityRoot(activity);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        activityRoot.getViewTreeObserver()
            .removeOnGlobalLayoutListener(globalLayoutListener);
      } else {
        activityRoot.getViewTreeObserver()
            .removeGlobalOnLayoutListener(globalLayoutListener);
      }
    }

    mActivityWeakReference.clear();
    mOnGlobalLayoutListenerWeakReference.clear();
  }

}
