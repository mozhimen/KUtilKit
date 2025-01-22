package com.mozhimen.kotlin.utilk.kotlin.collections

/**
 * @ClassName UtilK_Arrays
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/11
 * @Version 1.0
 */
object UtilK_Arrays {
    @JvmStatic
    fun max(nums: IntArray): Int =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: ShortArray): Short =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: LongArray): Long =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: FloatArray): Float =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: DoubleArray): Double =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: ByteArray): Byte =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Int>): Int =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Short>): Short =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Long>): Long =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Float>): Float =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Double>): Double =
        nums.maxOf { it }

    @JvmStatic
    fun max(nums: List<Byte>): Byte =
        nums.maxOf { it }

    ///////////////////////////////////////////////////////////////

    @JvmStatic
    fun min(nums: IntArray): Int =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: ShortArray): Short =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: LongArray): Long =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: FloatArray): Float =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: DoubleArray): Double =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: ByteArray): Byte =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Int>): Int =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Short>): Short =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Long>): Long =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Float>): Float =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Double>): Double =
        nums.minOf { it }

    @JvmStatic
    fun min(nums: List<Byte>): Byte =
        nums.minOf { it }
}