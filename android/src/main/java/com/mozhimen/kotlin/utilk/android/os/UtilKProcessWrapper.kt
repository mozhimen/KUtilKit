package com.mozhimen.kotlin.utilk.android.os

import android.text.TextUtils
import com.mozhimen.kotlin.utilk.java.io.inputStream2inputStreamReader
import com.mozhimen.kotlin.utilk.java.io.inputStreamReader2bufferedReader
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2fileInputStream
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * @ClassName UtilKProcessWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/15 19:10
 * @Version 1.0
 */
object UtilKProcessWrapper {

    /**
     * 介绍过使用adb命令查看进程的内存开销。但是如果需要持续监控的话，需要另外的方法。
     * 网上查找了下 使用ActivityManager 中的 getProcessMemoryInfo()方法可以获取到进程运行时内存，但是这个接口在 android P以上 限频了，拿到的内存可能是过去时间的，不能实时呈现运行时内存。而且不同的手机限频的时间不固定。
     * 因此本文介绍的是另外一种方法：通过读取
     *
     * 读文件获取运行时内存（RSS)
     *
     * 优点：暂时没有权限限制，实时获取
     * 缺点：这种读文件的方法拿到的内存是RSS。我们通常期望获取的是PSS
     *
     * RSS和PSS 的区别：
     *
     * RSS - Resident Set Size 实际使用物理内存（包含共享库占用的内存）
     * PSS - Proportional Set Size 实际使用的物理内存（比例分配共享库占用的内存）假如有3个进程使用同一个共享库，那么每个进程的PSS就包括了1/3大小的共享库内存。通常我们使用PSS大小来作为内存性能指标。
     */
    @JvmStatic
    fun getMemorySize_realtime(): Int {
        val strFilePathNameStatus = "/proc/${UtilKProcess.getMyPid()}/status"
        var fileInputStream: FileInputStream? = null
        var inputStreamReader: InputStreamReader? = null
        var bufferedReader: BufferedReader? = null
        try {
            fileInputStream = strFilePathNameStatus.strFilePath2fileInputStream()
            inputStreamReader = fileInputStream.inputStream2inputStreamReader("UTF-8")
            bufferedReader = inputStreamReader.inputStreamReader2bufferedReader()
            var line = ""
            while (bufferedReader.readLine()?.also { line = it } != null) {
                if (!TextUtils.isEmpty(line) && line.contains("VmRSS")) {
                    val rss = line.split(":")[1].trim().split(" ")[0]
                    return Integer.parseInt(rss) * 1024
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            bufferedReader?.close()
            inputStreamReader?.close()
            fileInputStream?.close()
        }
        return -1
    }
}