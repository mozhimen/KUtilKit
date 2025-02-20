package com.mozhimen.kotlin.utilk.kotlin.math

import android.graphics.PointF
import com.mozhimen.kotlin.elemk.mos.MAreaF2

/**
 * @ClassName UtilKMathArea
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/20
 * @Version 1.0
 */
object UtilKMathArea {
    //是否在区域内
    @JvmStatic
    fun isInside_android(pointF: PointF, areaF: MAreaF2): Boolean =
        pointF.x > areaF.left && pointF.x < areaF.right && pointF.y > areaF.top && pointF.y < areaF.bottom

    //是否在区域内
    @JvmStatic
    fun isInside_android(x: Float, y: Float, left: Float, top: Float, right: Float, bottom: Float): Boolean =
        x > left && x < right && y > top && y < bottom

    //是否在区域外
    @JvmStatic
    fun isOutside_android(pointF: PointF, areaF: MAreaF2): Boolean =
        pointF.x < areaF.left || pointF.x > areaF.right || pointF.y < areaF.top || pointF.y > areaF.bottom

    //是否在区域外
    @JvmStatic
    fun isOutside_android(x: Float, y: Float, left: Float, top: Float, right: Float, bottom: Float): Boolean =
        x < left && x > right && y < top && y > bottom
}