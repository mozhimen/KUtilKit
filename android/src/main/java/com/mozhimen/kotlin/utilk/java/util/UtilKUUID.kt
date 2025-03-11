package com.mozhimen.kotlin.utilk.java.util

import com.mozhimen.kotlin.elemk.android.util.cons.CBase64
import com.mozhimen.kotlin.utilk.kotlin.bytes2bytesBase64
import com.mozhimen.kotlin.utilk.kotlin.bytes2str
import com.mozhimen.kotlin.utilk.kotlin.strHex2bytes
import java.util.UUID

/**
 * @ClassName UtilKStrUuid
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/2 15:51
 * @Version 1.0
 */
object UtilKUUID {
    @JvmStatic
    fun get(key: String): UUID =
        fromString(key)

    @JvmStatic
    fun get_random(): UUID =
        randomUUID()

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun randomUUID(): UUID =
        UUID.randomUUID()

    @JvmStatic
    fun fromString(name: String): UUID =
        UUID.fromString(name)
}