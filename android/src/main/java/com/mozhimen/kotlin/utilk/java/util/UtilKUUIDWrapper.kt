package com.mozhimen.kotlin.utilk.java.util

import com.mozhimen.kotlin.elemk.android.util.cons.CBase64
import com.mozhimen.kotlin.utilk.kotlin.bytes2bytesBase64
import com.mozhimen.kotlin.utilk.kotlin.bytes2str
import com.mozhimen.kotlin.utilk.kotlin.strHex2bytes

/**
 * @ClassName UtilKUUIDWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/11
 * @Version 1.0
 */
object UtilKUUIDWrapper {
    @JvmStatic
    fun getRandomStr(): String =
        UtilKUUID.get_random().toString()

    //生成随机字符串
    @JvmStatic
    fun getRandomStrFormat(): String =
        getRandomStr().replace("-", "")

    @JvmStatic
    fun getRandomStrCompress(): String =
        getRandomStrFormat().strHex2bytes().bytes2bytesBase64(CBase64.URL_SAFE or CBase64.NO_PADDING or CBase64.NO_WRAP).bytes2str()
}