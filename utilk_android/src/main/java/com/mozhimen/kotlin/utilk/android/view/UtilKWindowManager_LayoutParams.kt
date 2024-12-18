package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.view.Window
import android.view.WindowManager

/**
 * @ClassName UtilKWindowManagerLayoutParams
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/22
 * @Version 1.0
 */
object UtilKWindowManager_LayoutParams {
    @JvmStatic
    fun get(activity: Activity): WindowManager.LayoutParams =
        UtilKWindow.getAttributes(activity)

    @JvmStatic
    fun get(window: Window): WindowManager.LayoutParams =
        UtilKWindow.getAttributes(window)

    ///////////////////////////////////////////////////////////////

    @JvmStatic
    fun getFlags(window: Window): Int =
        get(window).flags

    @JvmStatic
    fun getFlags(activity: Activity): Int =
        get(activity).flags
}