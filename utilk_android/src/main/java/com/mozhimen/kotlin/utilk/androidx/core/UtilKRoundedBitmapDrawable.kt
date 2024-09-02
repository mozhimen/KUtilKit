package com.mozhimen.kotlin.utilk.androidx.core

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.mozhimen.kotlin.utilk.android.content.UtilKResources
import com.mozhimen.kotlin.utilk.kotlin.intResDrawable2bitmapAny

/**
 * @ClassName UtilKRoundedBitmapDrawable
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/31 13:58
 * @Version 1.0
 */
object UtilKRoundedBitmapDrawable {
    @JvmStatic
    fun get(context: Context, @DrawableRes intResDrawable: Int, @Px radius: Float): RoundedBitmapDrawable? =
        intResDrawable.intResDrawable2bitmapAny(context)?.let {
            get(UtilKResources.get_ofApp(context), it).apply { cornerRadius = radius }
        }


    @JvmStatic
    fun get(context: Context, @DrawableRes intResDrawable: Int): RoundedBitmapDrawable? =
        intResDrawable.intResDrawable2bitmapAny(context)?.let {
            get(UtilKResources.get_ofApp(context),it)
        }

    @JvmStatic
    fun get(res: Resources, bitmap: Bitmap): RoundedBitmapDrawable =
        RoundedBitmapDrawableFactory.create(res, bitmap)
}
