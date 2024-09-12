package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKContentView
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/20 15:47
 * @Version 1.0
 */
object UtilKContentView : BaseUtilK() {

    @JvmStatic
    fun <V : View> get(window: Window): V =
        UtilKWindow.getContentView_ofPackage(window)

    @JvmStatic
    fun <V : View> get(activity: Activity): V =
        get(activity.window)

    @JvmStatic
    fun <V : View> get_ofWindow(window: Window): V =
        UtilKWindow.getContentView_ofWindow(window)

    @JvmStatic
    fun <V : View> get_ofWindow(activity: Activity): V =
        get_ofWindow(activity.window)

    @JvmStatic
    fun <V : View> get_ofDecorView(activity: Activity): V =
        UtilKDecorView.getContentView(activity)

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getAsViewGroup(activity: Activity): ViewGroup =
        get(activity.window)

    @JvmStatic
    fun getAsViewGroup(window: Window): ViewGroup =
        get(window)

    @JvmStatic
    fun getTag(window: Window, tag: Int): Any? =
        get<View>(window).getTag(tag)

    @JvmStatic
    fun getChildAt0(window: Window): View? =
        getAsViewGroup(window).getChildAt(0)

    @JvmStatic
    fun getChildAt0(activity: Activity): View? =
        getChildAt0(activity.window)

    @JvmStatic
    fun getWindowVisibleDisplayFrame(window: Window): Rect =
        getWindowVisibleDisplayFrame(window, Rect())

    @JvmStatic
    fun getWindowVisibleDisplayFrame(window: Window, rect: Rect): Rect {
        UtilKView.getWindowVisibleDisplayFrame(get(window), rect)
        return rect
    }

    @JvmStatic
    fun getTop(activity: Activity): Int =
        get<View>(activity).top
}