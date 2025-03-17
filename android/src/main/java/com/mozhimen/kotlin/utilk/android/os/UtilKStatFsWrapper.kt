package com.mozhimen.kotlin.utilk.android.os

import com.mozhimen.kotlin.utilk.android.text.formatFileSize

/**
 * @ClassName UtilKStatsFsWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/7/18
 * @Version 1.0
 */
object UtilKStatFsWrapper {
    /**
     * 本地存储可用大小
     */
    @JvmStatic
    fun getExternalDataStorageSize_ofFree(): Long {
        val statFs = UtilKStatFs.get_ofExternalData()
        return UtilKStatFs.getFreeBlocksLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }

    /**
     * 获取手机内部空间大小
     */
    @JvmStatic
    fun getExternalDataStorageSize_ofAvailable(): Long {
        val statFs = UtilKStatFs.get_ofExternalData()//Gets the Android data directory
        return UtilKStatFs.getAvailableBlocksLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }


    @JvmStatic
    fun getExternalDataStorageSize_ofTotal(): Long {
        val statFs = UtilKStatFs.get_ofExternalData()//Gets the Android data directory
        return UtilKStatFs.getBlockCountLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }

    @JvmStatic
    fun getExternalStorageStorageSize_ofFree(): Long {
        val statFs = UtilKStatFs.get_ofExternalStorage()
        return UtilKStatFs.getFreeBlocksLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }

    @JvmStatic
    fun getExternalStorageStorageSize_ofAvailable(): Long {
        val statFs = UtilKStatFs.get_ofExternalStorage()
        return UtilKStatFs.getAvailableBlocksLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }

    @JvmStatic
    fun getExternalStorageSize_ofTotal(): Long {
        val statFs = UtilKStatFs.get_ofExternalStorage()
        return UtilKStatFs.getBlockCountLong(statFs) * UtilKStatFs.getBlockSizeLong(statFs)
    }

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getStrExternalDataStorageSize_ofFree(): String =
        getExternalDataStorageSize_ofFree().formatFileSize()

    @JvmStatic
    fun getStrExternalDataStorageSize_ofAvailable(): String =
        getExternalDataStorageSize_ofAvailable().formatFileSize()

    @JvmStatic
    fun getStrExternalDataStorageSize_ofTotal(): String =
        getExternalDataStorageSize_ofTotal().formatFileSize()

    @JvmStatic
    fun getStrExternalStorageStorageSize_ofFree(): String =
        getExternalStorageStorageSize_ofFree().formatFileSize()

    @JvmStatic
    fun getStrExternalStorageStorageSize_ofAvailable(): String =
        getExternalStorageStorageSize_ofAvailable().formatFileSize()

    @JvmStatic
    fun getStrExternalStorageStorageSize_ofTotal(): String =
        getExternalStorageSize_ofTotal().formatFileSize()

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isEnough_ofFileSize(fileSize: Long): Boolean {
        return getExternalStorageStorageSize_ofAvailable() >= fileSize
    }
}