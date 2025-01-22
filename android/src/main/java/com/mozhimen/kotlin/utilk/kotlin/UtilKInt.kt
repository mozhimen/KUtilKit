package com.mozhimen.kotlin.utilk.kotlin

/**
 * @ClassName UtilKInt
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/5/25 10:41
 * @Version 1.0
 */
object UtilKInt {

    @JvmStatic
    fun get_ofKilo(int: Int): Int =
        int * 1000

    @JvmStatic
    fun get_ofMega(int: Int): Int =
        get_ofKilo(int) * 1000
}