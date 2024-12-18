package com.mozhimen.kotlin.utilk.android.view

import android.view.ViewGroup

/**
 * @ClassName UtilKViewGroup_LayoutParams
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
object UtilKViewGroup_LayoutParams {
    @JvmStatic
    fun get(width: Int, height: Int): ViewGroup.LayoutParams =
        ViewGroup.LayoutParams(width, height)
}