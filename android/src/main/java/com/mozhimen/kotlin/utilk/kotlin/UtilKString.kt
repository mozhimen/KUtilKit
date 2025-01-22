package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.nio.charset.Charset

/**
 * @ClassName UtilKString
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/4/29 21:43
 * @Version 1.0
 */
object UtilKString : BaseUtilK() {
    @JvmStatic
    fun get(bytes: ByteArray, charset: Charset): String =
        String(bytes, charset)

    @JvmStatic
    fun get(bytes: ByteArray, offset: Int, length: Int): String =
        String(bytes, offset, length)
}