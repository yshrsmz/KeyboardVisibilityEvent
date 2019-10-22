package net.yslibrary.android.keyboardvisibilityevent

import android.app.Activity
import android.os.Build
import android.view.ViewTreeObserver

import java.lang.ref.WeakReference

/**
 * @author Anoop S S
 * anoopvvs@gmail.com
 * on 28/02/2017
 */

class SimpleUnregistrar internal constructor(
    activity: Activity,
    globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
) : Unregistrar {

    private val activityWeakReference: WeakReference<Activity> = WeakReference(activity)

    private val onGlobalLayoutListenerWeakReference: WeakReference<ViewTreeObserver.OnGlobalLayoutListener> =
        WeakReference(globalLayoutListener)

    override fun unregister() {
        val activity = activityWeakReference.get()
        val globalLayoutListener = onGlobalLayoutListenerWeakReference.get()

        if (null != activity && null != globalLayoutListener) {
            val activityRoot = KeyboardVisibilityEvent.getActivityRoot(activity)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activityRoot.viewTreeObserver
                    .removeOnGlobalLayoutListener(globalLayoutListener)
            } else {
                @Suppress("DEPRECATION")
                activityRoot.viewTreeObserver
                    .removeGlobalOnLayoutListener(globalLayoutListener)
            }
        }

        activityWeakReference.clear()
        onGlobalLayoutListenerWeakReference.clear()
    }

}
