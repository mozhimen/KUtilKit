package com.mozhimen.kotlin.utilk.java.io

import com.mozhimen.kotlin.elemk.cons.CPath
import com.mozhimen.kotlin.utilk.android.os.UtilKProcess
import com.mozhimen.kotlin.utilk.android.text.formatFileSize
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2file
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegexGet
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 * @ClassName UtilKFileReader
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/28
 * @Version 1.0
 */
object UtilKFileReader : IUtilK {

    @JvmStatic
    fun get(file: File): FileReader =
        FileReader(file)

    @JvmStatic
    fun get(strFilePathName: String): FileReader =
        FileReader(strFilePathName)

    /////////////////////////////////////////////////////////////

    @JvmStatic
    fun getStrProcessName(): String? =
        try {
            readLine_use("/proc/${UtilKProcess.getMyPid()}/cmdline".strFilePath2file())?.trim { it <= ' ' }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    @JvmStatic
    fun getStorageSize(): String? {
        try {
            val strLine: String = readLine_use(CPath.PROC_MEMINFO, 8192) ?: return null// 读取mem info第一行，系统总内存大小
            val strs: Array<String> = strLine.split(UtilKRegexGet.get_blanks()).toTypedArray()
            val storageSize: Long = (Integer.valueOf(strs[1]).toInt() * 1024).toLong() // 获得系统总内存，单位是KB，乘以1024转换为Byte
            return storageSize.formatFileSize() // Byte转换为KB或者MB，内存大小规格化
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    @JvmStatic
    fun readLine_use(strFilePathName: String, bufferSize: Int = 1024): String? =
        readLine_use(get(strFilePathName), bufferSize)

    @JvmStatic
    fun readLine_use(file: File, bufferSize: Int = 1024): String? =
        readLine_use(get(file), bufferSize)

    @JvmStatic
    fun readLine_use(fileReader: FileReader, bufferSize: Int = 1024): String? {
        var bufferedReader: BufferedReader? = null
        try {
            bufferedReader = fileReader.inputStreamReader2bufferedReader(bufferSize)
            return UtilKBufferedReader.readLine_use(bufferedReader)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } finally {
            bufferedReader?.close()
            fileReader.close()
        }
    }
}