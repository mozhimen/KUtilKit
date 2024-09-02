package com.mozhimen.kotlin.utilk.java.io

import android.text.TextUtils
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader

/**
 * @ClassName UtilKBufferedReader
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/28
 * @Version 1.0
 */
object UtilKBufferedReader {
    @JvmStatic
    fun get(reader: Reader, bufferSize: Int): BufferedReader =
        if (bufferSize == 0) BufferedReader(reader)
        else BufferedReader(reader, bufferSize)

    //////////////////////////////////////////////////////////////

    @JvmStatic
    fun readLines_use(bufferedReader: BufferedReader, isAddLineBreak: Boolean = false): String {
        val stringBuilder = StringBuilder()
        try {
            var line = ""
            return if (isAddLineBreak){
                while (bufferedReader.readLine()?.also { line = it } != null)
                    stringBuilder.append(line).append("\n")
                stringBuilder.toString().replaceAfterLast("\n", "")
            }else{
                while (bufferedReader.readLine()?.also { line = it } != null)
                    stringBuilder.append(line)/*.append("\n")*/
                stringBuilder.toString()/*.replaceAfterLast("\n", "")*/
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            bufferedReader.close()
        }
        return ""
    }

    @JvmStatic
    fun readLine_use(bufferedReader: BufferedReader): String? =
        bufferedReader.use { bufferedReader.readLine() }
}