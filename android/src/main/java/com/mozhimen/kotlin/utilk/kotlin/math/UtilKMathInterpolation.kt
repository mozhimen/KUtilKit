package com.mozhimen.kotlin.utilk.kotlin.math

/**
 * @ClassName UtilKMathInterpolation
 * @Description 插值器
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/17
 * @Version 1.0
 */
object UtilKMathInterpolation {
    @JvmStatic
    fun get_linear(t: Float, a: Float, b: Float): Float =
        (a * (1.0f - t)) + (b * t)
}