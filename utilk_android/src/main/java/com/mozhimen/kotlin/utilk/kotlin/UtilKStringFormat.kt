package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.java.io.UtilKFileFormat
import com.mozhimen.kotlin.utilk.java.io.UtilKFileWrapper
import com.mozhimen.kotlin.utilk.java.io.createFile
import com.mozhimen.kotlin.utilk.java.io.file2fileOutputStream
import com.mozhimen.kotlin.utilk.java.io.write_flashClose
import com.mozhimen.kotlin.utilk.java.io.write_use
import java.io.File
import java.io.RandomAccessFile
import java.nio.charset.Charset

/**
 * @ClassName UtilKStringFormat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/1 16:31
 * @Version 1.0
 */
fun String.str2file(strFilePathNameDest: String): File? =
    UtilKStringFormat.str2file(this, strFilePathNameDest)

fun String.str2file(fileDest: File): File? =
    UtilKStringFormat.str2file(this, fileDest)

fun String.str2fileOfFileOutStream(strFilePathName: String, isAppend: Boolean = false): File? =
    UtilKStringFormat.str2fileOfFileOutStream(this, strFilePathName, isAppend)

fun String.str2fileOfFileOutStream(fileDest: File, isAppend: Boolean = false): File? =
    UtilKStringFormat.str2fileOfFileOutStream(this, fileDest, isAppend)

////////////////////////////////////////////////////////////////////////////////////////

fun String.str2strUnicode(): String =
    UtilKStringFormat.str2strUnicode(this)

fun String.str2bytes(charset: Charset = Charsets.UTF_8): ByteArray =
    UtilKStringFormat.str2bytes(this, charset)

////////////////////////////////////////////////////////////////////////////////////////

object UtilKStringFormat {
    /**
     * 文本转文件
     */
    @JvmStatic
    fun str2file(str: String, strFilePathNameDest: String): File? =
        str2file(str, strFilePathNameDest.strFilePath2file().apply { createFile() })

    /**
     * 文本转文件
     */
    @JvmStatic
    fun str2file(str: String, fileDest: File): File? {
        UtilKFileWrapper.createFile(fileDest)
        try {
            RandomAccessFile(fileDest, "rwd").write_use(str)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(UtilKFileFormat.TAG)
        }
        return null
    }

    @JvmStatic
    fun str2fileOfFileOutStream(str: String, strFilePathName: String, isAppend: Boolean = false): File? =
        str2fileOfFileOutStream(str, strFilePathName.strFilePath2file().apply { createFile() }, isAppend)

    @JvmStatic
    fun str2fileOfFileOutStream(str: String, fileDest: File, isAppend: Boolean = false): File? {
        UtilKFileWrapper.createFile(fileDest)
        try {
            fileDest.file2fileOutputStream(isAppend).write_flashClose(str)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(UtilKFileFormat.TAG)
        }
        return null
    }

    fun str2bytes(str: String, charset: Charset = Charsets.UTF_8): ByteArray =
        str.toByteArray(charset)

    /**
     * icon代码转unicode
     */
    @JvmStatic
    fun str2strUnicode(str: String): String {
        if (str.isEmpty()) return ""
        val stringBuffer = StringBuffer()
        if (str.startsWith("&#x")) {
            val hex = str.replace("&#x", "").replace(";", "").trim()
            val data = Integer.parseInt(hex, 16)
            stringBuffer.append(data.toChar())
        } else if (str.startsWith("&#")) {
            val hex = str.replace("&#", "").replace(";", "").trim()
            val data = Integer.parseInt(hex, 10)
            stringBuffer.append(data.toChar())
        } else if (str.startsWith("\\u")) {
            val hex = str.replace("\\u", "").trim()
            val data = Integer.parseInt(hex, 16)
            stringBuffer.append(data.toChar())
        } else {
            return str
        }

        return stringBuffer.toString()
    }
}