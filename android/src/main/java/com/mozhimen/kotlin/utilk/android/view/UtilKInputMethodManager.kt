package com.mozhimen.kotlin.utilk.android.view

import android.content.Context
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKInputMethodManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/10/7 15:11
 * @Version 1.0
 */
object UtilKInputMethodManager {
    @JvmStatic
    fun get(context: Context): InputMethodManager =
        UtilKContext.getInputMethodManager(context)

    //////////////////////////////////////////////////////////////////

    /**
     * 是否激活
     */
    @JvmStatic
    fun isActive(context: Context): Boolean =
        get(context).isActive

    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun showSoftInput(view: View) {
        showSoftInput(view, 0)
    }

    @JvmStatic
    fun showSoftInput(view: View, flags: Int) {
        get(view.context).showSoftInput(view, flags)
    }

    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hideSoftInputFromWindow(view: View) {
        hideSoftInputFromWindow(view.context, view.windowToken)
    }

    @JvmStatic
    fun hideSoftInputFromWindow(context: Context, windowToken: IBinder) {
        hideSoftInputFromWindow(context, windowToken, 0)
    }

    @JvmStatic
    fun hideSoftInputFromWindow(context: Context, windowToken: IBinder, flags: Int) {
        get(context).hideSoftInputFromWindow(windowToken, flags)
    }

    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun toggleSoftInput(context: Context) {
        toggleSoftInput(context, 0, 0)
    }

    @JvmStatic
    fun toggleSoftInput(context: Context, showFlags: Int, hideFlags: Int) {
        get(context).toggleSoftInput(showFlags, hideFlags)
    }
}