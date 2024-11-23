package com.mozhimen.kotlin.utilk.java.io

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.io.File
import java.io.FileDescriptor
import java.io.FileInputStream

/**
 * @ClassName UtilKFileInputStream
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/28
 * @Version 1.0
 */
object UtilKFileInputStream : IUtilK {
    @JvmStatic
    fun get(strFilePathName: String): FileInputStream =
        FileInputStream(strFilePathName)

    @JvmStatic
    fun get(file: File): FileInputStream =
        FileInputStream(file)

    @JvmStatic
    fun get(fileDescriptor: FileDescriptor): FileInputStream =
        FileInputStream(fileDescriptor)

    @JvmStatic
    fun get_ofSafe(file: File): FileInputStream? =
        try {
            get(file)
        } catch (e: Exception) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "get: ", e)
            null
        }
}