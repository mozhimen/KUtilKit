package com.mozhimen.kotlin.utilk.java.lang

/**
 * @ClassName UtilKIllegalStateException
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/29
 * @Version 1.0
 */
object UtilKIllegalStateException {
    @JvmStatic
    fun get(str: String): IllegalStateException =
        IllegalStateException(str)
}