package com.mozhimen.kotlin.utilk.google.material

import androidx.annotation.Px
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel

/**
 * @ClassName UtilKShapeAppearanceModel
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/6
 * @Version 1.0
 */
object UtilKShapeAppearanceModel {
    @JvmStatic
    fun get_ROUNDED(@Px radius: Float): ShapeAppearanceModel =
        ShapeAppearanceModel.Builder().setAllCorners(CornerFamily.ROUNDED, radius).build()
}