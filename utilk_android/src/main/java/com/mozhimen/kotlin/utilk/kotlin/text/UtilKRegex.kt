package com.mozhimen.kotlin.utilk.kotlin.text

/**
 * @ClassName UtilKRegex
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/28
 * @Version 1.0
 */
object UtilKRegex {
    @JvmStatic
    fun get(pattern: String): Regex =
        Regex(pattern)
}