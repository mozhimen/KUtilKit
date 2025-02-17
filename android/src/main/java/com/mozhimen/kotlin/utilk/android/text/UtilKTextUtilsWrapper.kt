package com.mozhimen.kotlin.utilk.android.text

import android.text.TextPaint
import android.text.TextUtils
import androidx.annotation.Px

/**
 * @ClassName UtilKTextUtils
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/17
 * @Version 1.0
 */
object UtilKTextUtilsWrapper {
    @JvmStatic
    fun ellipsize_start(chars: CharSequence, textPaint: TextPaint, @Px width: Float): CharSequence =
        TextUtils.ellipsize(chars, textPaint, width, TextUtils.TruncateAt.START)

    @JvmStatic
    fun ellipsize_middle(chars: CharSequence, textPaint: TextPaint, @Px width: Float): CharSequence =
        TextUtils.ellipsize(chars, textPaint, width, TextUtils.TruncateAt.MIDDLE)

    /**
     * draw text "ellipsized" to a canvas
     */
    @JvmStatic
    fun ellipsize_end(chars: CharSequence, textPaint: TextPaint, @Px width: Float): CharSequence =
        TextUtils.ellipsize(chars, textPaint, width, TextUtils.TruncateAt.END)

    @JvmStatic
    fun ellipsize_marquee(chars: CharSequence, textPaint: TextPaint, @Px width: Float): CharSequence =
        TextUtils.ellipsize(chars, textPaint, width, TextUtils.TruncateAt.MARQUEE)



}