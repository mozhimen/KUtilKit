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
    fun get(): String =
        randomUUID().toString()

    //生成随机字符串
    @JvmStatic
    fun get_ofFormat(): String =
        get().replace("-", "")

    @JvmStatic
    fun get_ofCompress():String =
        get_ofFormat().strHex2bytes().bytes2bytesBase64(CBase64.URL_SAFE or CBase64.NO_PADDING or CBase64.NO_WRAP).bytes2str()

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun randomUUID(): UUID =
        UUID.randomUUID()
}