package com.mozhimen.kotlin.utilk.java.io

import android.util.Log
import com.mozhimen.kotlin.elemk.cons.CPath
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.RandomAccessFile
import kotlin.math.min


/**
 * @ClassName UtilKRandomAccessFileWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/29
 * @Version 1.0
 */
object UtilKRandomAccessFileWrapper : IUtilK {
    //cpu使用率
    @JvmStatic
    fun getCpuUsage(): Float {
        var randomAccessFile: RandomAccessFile? = null
        try {
            randomAccessFile = UtilKRandomAccessFile.get(CPath.SYSTEM_XBIN_WHICH, "r")
            var strLine: String = UtilKRandomAccessFile.readLine(randomAccessFile)
            var toks = strLine.split(" ".toRegex()).toTypedArray()
            val idle = toks[5].toLong()
            val cpu = toks[2].toLong() + toks[3].toLong() + toks[4].toLong() + toks[6].toLong() + toks[7].toLong() + toks[8].toLong()
            Thread.sleep(360)

            ///////////////////////////////////////////////////////

            randomAccessFile.seek(0)
            strLine = UtilKRandomAccessFile.readLine(randomAccessFile)
            toks = strLine.split(" ".toRegex()).toTypedArray()
            val newIdle = toks[5].toLong()
            val newCpu = toks[2].toLong() + toks[3].toLong() + toks[4].toLong() + toks[6].toLong() + toks[7].toLong() + toks[8].toLong()
            return (newCpu - cpu).toFloat() / (newCpu + newIdle - (cpu + idle))
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            randomAccessFile?.close()
        }
        return 0f
    }

    @Throws(IOException::class)
    fun removeBytesFromFile(file: File, startIndex: Int, endIndex: Int): Boolean {
        if (startIndex !in 0..file.length() || startIndex >= endIndex) {
            Log.d(TAG, "removeBytesFromFile: startInvalid")
            return false
        }
        if (endIndex !in 0..file.length()) {
            Log.d(TAG, "removeBytesFromFile: endInvalid")
            return false
        }

        val fileTemp = File(file.absolutePath + ".tmp")
        RandomAccessFile(file, "r").use { raf ->
            FileOutputStream(fileTemp).use { fos ->
                val fileSize = raf.length()
                // 检查范围是否有效
                require(!(startIndex < 0 || endIndex >= fileSize || startIndex >= endIndex)) { "Invalid byte range." }

                // 分块大小
                val buffer = ByteArray(4096) // 每次读取 4KB
                var bytesRead = 0

                // 第一部分：复制从文件开始到 start 之前的字节
                raf.seek(0)
                var remainingBytes = startIndex
                while (remainingBytes > 0 && (raf.read(buffer, 0, min(buffer.size, remainingBytes)).also { bytesRead = it }) != -1) {
                    fos.write(buffer, 0, bytesRead)
                    remainingBytes -= bytesRead
                }

                // 跳过要删除的字节
                raf.seek(endIndex.toLong())

                // 第二部分：从 end+1 开始，复制剩下的字节
                while ((raf.read(buffer).also { bytesRead = it }) != -1) {
                    fos.write(buffer, 0, bytesRead)
                }
            }
        }
        // 删除原文件并重命名临时文件为原文件名
        if (!UtilKFileWrapper.deleteFile(file)) {
            Log.e(TAG, "removeBytesFromFile: Failed to delete ori file.")
            return false
        }
        if (!fileTemp.renameTo(file)) {
            Log.e(TAG, "removeBytesFromFile: Failed to rename temporary file.")
        }

        Log.d(TAG, "removeBytesFromFile: File modified successfully.")
        return true
    }
}