package net.yslibrary.android.keyboardvisibilityevent

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by Piasy{github.com/Piasy} on 8/18/16.
 */

abstract class AutoActivityLifecycleCallback internal constructor(private val targetActivity: Activity) : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, bundle: Bundle) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        if (activity === targetActivity) {
            targetActivity.application.unregisterActivityLifecycleCallbacks(this)
            onTargetActivityDestroyed()
        }
    }

    protected abstract fun onTargetActivityDestroyed()
}
