package com.mozhimen.kotlin.utilk.android.view

import android.view.ViewGroup

/**
 * @ClassName UtilKViewGroup_LayoutParamsGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
object UtilKViewGroup_LayoutParamsGet {
    @JvmStatic
    fun get_MATCHs(): ViewGroup.LayoutParams =
        UtilKViewGroup_LayoutParams.get(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    @JvmStatic
    fun get_WRAPs(): ViewGroup.LayoutParams =
        UtilKViewGroup_LayoutParams.get(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    @JvmStatic
    fun get_MATCH_WRAP(): ViewGroup.LayoutParams =
        UtilKViewGroup_LayoutParams.get(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    @JvmStatic
    fun get_WRAP_MATCH(): ViewGroup.LayoutParams =
        UtilKViewGroup_LayoutParams.get(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
}