package com.mozhimen.kotlin.utilk.android.view

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.contains
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKScroll
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/2/22 22:30
 * @Version 1.0
 */
object UtilKViewGroup : IUtilK {
    @JvmStatic
    fun applyInflate(viewGroup: ViewGroup, @LayoutRes intResLayout: Int): View =
        UtilKLayoutInflater.from_inflate(viewGroup, intResLayout)

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addView(viewGroup: ViewGroup, child: View, params: ViewGroup.LayoutParams) {
        viewGroup.addView(child, params)
    }

    @JvmStatic
    fun addView(viewGroup: ViewGroup, child: View) {
        viewGroup.addView(child)
    }
}