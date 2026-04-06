package com.mozhimen.kotlin.utilk.android.view

import android.content.Context
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

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
        UtilKContextGet.getSystemService_INPUT_METHOD(context)

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
        val windowToken = view.windowToken ?: return
        hideSoftInputFromWindow(windowToken, view.context)
    }

    @JvmStatic
    fun hideSoftInputFromWindow(windowToken: IBinder, context: Context) {
        hideSoftInputFromWindow(windowToken, 0, context)
    }

    @JvmStatic
    fun hideSoftInputFromWindow(windowToken: IBinder, flags: Int, context: Context) {
        get(context).hideSoftInputFromWindow(windowToken, flags)
    }

    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun toggleSoftInput(context: Context) {
        toggleSoftInput(0, 0, context)
    }

    @JvmStatic
    fun toggleSoftInput(showFlags: Int, hideFlags: Int, context: Context) {
        get(context).toggleSoftInput(showFlags, hideFlags)
    }
}