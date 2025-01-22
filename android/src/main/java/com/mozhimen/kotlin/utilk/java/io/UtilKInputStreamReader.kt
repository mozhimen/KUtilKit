package com.mozhimen.kotlin.utilk.java.io

import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

/**
 * @ClassName UtilKInputStreamReader
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/28
 * @Version 1.0
 */
object UtilKInputStreamReader {
    @JvmStatic
    fun get(inputStream: InputStream, charset: String?): InputStreamReader =
        if (charset == null) InputStreamReader(inputStream)
        else InputStreamReader(inputStream, charset)

    @JvmStatic
    fun get(inputStream: InputStream, charset: Charset?): InputStreamReader =
        if (charset == null) InputStreamReader(inputStream)
        else InputStreamReader(inputStream, charset)

    ///////////////////////////////////////////////////////////

    @JvmStatic
    fun readLines_use(inputStream: InputStream, charset: String? = null, bufferSize: Int = 1024, isAddLineBreak: Boolean = false): String {
        var inputStreamReader: InputStreamReader? = null
        try {
            inputStreamReader = get(inputStream, charset)
            return UtilKBufferedReader.readLines_use(UtilKBufferedReader.get(inputStreamReader, bufferSize),isAddLineBreak)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStreamReader?.close()
        }
        return ""
    }

    @JvmStatic
    fun readLine_use(inputStream: InputStream, charset: String? = null, bufferSize: Int = 1024): String? {
        var inputStreamReader: InputStreamReader? = null
        try {
            inputStreamReader = get(inputStream, charset)
            return UtilKBufferedReader.readLine_use(UtilKBufferedReader.get(inputStreamReader, bufferSize))
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStreamReader?.close()
        }
        return null
    }
}