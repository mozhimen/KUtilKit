package com.mozhimen.kotlin.elemk.android.text.cons

import android.text.style.DynamicDrawableSpan
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName CDynamicDrawableSpan
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/1/21
 * @Version 1.0
 */
object CDynamicDrawableSpan {
    const val ALIGN_BOTTOM = DynamicDrawableSpan.ALIGN_BOTTOM
    const val ALIGN_BASELINE = DynamicDrawableSpan.ALIGN_BASELINE

    @RequiresApi(CVersCode.V_29_10_Q)
    const val ALIGN_CENTER = DynamicDrawableSpan.ALIGN_CENTER
}