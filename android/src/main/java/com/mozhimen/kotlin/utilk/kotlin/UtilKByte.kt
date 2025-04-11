package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone
import kotlin.experimental.and

/**
 * @ClassName UtilKByte
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/1 16:19
 * @Version 1.0
 */
fun Byte.byte2strHex(): String =
    UtilKByte.byte2strHex(this)

fun Byte.byte2strHex_ofHexString(): String =
    UtilKByte.byte2strHex_ofHexString(this)

fun Byte.byte2int(): Int =
    UtilKByte.byte2int(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKByte {
    private const val HEX_CHARS = "0123456789abcdef"
    private const val HEX_CHARS_UPPER = "0123456789ABCDEF"

    //字节转成字符(性能)
    @JvmStatic
    fun byte2strHex(byte: Byte, uppercase: Boolean = false): String =
        if (uppercase)
            "${HEX_CHARS_UPPER[(byte.toInt() and 0xF0) shr 4]}${HEX_CHARS_UPPER[byte.toInt() and 0x0F]}"
        else
            "${HEX_CHARS[(byte.toInt() and 0xF0) shr 4]}${HEX_CHARS[byte.toInt() and 0x0F]}"

    @JvmStatic
    fun byte2strHex_ofHexString(byte: Byte): String {
        val hv: String = Integer.toHexString(byte.toInt() and 0xFF)
        return if (hv.length < 2) "0" else hv
    }

    @JvmStatic
    fun byte2int(byte: Byte): Int =
//        if (byte <= '9'.toByte())
//            byte - '0'.toByte()
//        else
//            byte - 'a'.toByte() + 10
        when (byte) {
            in '0'.toByte()..'9'.toByte() -> byte - '0'.toByte()
            in 'a'.toByte()..'f'.toByte() -> byte - 'a'.toByte() + 10
            in 'A'.toByte()..'F'.toByte() -> byte - 'A'.toByte() + 10
            else -> throw IllegalArgumentException("Invalid hex character: ${byte.toChar()}")
        }
}