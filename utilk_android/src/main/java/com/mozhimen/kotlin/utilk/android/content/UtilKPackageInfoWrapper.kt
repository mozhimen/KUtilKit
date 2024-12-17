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
    fun gainVersionName(context: Context, strPackageName: String, flags: Int): String =
        UtilKPackageInfo.get(context, strPackageName, flags)?.let { gainVersionName(it) } ?: ""

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
    fun gainVersionCode(context: Context, strPackageName: String, flags: Int): Int =
        UtilKPackageInfo.get(context, strPackageName, flags)?.let { gainVersionCode(it) } ?: 0

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
    fun hasPackage(context: Context, strPackageName: String, flags: Int): Boolean =
        try {
            UtilKPackageInfo.get(context, strPackageName, flags) != null
        } catch (e: NameNotFoundException) {
            false
        }
}