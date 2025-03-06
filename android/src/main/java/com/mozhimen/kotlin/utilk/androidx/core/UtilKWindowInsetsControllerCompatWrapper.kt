package com.mozhimen.kotlin.utilk.androidx.core

import android.view.Window
import com.mozhimen.kotlin.elemk.androidx.core.cons.CWindowInsetsControllerCompat

/**
 * @ClassName UtilKWindowInsetsControllerCompatWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/4
 * @Version 1.0
 */
object UtilKWindowInsetsControllerCompatWrapper {
    @JvmStatic
    fun show_navigationBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).show(UtilKWindowInsetsCompat_Type.get_navigationBars())
    }

    @JvmStatic
    fun show_statusBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).show(UtilKWindowInsetsCompat_Type.get_statusBars())
    }

    @JvmStatic
    fun show_systemBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).show(UtilKWindowInsetsCompat_Type.get_systemBars())
    }

    @JvmStatic
    fun hide_navigationBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).hide(UtilKWindowInsetsCompat_Type.get_navigationBars())
    }

    @JvmStatic
    fun hide_statusBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).hide(UtilKWindowInsetsCompat_Type.get_statusBars())
    }

    @JvmStatic
    fun hide_systemBars(window: Window) {
        UtilKWindowInsetsControllerCompat.get(window).hide(UtilKWindowInsetsCompat_Type.get_systemBars())
    }

    @JvmStatic
    fun applySystemBarsBehavior_BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE(window: Window) {
        UtilKWindowInsetsControllerCompat.applySystemBarsBehavior(window, CWindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
    }
}