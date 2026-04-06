package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.NameNotFoundException
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKPackageInfoWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/6
 * @Version 1.0
 */
fun PackageInfo.gainVersionName(): String =
    UtilKPackageInfoWrapper.gainVersionName(this)

fun PackageInfo.gainVersionCode(): Int =
    UtilKPackageInfoWrapper.gainVersionCode(this)

//////////////////////////////////////////////////////////////////////

object UtilKPackageInfoWrapper : IUtilK {
    /**
     * 获取程序包名
     */
    @JvmStatic
    fun gainVersionName(strPackageName: String, flags: Int, context: Context): String =
        UtilKPackageInfo.get(strPackageName, flags, context)?.let { gainVersionName(it) } ?: ""

    @JvmStatic
    fun gainVersionName(packageInfo: PackageInfo?): String =
        try {
            UtilKPackageInfo.getVersionName(packageInfo) ?: ""
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "getVersionName: NameNotFoundException ${e.message}")
            ""
        }

    /**
     * 获取程序版本号
     */
    @JvmStatic
    fun gainVersionCode(strPackageName: String, flags: Int, context: Context): Int =
        UtilKPackageInfo.get(strPackageName, flags, context)?.let { gainVersionCode(it) } ?: 0

    @JvmStatic
    fun gainVersionCode(packageInfo: PackageInfo?): Int =
        try {
            (if (UtilKBuildVersion.isAfterV_28_9_P()) {
                UtilKPackageInfo.getLongVersionCode(packageInfo)?.toInt()
            } else {
                UtilKPackageInfo.getVersionCode(packageInfo)
            }) ?: 0
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "getVersionCode: NameNotFoundException ${e.message}")
            0
        }

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hasPackage(strPackageName: String, flags: Int, context: Context): Boolean =
        try {
            UtilKPackageInfo.get(strPackageName, flags, context) != null
        } catch (e: NameNotFoundException) {
            false
        }
}