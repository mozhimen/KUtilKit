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
    fun <V : View> get_window(window: Window): V =
        UtilKWindow.getContentView_package(window)

    @JvmStatic
    fun <V : View> get_window(activity: Activity): V =
        get_window(activity.window)

    /**
     *  和 [get_window] 是同一个对象
     */
    @JvmStatic
    fun <V : View> get_decor(activity: Activity): V =
        UtilKDecorView.getContentView(activity)

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getAsViewGroup(activity: Activity): ViewGroup =
        get_window(activity.window)

    @JvmStatic
    fun getAsViewGroup(window: Window): ViewGroup =
        get_window(window)

    @JvmStatic
    fun getTag(window: Window, tag: Int): Any? =
        get_window<View>(window).getTag(tag)

    @JvmStatic
    fun getChildAt0(window: Window): View? =
        getAsViewGroup(window).getChildAt(0)

    @JvmStatic
    fun getChildAt0(activity: Activity): View? =
        getChildAt0(activity.window)

    @JvmStatic
    fun getWindowVisibleDisplayFrame(window: Window): Rect {
        val outRect = Rect()
        getWindowVisibleDisplayFrame(window, outRect)
        return outRect
    }

    @JvmStatic
    fun getWindowVisibleDisplayFrame(window: Window, rect: Rect) {
        UtilKView.getWindowVisibleDisplayFrame(get_window(window), rect)
    }

    @JvmStatic
    fun getTop(activity: Activity): Int =
        get_window<View>(activity).top
}

