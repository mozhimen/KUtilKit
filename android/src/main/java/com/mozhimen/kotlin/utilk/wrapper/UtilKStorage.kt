package com.mozhimen.kotlin.utilk.wrapper

import com.mozhimen.kotlin.utilk.android.os.UtilKStatFsWrapper
import com.mozhimen.kotlin.utilk.wrapper.UtilKDevice.hasExternalStorage
import java.io.File

/**
 * @ClassName UtilKStorage
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/7/18
 * @Version 1.0
 */
object UtilKStorage {

    @JvmStatic
    fun getFolderSize(files: List<File>): Long =
        files.sumOf { it.length() }

    /////////////////////////////////////////////////////////////////////

    /**
     * 本地存储可用大小
     */
    @JvmStatic
    fun getStrInternalStorageSize_ofFree(): String =
        UtilKStatFsWrapper.getStrExternalDataStorageSize_ofFree()

    @JvmStatic
    fun getStrInternalStorageSize_ofAvailable(): String =
        UtilKStatFsWrapper.getStrExternalDataStorageSize_ofAvailable()

    /**
     * 获取手机内部空间大小
     */
    @JvmStatic
    fun getStrInternalStorageSize_ofTotal(): String =
        UtilKStatFsWrapper.getStrExternalDataStorageSize_ofTotal()

    /**
     * 获取手机空闲空间大小
     */
    @JvmStatic
    fun getStrExternalStorageSize_ofFree(): String =
        if (hasExternalStorage()) {
            UtilKStatFsWrapper.getStrExternalStorageStorageSize_ofFree()
        } else "0"

    @JvmStatic
    fun getStrExternalStorageSize_ofAvailable(): String =
        if (hasExternalStorage()) {
            UtilKStatFsWrapper.getStrExternalStorageStorageSize_ofAvailable()
        } else "0"

    /**
     * 获取手机外部空间大小
     */
    @JvmStatic
    fun getStrExternalStorageSize_ofTotal(): String =
        if (hasExternalStorage()) {
            UtilKStatFsWrapper.getStrExternalStorageStorageSize_ofTotal()
        } else "0"

    /////////////////////////////////////////////////////////////////////
    /**
     * 本地存储可用大小
     */
    @JvmStatic
    fun getInternalStorageSize_ofFree(): Long =
        UtilKStatFsWrapper.getExternalDataStorageSize_ofFree()

    @JvmStatic
    fun getInternalStorageSize_ofAvailable(): Long =
        UtilKStatFsWrapper.getExternalDataStorageSize_ofAvailable()

    /**
     * 获取手机内部空间大小
     */
    @JvmStatic
    fun getInternalStorageSize_ofTotal(): Long =
        UtilKStatFsWrapper.getExternalDataStorageSize_ofTotal()

    /**
     * 获取手机空闲空间大小
     */
    @JvmStatic
    fun getExternalStorageSize_ofFree(): Long =
        if (hasExternalStorage())
            UtilKStatFsWrapper.getExternalStorageStorageSize_ofFree()
        else 0L

    @JvmStatic
    fun getExternalStorageSize_ofAvailable(): Long =
        if (hasExternalStorage())
            UtilKStatFsWrapper.getExternalStorageStorageSize_ofAvailable()
        else 0L

    /**
     * 获取手机外部空间大小
     */
    @JvmStatic
    fun getExternalStorageSize_ofTotal(): Long =
        if (hasExternalStorage())
            UtilKStatFsWrapper.getExternalStorageSize_ofTotal()
        else 0L
}