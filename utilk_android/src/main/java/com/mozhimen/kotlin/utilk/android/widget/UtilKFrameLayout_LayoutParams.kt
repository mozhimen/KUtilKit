package com.mozhimen.kotlin.utilk.android.widget

import android.widget.FrameLayout

/**
 * @ClassName UtilKFrameLayout_LayoutParams
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
object UtilKFrameLayout_LayoutParams {
    @JvmStatic
    fun get(width: Int, height: Int): FrameLayout.LayoutParams =
        FrameLayout.LayoutParams(width, height)

    @JvmStatic
    fun get(width: Int, height: Int, gravity: Int): FrameLayout.LayoutParams =
        FrameLayout.LayoutParams(width, height, gravity)
}