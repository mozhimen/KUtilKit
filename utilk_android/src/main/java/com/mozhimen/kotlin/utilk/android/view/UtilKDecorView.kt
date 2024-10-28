package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.cons.CPackage
import com.mozhimen.kotlin.elemk.kotlin.cons.CSuppress
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKDecorView
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/20 15:45
 * @Version 1.0
 */
object UtilKDecorView : BaseUtilK() {
    @JvmStatic
    fun get(activity: Activity): View =
        get(activity.window)

    @JvmStatic
    fun get(window: Window): View =
        UtilKWindow.getDecorView(window)

    @Suppress(CSuppress.UNCHECKED_CAST)
    @JvmStatic
    fun <V : View> getAs(activity: Activity): V =
        getAs(activity.window)

    @Suppress(CSuppress.UNCHECKED_CAST)
    @JvmStatic
    fun <V : View> getAs(window: Window): V =
        get(window) as V

    @JvmStatic
    fun getAsViewGroup(activity: Activity): ViewGroup =
        getAsViewGroup(activity.window)

    @JvmStatic
    fun getAsViewGroup(window: Window): ViewGroup =
        getAs(window)

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun <V : View> getContentView(activity: Activity): V =
        get(activity).findViewById(CPackage.ANDROID_R_ID_CONTENT)

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getSystemUiVisibility(activity: Activity): Int =
        getSystemUiVisibility(get(activity))

    @JvmStatic
    fun getSystemUiVisibility(window: Window): Int =
        getSystemUiVisibility(get(window))

    @JvmStatic
    fun getSystemUiVisibility(decorView: View): Int =
        decorView.systemUiVisibility

    @JvmStatic
    fun getWindowSystemUiVisibility(activity: Activity): Int =
        getWindowSystemUiVisibility(get(activity))

    @JvmStatic
    fun getWindowSystemUiVisibility(window: Window): Int =
        getWindowSystemUiVisibility(get(window))

    @JvmStatic
    fun getWindowSystemUiVisibility(decorView: View): Int =
        decorView.windowSystemUiVisibility

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getWindowVisibleDisplayFrame(activity: Activity): Rect =
        getWindowVisibleDisplayFrame(get(activity), Rect())

    @JvmStatic
    fun getWindowVisibleDisplayFrame(window: Window): Rect =
        getWindowVisibleDisplayFrame(get(window), Rect())

    @JvmStatic
    fun getWindowVisibleDisplayFrame(view: View, rect: Rect): Rect {
        UtilKView.getWindowVisibleDisplayFrame(view, rect)
        return rect
    }

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applySystemUiVisibility(activity: Activity, visibility: Int) {
        applySystemUiVisibility(activity.window, visibility)
    }

    @JvmStatic
    fun applySystemUiVisibility(window: Window, visibility: Int) {
        applySystemUiVisibility(get(window), visibility)
    }

    @JvmStatic
    fun applySystemUiVisibility(decorView: View, visibility: Int) {
        decorView.systemUiVisibility = visibility
    }

    @JvmStatic
    fun applySystemUiVisibilityOr(activity: Activity, visibility: Int) {
        applySystemUiVisibilityOr(activity.window, visibility)
    }

    @JvmStatic
    fun applySystemUiVisibilityOr(window: Window, visibility: Int) {
        applySystemUiVisibilityOr(get(window), visibility)
    }

    @JvmStatic
    fun applySystemUiVisibilityOr(decorView: View, visibility: Int) {
        applySystemUiVisibility(decorView, getSystemUiVisibility(decorView) or visibility)
    }

    @JvmStatic
    fun applySystemUiVisibilityAnd(activity: Activity, visibility: Int) {
        applySystemUiVisibilityAnd(activity.window, visibility)
    }

    @JvmStatic
    fun applySystemUiVisibilityAnd(window: Window, visibility: Int) {
        applySystemUiVisibilityAnd(get(window), visibility)
    }

    @JvmStatic
    fun applySystemUiVisibilityAnd(decorView: View, visibility: Int) {
        applySystemUiVisibility(decorView, getSystemUiVisibility(decorView) and visibility)
    }

    @JvmStatic
    fun applyOnSystemUiVisibilityChangeListener(activity: Activity, listener: View.OnSystemUiVisibilityChangeListener) {
        applyOnSystemUiVisibilityChangeListener(get(activity), listener)
    }

    @JvmStatic
    fun applyOnSystemUiVisibilityChangeListener(window: Window, listener: View.OnSystemUiVisibilityChangeListener) {
        applyOnSystemUiVisibilityChangeListener(get(window), listener)
    }

    @JvmStatic
    fun applyOnSystemUiVisibilityChangeListener(decorView: View,  listener: View.OnSystemUiVisibilityChangeListener) {
        decorView.setOnSystemUiVisibilityChangeListener(listener)
    }
}