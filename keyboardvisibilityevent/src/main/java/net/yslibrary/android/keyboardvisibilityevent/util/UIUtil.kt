package net.yslibrary.android.keyboardvisibilityevent.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by yshrsmz on 15/03/17.
 */
object UIUtil {

    /**
     * Show keyboard and focus to given EditText
     *
     * @param context Context
     * @param target  EditText to focus
     */
    @Suppress("unused")
    @JvmStatic
    fun showKeyboard(context: Context, target: EditText) {

        val imm = getInputMethodManager(context)

        imm.showSoftInput(target, InputMethodManager.SHOW_IMPLICIT)
    }

    /**
     * Show keyboard and focus to given EditText.
     * Use this method if target EditText is in Dialog.
     *
     * @param dialog Dialog
     * @param target EditText to focus
     */
    @Suppress("unused")
    @JvmStatic
    fun showKeyboardInDialog(dialog: Dialog, target: EditText) {

        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        target.requestFocus()
    }

    /**
     * hide keyboard
     *
     * @param context Context
     * @param target  View that currently has focus
     */
    @JvmStatic
    fun hideKeyboard(context: Context, target: View) {
        val imm = getInputMethodManager(context)
        imm.hideSoftInputFromWindow(target.windowToken, 0)
    }

    /**
     * hide keyboard
     *
     * @param activity Activity
     */
    @Suppress("unused")
    @JvmStatic
    fun hideKeyboard(activity: Activity) {
        val view = activity.window.decorView

        hideKeyboard(activity, view)
    }

    private fun getInputMethodManager(context: Context): InputMethodManager {
        return context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
}
