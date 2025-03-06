package com.mozhimen.kotlin.utilk.google.material

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.annotation.Px
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

/**
 * @ClassName UtilKMaterialShapeDrawable
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/9
 * @Version 1.0
 */
object UtilKMaterialShapeDrawable {
    @JvmStatic
    fun get(@Px radius: Float): MaterialShapeDrawable =
        MaterialShapeDrawable(UtilKShapeAppearanceModel.get_ROUNDED(radius))

    @JvmStatic
    @SuppressLint("RestrictedApi")
    fun get(@Px radius: Float, fillColor: ColorStateList, shadowColor: Int, @Px shadowVerticalOffset: Int, elevation: Float, shadowCompatibilityMode: Int): MaterialShapeDrawable =
        get(radius).apply {
            this.fillColor = fillColor
            setShadowColor(shadowColor)
            setShadowVerticalOffset(shadowVerticalOffset) //8.dp.toInt()
            this.elevation = elevation
            this.shadowCompatibilityMode = shadowCompatibilityMode
        }
}