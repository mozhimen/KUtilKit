package com.mozhimen.kotlin.utilk.android.widget

import android.widget.FrameLayout
import androidx.annotation.Px
import com.mozhimen.kotlin.elemk.commons.IExt_Listener

/**
 * @ClassName UtilKFrameLayout_LayoutParams
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
object UtilKFrameLayout_LayoutParamsWrapper {
    @JvmStatic
    fun generateLayoutParams(@Px width: Int, @Px height: Int, block: IExt_Listener<FrameLayout.LayoutParams>): FrameLayout.LayoutParams {
        val layoutParams = FrameLayout.LayoutParams(width, height)
//        layoutParams.gravity = Gravity.BOTTOM or Gravity.END
//        layoutParams.setMargins(0, layoutParams.topMargin, layoutParams.rightMargin, 500)
        layoutParams.block()
        return layoutParams
    }
}