package com.mozhimen.kotlin.utilk.android.graphics

import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.Px
import com.mozhimen.kotlin.elemk.android.graphics.cons.CGradientDrawable

/**
 * @ClassName UtilKGradientDrawableGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKGradientDrawableGet {
    @JvmStatic
    fun get(shape: Int, @ColorInt intColor: Int, @ColorInt intColorBorder: Int, @Px intPxWidthBorder: Int): GradientDrawable =
        UtilKGradientDrawable.get().apply {
            this.shape = shape
            setColor(intColor)
            if (intPxWidthBorder > 0 && intColorBorder != intColor) {
                setStroke(intPxWidthBorder, intColorBorder)
            }
        }

    @JvmStatic
    fun get_ofRect(@ColorInt intColor: Int, @Px radius: Float): GradientDrawable =
        UtilKGradientDrawable.get().apply {
            shape = CGradientDrawable.RECTANGLE
            setColor(intColor)
            cornerRadius = radius
        }

    @JvmStatic
    fun get_ofRectBorder(@ColorInt intColor: Int, @Px radius: Float, @Px width: Int, @ColorInt intColorBorder: Int): GradientDrawable =
        UtilKGradientDrawable.get().apply {
            shape = CGradientDrawable.RECTANGLE
            setColor(intColor)
            cornerRadius = radius
            setStroke(width, intColorBorder)
        }
}