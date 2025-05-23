package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.ISuspendExtA_BListener
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.java.io.UtilKFileFormat
import com.mozhimen.kotlin.utilk.java.io.UtilKFileWrapper
import com.mozhimen.kotlin.utilk.java.io.createFile
import com.mozhimen.kotlin.utilk.java.io.file2fileOutputStream
import com.mozhimen.kotlin.utilk.java.io.write_flushClose
import com.mozhimen.kotlin.utilk.java.io.write_use
import com.mozhimen.kotlin.utilk.java.util.UtilKUUID
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegex
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File
import java.io.RandomAccessFile
import java.nio.charset.Charset
import java.util.UUID

/**
 * @ClassName UtilKStringFormat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/1 16:31
 * @Version 1.0
 */
fun String.str2file_use(strFilePathNameDest: String): File? =
    UtilKStringFormat.str2file_use(this, strFilePathNameDest)

fun String.str2file_use(fileDest: File): File? =
    UtilKStringFormat.str2file_use(this, fileDest)

////////////////////////////////////////////////////////////////////////////////////////

fun String.str2file_flushClose_ofFileOutStream(strFilePathName: String, isAppend: Boolean = false): File? =
    UtilKStringFormat.str2file_flushClose_ofFileOutStream(this, strFilePathName, isAppend)

fun String.str2file_flushClose_ofFileOutStream(fileDest: File, isAppend: Boolean = false): File? =
    UtilKStringFormat.str2file_flushClose_ofFileOutStream(this, fileDest, isAppend)

////////////////////////////////////////////////////////////////////////////////////////

fun String.str2regex(): Regex =
    UtilKStringFormat.str2regex(this)

fun String.str2bytes(charset: Charset = Charsets.UTF_8): ByteArray =
    UtilKStringFormat.str2bytes(this, charset)

fun String.str2strUnicode(): String =
    UtilKStringFormat.str2strUnicode(this)

////////////////////////////////////////////////////////////////////////////////////////

fun String.str2uUID(): UUID =
    UtilKStringFormat.str2uUID(this)

////////////////////////////////////////////////////////////////////////////////////////

fun String.str2strsFlow(scope: CoroutineScope, block: ISuspendExtA_BListener<CoroutineScope, String, List<String>>): Flow<List<String>> =
    UtilKStringFormat.str2strsFlow(this, scope, block)

////////////////////////////////////////////////////////////////////////////////////////

object UtilKStringFormat {
    /**
     * 文本转文件
     */
    @JvmStatic
    fun str2file_use(str: String, strFilePathNameDest: String): File? =
        str2file_use(str, strFilePathNameDest.strFilePath2file().apply { createFile() })

    /**
     * 文本转文件
     */
    @JvmStatic
    fun str2file_use(str: String, fileDest: File): File? {
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

    ////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun str2file_flushClose_ofFileOutStream(str: String, strFilePathName: String, isAppend: Boolean = false): File? =
        str2file_flushClose_ofFileOutStream(str, strFilePathName.strFilePath2file().apply { createFile() }, isAppend)

    @JvmStatic
    fun str2file_flushClose_ofFileOutStream(str: String, fileDest: File, isAppend: Boolean = false): File? {
        UtilKFileWrapper.createFile(fileDest)
        try {
            fileDest.file2fileOutputStream(isAppend).write_flushClose(str)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(UtilKFileFormat.TAG)
        }
        return null
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun str2regex(pattern: String): Regex =
        UtilKRegex.get(pattern)

    @JvmStatic
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

    ////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun str2uUID(str: String): UUID =
        UtilKUUID.get(str)

    ////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun str2strsFlow(str: String, scope: CoroutineScope, block: ISuspendExtA_BListener<CoroutineScope, String, List<String>>): Flow<List<String>> =
        flow { emit(scope.block(str)) }
}