package com.mozhimen.kotlin.utilk.java.util

import java.util.UUID

/**
 * @ClassName UtilKUUIDFormat
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/19
 * @Version 1.0
 */
fun UUID.uUID2str(): String =
    UtilKUUIDFormat.uUID2str(this)

/////////////////////////////////////////////////////////////////////

object UtilKUUIDFormat {
    @JvmStatic
    fun uUID2str(uUID: UUID): String =
        uUID.toString()
}