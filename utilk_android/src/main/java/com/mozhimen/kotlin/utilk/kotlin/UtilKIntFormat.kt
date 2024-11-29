package com.mozhimen.kotlin.utilk.kotlin

import android.util.Log
import androidx.annotation.IntRange
import com.mozhimen.kotlin.elemk.android.graphics.cons.CImageFormat
import com.mozhimen.kotlin.elemk.android.os.cons.CBuild
import com.mozhimen.kotlin.elemk.android.util.annors.ALog
import com.mozhimen.kotlin.elemk.android.util.cons.CLog
import com.mozhimen.kotlin.utilk.android.text.formatIpAddress
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKCharacter
import com.mozhimen.kotlin.utilk.java.lang.UtilKInteger
import com.mozhimen.kotlin.utilk.kotlin.collections.joinT2listIgnoreNull
import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKStringsJVMWrapper

/**
 * @ClassName UtilKIntFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 0:17
 * @Version 1.0
 */
fun Int.intBinary2booleans(): Array<Boolean> =
    UtilKIntFormat.intBinary2booleans(this)

fun Int.intBinary2booleans(digit: Int): Array<Boolean> =
    UtilKIntFormat.intBinary2booleans(this, digit)

fun Int.int2boolean(): Boolean =
    UtilKIntFormat.int2boolean(this)

fun Int.intIp2strIp(): String =
    UtilKIntFormat.intIp2strIp(this)

fun Int.intAscii2int(): Int =
    UtilKIntFormat.intAscii2int(this)

fun Int.intByte2strByte(): String =
    UtilKIntFormat.intByte2strByte(this)

fun Int.intByte2strByte(@IntRange(from = 1) digit: Int): String =
    UtilKIntFormat.intByte2strByte(this, digit)

fun Int.intByte2strByte2(@IntRange(from = 1) digit: Int): String =
    UtilKIntFormat.intByte2strByte2(this, digit)

fun Int.intImageFormat2strImageFormat(): String =
    UtilKIntFormat.intImageFormat2strImageFormat(this)

fun Int.intLogPriority2strLogPriority_ofSimple(): String =
    UtilKIntFormat.intLogPriority2strLogPriority_ofSimple(this)

fun Int.intLogPriority2strLogPriority(): String =
    UtilKIntFormat.intLogPriority2strLogPriority(this)

///////////////////////////////////////////////////////////////////////

object UtilKIntFormat : IUtilK {
    @JvmStatic
    fun intBinary2booleans(intBinary: Int): Array<Boolean> {
        return intBinary2booleans(intBinary, intBinary.intByte2strByte().length)
    }

    @JvmStatic
    fun intBinary2booleans(intBinary: Int, digit: Int): Array<Boolean> {
        val result = Array(digit) { false }
        for ((index, i) in ((digit - 1) downTo 0).withIndex()) { // 从高位到低位遍历
            result[index] = ((intBinary shr i) and 1 == 1) // 提取每一位并转换为布尔值
        }
        return result.also { Log.d(TAG, "intBinary2booleans: result ${result.map { it }.joinToString { it.toString() }}") }
    }

    @JvmStatic
    fun int2boolean(int: Int) =
        int == 1

    @JvmStatic
    fun intIp2strIp(intIp: Int): String =
        intIp.formatIpAddress()

    //ASCII转整型 '5' ascci 是 53。 输入 int 53，输出 int 5
    @JvmStatic
    fun intAscii2int(intAscii: Int): Int =
        UtilKCharacter.getNumericValue(intAscii)

    @JvmStatic
    fun intByte2strByte(intByte: Int): String =
        UtilKInteger.toBinaryString(intByte)

    @JvmStatic
    fun intByte2strByte(intByte: Int, @IntRange(from = 1) digit: Int): String {
//        val mask = (1 shl digit) - 1
        var strByte = UtilKStringsJVMWrapper.format_fillStart0(digit, (intByte /*and mask*/).intByte2strByte())
        if (strByte.length > digit)
            strByte = strByte.substring(strByte.length - digit, strByte.length)
        return strByte
    }

    @JvmStatic
    fun intByte2strByte2(intByte: Int, @IntRange(from = 1) digit: Int): String {
        val mask = (1 shl digit) - 1// 确保只取指定的 digit 位
        val strByte = (intByte and mask).intByte2strByte()
        return strByte.padStart(digit, '0')// 补齐 digit 位并返回
    }

    @JvmStatic
    fun intImageFormat2strImageFormat(imageFormat: Int): String =
        when (imageFormat) {
            CImageFormat.RGB_565 -> "RGB_565"
            CImageFormat.YV12 -> "YV12"
            CImageFormat.Y8 -> "Y8"
            CImageFormat.Y16 -> "Y16"
            CImageFormat.NV16 -> "NV16"
            CImageFormat.NV21 -> "NV21"
            CImageFormat.YUY2 -> "YUY2"
            CImageFormat.JPEG -> "JPEG"
            CImageFormat.DEPTH_JPEG -> "DEPTH_JPEG"
            CImageFormat.YUV_420_888 -> "YUV_420_888"
            CImageFormat.YUV_422_888 -> "YUV_422_888"
            CImageFormat.YUV_444_888 -> "YUV_444_888"
            CImageFormat.FLEX_RGB_888 -> "FLEX_RGB_888"
            CImageFormat.FLEX_RGBA_8888 -> "FLEX_RGBA_8888"
            CImageFormat.RAW_SENSOR -> "RAW_SENSOR"
            CImageFormat.RAW_PRIVATE -> "RAW_PRIVATE"
            CImageFormat.RAW10 -> "RAW10"
            CImageFormat.RAW12 -> "RAW12"
            CImageFormat.DEPTH16 -> "DEPTH16"
            CImageFormat.DEPTH_POINT_CLOUD -> "DEPTH_POINT_CLOUD"
            CImageFormat.RAW_DEPTH -> "RAW_DEPTH"
            CImageFormat.RAW_DEPTH10 -> "RAW_DEPTH10"
            CImageFormat.PRIVATE -> "PRIVATE"
            CImageFormat.HEIC -> "HEIC"
            else -> CBuild.UNKNOWN
        }

    @JvmStatic
    fun intLogPriority2strLogPriority_ofSimple(@ALog priority: Int): String =
        when (priority) {
            CLog.VERBOSE -> "V"
            CLog.DEBUG -> "D"
            CLog.INFO -> "I"
            CLog.WARN -> "W"
            CLog.ERROR -> "E"
            CLog.ASSERT -> "A"
            else -> "UNKNOWN"
        }

    @JvmStatic
    fun intLogPriority2strLogPriority(@ALog priority: Int): String =
        when (priority) {
            CLog.VERBOSE -> "VERBOSE"
            CLog.DEBUG -> "DEBUG"
            CLog.INFO -> "INFO"
            CLog.WARN -> "WARN"
            CLog.ERROR -> "ERROR"
            CLog.ASSERT -> "ASSERT"
            else -> "UNKNOWN"
        }
}