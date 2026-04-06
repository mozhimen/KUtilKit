package com.mozhimen.kotlin.utilk.kotlin

/**
 * @ClassName UtilKLong
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/11
 * @Version 1.0
 */
fun Long.kiloBytes(): Long =
    UtilKLong.kiloBytes(this)

fun Int.kiloBytesI(): Int =
    UtilKLong.kiloBytesI(this)

fun Long.megaBytes(): Long =
    UtilKLong.megaBytes(this)

fun Int.megaBytesI(): Int =
    UtilKLong.megaBytesI(this)

fun Long.gigaBytes(): Long =
    UtilKLong.gigaBytes(this)

fun Int.gigaBytesI(): Int =
    UtilKLong.gigaBytesI(this)

//////////////////////////////////////////////////////////

object UtilKLong {
    @JvmStatic
    fun kiloBytes(long: Long): Long =
        long * 1000L

    @JvmStatic
    fun kiloBytesI(int: Int): Int =
        int * 1000

    @JvmStatic
    fun megaBytes(long: Long): Long =
        kiloBytes(long) * 1000L

    @JvmStatic
    fun megaBytesI(int: Int): Int =
        kiloBytesI(int) * 1000

    @JvmStatic
    fun gigaBytes(long: Long): Long =
        megaBytes(long) * 1000L

    @JvmStatic
    fun gigaBytesI(int: Int): Int =
        megaBytesI(int) * 1000
}