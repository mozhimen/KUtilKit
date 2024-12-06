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
object UtilKPackageInfoWrapper : IUtilK {
    /**
     * 获取程序包名
     */
    @JvmStatic
    fun getVersionName(context: Context, strPackageName: String, flags: Int): String =
        UtilKPackageInfo.get(context, strPackageName, flags)?.let { getVersionName(it) } ?: ""

    @JvmStatic
    fun getVersionName(packageInfo: PackageInfo?): String =
        try {
            packageInfo?.versionName ?: ""
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "getVersionName: NameNotFoundException ${e.message}")
            ""
        }

    /**
     * 获取程序版本号
     */
    @JvmStatic
    fun getVersionCode(context: Context, strPackageName: String, flags: Int): Int =
        UtilKPackageInfo.get(context, strPackageName, flags)?.let { getVersionCode(it) } ?: 0

    @JvmStatic
    fun getVersionCode(packageInfo: PackageInfo?): Int =
        try {
            packageInfo?.let {
                (if (UtilKBuildVersion.isAfterV_28_9_P())
                    it.longVersionCode.toInt()
                else it.versionCode)
            } ?: 0
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