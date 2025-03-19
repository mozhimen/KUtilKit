package com.mozhimen.kotlin.utilk.android.graphics

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.graphics.component3
import androidx.core.graphics.component4
import androidx.core.graphics.drawable.toBitmap
import java.io.InputStream

/**
 * @ClassName UtilKDrawableFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 0:15
 * @Version 1.0
 */
fun Drawable.drawable2bitmapDrawable(drawable: Drawable): BitmapDrawable =
    UtilKDrawableFormat.drawable2bitmapDrawable(drawable)

fun Drawable.drawable2bitmap(width: Int = this.intrinsicWidth, height: Int = this.intrinsicHeight, config: Bitmap.Config? = null): Bitmap =
    UtilKDrawableFormat.drawable2bitmap(this, width, height, config)

fun Drawable.drawable2inputStream(
    width: Int = this.intrinsicWidth,
    height: Int = this.intrinsicHeight,
    config: Bitmap.Config? = null,
    compressFormat: CompressFormat = CompressFormat.JPEG,
    @IntRange(from = 0, to = 100) quality: Int = 100,
): InputStream =
    UtilKDrawableFormat.drawable2inputStream(this, width, height, config, compressFormat, quality)

/////////////////////////////////////////////////////////////////////////////

object UtilKDrawableFormat {
    @JvmStatic
    fun drawable2bitmapDrawable(drawable: Drawable): BitmapDrawable =
        drawable as BitmapDrawable

    @JvmStatic
    fun drawable2bitmap(drawable: Drawable, width: Int = drawable.intrinsicWidth, height: Int = drawable.intrinsicHeight, config: Bitmap.Config? = null): Bitmap =
        drawable.toBitmap(width, height, config)

    @JvmStatic
    fun drawable2inputStream(
        drawable: Drawable,
        width: Int = drawable.intrinsicWidth,
        height: Int = drawable.intrinsicHeight,
        config: Bitmap.Config? = null,
        compressFormat: CompressFormat = CompressFormat.JPEG,
        @IntRange(from = 0, to = 100) quality: Int = 100,
    ): InputStream =
        drawable.drawable2bitmap(width, height, config).bitmapAny2byteArrayInputStream(compressFormat, quality)
}