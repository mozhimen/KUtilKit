package com.mozhimen.kotlin.utilk.java.io

import java.io.BufferedReader
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
        var bufferedReader: BufferedReader? = null
        try {
            inputStreamReader = inputStream.inputStream2inputStreamReader(charset)
            bufferedReader = inputStreamReader.inputStreamReader2bufferedReader(bufferSize)
            return UtilKBufferedReader.readLines_use(bufferedReader, isAddLineBreak)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            bufferedReader?.close()
            inputStreamReader?.close()
        }
        return ""
    }

    @JvmStatic
    fun readLine_use(inputStream: InputStream, charset: String? = null, bufferSize: Int = 1024): String? {
        var inputStreamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null
        try {
            inputStreamReader = inputStream.inputStream2inputStreamReader(charset)
            bufferedReader = inputStreamReader.inputStreamReader2bufferedReader(bufferSize)
            return UtilKBufferedReader.readLine_use(bufferedReader)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            bufferedReader?.close()
            inputStreamReader?.close()
        }
        return null
    }
}