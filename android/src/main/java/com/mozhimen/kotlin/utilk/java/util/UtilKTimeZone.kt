package com.mozhimen.kotlin.utilk.java.util

import java.util.TimeZone

/**
 * @ClassName UtilKTimeZone
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/20
 * @Version 1.0
 */
object UtilKTimeZone {

    @JvmStatic
    fun get(id: String): TimeZone =
        getTimeZone(id)

    @JvmStatic
    fun get_UTC(): TimeZone =
        get("UTC")

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getTimeZone(id: String): TimeZone =
        TimeZone.getTimeZone(id)
}