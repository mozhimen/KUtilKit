package com.mozhimen.kotlin.utilk.android.widget

import android.view.ViewGroup
import android.widget.FrameLayout
import com.mozhimen.kotlin.utilk.android.view.UtilKViewGroup_LayoutParams

/**
 * @ClassName UtilKFrameLayout_LayoutParamsGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
object UtilKFrameLayout_LayoutParamsGet {
    @JvmStatic
    fun get_MATCHs(): FrameLayout.LayoutParams =
        UtilKFrameLayout_LayoutParams.get(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    @JvmStatic
    fun get_WRAPs(): FrameLayout.LayoutParams =
        UtilKFrameLayout_LayoutParams.get(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    @JvmStatic
    fun get_MATCH_WRAP(): FrameLayout.LayoutParams =
        UtilKFrameLayout_LayoutParams.get(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    @JvmStatic
    fun get_WRAP_MATCH(): FrameLayout.LayoutParams =
        UtilKFrameLayout_LayoutParams.get(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)

}