package com.mozhimen.kotlin.utilk.android.text

import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.ColorInt

/**
 * @ClassName UtilKSpannableString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/12
 * @Version 1.0
 */
object UtilKSpannableString {
    @JvmStatic
    fun get(str: CharSequence): SpannableString =
        SpannableString(str)
}