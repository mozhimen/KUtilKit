package com.mozhimen.kotlin.utilk.kotlin.ranges

import kotlin.math.max
import kotlin.math.min

/**
 * @ClassName UtilKRanges
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/11
 * @Version 1.0
 */
fun Double.constraint(min: Double, max: Double): Double =
    UtilK_Ranges.constraint(this, min, max)

fun Long.constraint(min: Long, max: Long): Long =
    UtilK_Ranges.constraint(this, min, max)

fun Float.constraint(min: Float, max: Float): Float =
    UtilK_Ranges.constraint(this, min, max)

fun Int.constraint(min: Int, max: Int): Int =
    UtilK_Ranges.constraint(this, min, max)

/////////////////////////////////////////////////////

fun Int.constraint(range: IntRange): Int =
    UtilK_Ranges.constraint(this, range)

fun Long.constraint(range: LongRange): Long =
    UtilK_Ranges.constraint(this, range)

/////////////////////////////////////////////////////

fun Int.percent(start: Int, end: Int): Float =
    UtilK_Ranges.percent(this, start, end)

fun Float.percent(start: Float, end: Float): Float =
    UtilK_Ranges.percent(this, start, end)

fun Double.percent(start: Double, end: Double): Double =
    UtilK_Ranges.percent(this, start, end)

/////////////////////////////////////////////////////

object UtilK_Ranges {

    @JvmStatic
    fun constraint(value: Long, min: Long, max: Long): Long {
        val minV = min(min, max)
        val maxV = max(min, max)
        return value.coerceIn(minV, maxV)
    }

    @JvmStatic
    fun constraint(value: Float, min: Float, max: Float): Float {
        val minV = min(min, max)
        val maxV = max(min, max)
        return value.coerceIn(minV, maxV)
    }

    @JvmStatic
    fun constraint(value: Double, min: Double, max: Double): Double {
        val minV = min(min, max)
        val maxV = max(min, max)
        return value.coerceIn(minV, maxV)
    }

    @JvmStatic
    fun constraint(value: Int, min: Int, max: Int): Int {
        val minV = min(min, max)
        val maxV = max(min, max)
        return value.coerceIn(minV, maxV)
    }

    @JvmStatic
    fun constraint(value: Int, range: IntRange): Int =
        value.coerceIn(range)

    @JvmStatic
    fun constraint(value: Long, range: LongRange): Long =
        value.coerceIn(range)

    ////////////////////////////////////////////////////////////

    @JvmStatic
    fun percent(value: Double, start: Double, end: Double): Double {
        if (start == end) return 0.0
        val startV = min(start, end)
        val endV = max(start, end)
        return (constraint(value, startV, endV) - startV) / (endV - startV)
    }

    @JvmStatic
    fun percent(value: Float, start: Float, end: Float): Float {
        if (start == end) return 0f
        val startV = min(start, end)
        val endV = max(start, end)
        return (constraint(value, startV, endV) - startV) / (endV - startV)
    }

    @JvmStatic
    fun percent(value: Int, start: Int, end: Int): Float {
        return percent(value.toFloat(), start.toFloat(), end.toFloat())
    }

    //////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun random(start: Int, end: Int): Int =
        random(IntRange(start, end))

    @JvmStatic
    fun random(range: IntRange): Int =
        range.random()
}