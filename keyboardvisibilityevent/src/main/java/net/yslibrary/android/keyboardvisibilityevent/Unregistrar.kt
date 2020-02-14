package net.yslibrary.android.keyboardvisibilityevent

import android.view.ViewTreeObserver

/**
 * @author Anoop S S
 * anoopvvs@gmail.com
 * on 28/02/2017
 */

interface Unregistrar {

    /**
     * unregisters the [ViewTreeObserver.OnGlobalLayoutListener] and there by does not provide any more callback to the [KeyboardVisibilityEventListener]
     */
    fun unregister()
}

