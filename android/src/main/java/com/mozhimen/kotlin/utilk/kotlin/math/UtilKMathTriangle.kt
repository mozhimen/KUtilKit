package com.mozhimen.kotlin.utilk.kotlin.math

import kotlin.math.acos
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin


/**
 * @ClassName UtilKTriangle
 * @Description 三角
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/10 16:55
 * @Version 1.0
 */
object UtilKMathTriangle {
    /**
     * 计算临边对斜边的角度
     * @param adjacent Double 临边
     */
    @JvmStatic
    fun getAngleCos(adjacent: Double, hypotenuse: Double): Double =
        Math.toDegrees(acos(adjacent / hypotenuse))

    /**
     * 计算对边对斜边的角度
     */
    @JvmStatic
    fun getAngleSin(opposite: Double, hypotenuse: Double): Double =
        Math.toDegrees(asin(opposite / hypotenuse))

    /**
     * 计算临边对斜边的角度
     * @param adjacent Float 临边
     */
    @JvmStatic
    fun getAngleCos(adjacent: Float, hypotenuse: Float): Float =
        Math.toDegrees(acos(adjacent / hypotenuse).toDouble()).toFloat()

    /**
     * 计算对边对斜边的角度
     */
    @JvmStatic
    fun getAngleSin(opposite: Float, hypotenuse: Float): Float =
        Math.toDegrees(asin(opposite / hypotenuse).toDouble()).toFloat()

    @JvmStatic
    fun getOppositeLength(hypotenuse: Double, angle: Double): Double =
        sin(2.0 * Math.PI / 360.0 * angle) * hypotenuse

    @JvmStatic
    fun getOppositeLength(hypotenuse: Float, angle: Float): Float =
        sin((2.0 * Math.PI / 360.0 * angle).toFloat()) * hypotenuse

    @JvmStatic
    fun getAdjacentLength(hypotenuse: Double, angle: Double): Double =
        cos(2.0 * Math.PI / 360.0 * angle) * hypotenuse

    @JvmStatic
    fun getAdjacentLength(hypotenuse: Float, angle: Float): Float =
        cos((2.0 * Math.PI / 360.0 * angle).toFloat()) * hypotenuse

}