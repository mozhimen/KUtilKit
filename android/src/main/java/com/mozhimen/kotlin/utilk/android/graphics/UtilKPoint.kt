package com.mozhimen.kotlin.utilk.android.graphics

import android.graphics.Point
import com.mozhimen.kotlin.utilk.kotlin.math.UtilKMathPoint

/**
 * @ClassName UtilKPoint
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/2/11 21:19
 * @Version 1.0
 */
object UtilKPoint {
    @JvmStatic
    fun getDistance(a: Point, b: Point) =
        UtilKMathPoint.distance(a.x.toDouble(), a.y.toDouble(), b.x.toDouble(), b.y.toDouble())
}