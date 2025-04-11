package com.mozhimen.kotlin.utilk.kotlin

/**
 * @ClassName UtilKStrHex
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 1:07
 * @Version 1.0
 */
fun String.strHex2bytes(): ByteArray =
    UtilKStrHex.strHex2bytes(this)

object UtilKStrHex {
    @JvmStatic
    fun strHex2bytes(strHex: String): ByteArray {
        val strHexNew = strHex.removePrefix("0x").filter { it != ':' }
        val len = strHexNew.length
        val data = ByteArray(len / 2)
        var i = 0
        while (i < len) {
            data[i / 2] = ((Character.digit(strHexNew[i], 16) shl 4) + Character.digit(strHexNew[i + 1], 16)).toByte()
            i += 2
        }
        return data
    }
}