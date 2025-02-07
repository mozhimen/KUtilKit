package com.mozhimen.kotlin.utilk.android.text

import android.graphics.drawable.Drawable
import android.text.SpannableString
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.mozhimen.kotlin.elemk.android.text.cons.CSpanned
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes

/**
 * @ClassName UtilKSpannableString
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/12
 * @Version 1.0
 */
object UtilKSpannableStringGet {
    @JvmStatic
    fun get_foreColor(chars: CharSequence, @ColorInt intColor: Int, start: Int, end: Int): SpannableString =
        UtilKSpannableString.get(chars).apply { setSpan(UtilKCharacterStyle.getForegroundColorSpan(intColor), start, end, CSpanned.SPAN_EXCLUSIVE_EXCLUSIVE) }

    @JvmStatic
    fun get_firstDrawable(chars: CharSequence, @DrawableRes intDrawableRes: Int, verticalAlignment: Int): SpannableString =
        get_firstDrawable(chars, UtilKRes.gainDrawable(intDrawableRes), verticalAlignment)

    @JvmStatic
    fun get_firstDrawable(chars: CharSequence, drawable: Drawable?, verticalAlignment: Int): SpannableString =
        UtilKSpannableString.get(" $chars").apply {
            drawable?.let {
                setSpan(UtilKCharacterStyle.getImageSpan(it.apply { setBounds(0, 0, intrinsicWidth, intrinsicHeight) }, verticalAlignment), 0, 1, CSpanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
}