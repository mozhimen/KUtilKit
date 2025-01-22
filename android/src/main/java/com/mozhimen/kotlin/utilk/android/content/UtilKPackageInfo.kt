package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageInfo
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.bases.BaseUtilK


/**
 * @ClassName UtilKPackageInfo
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 10:53
 * @Version 1.0
 */
object UtilKPackageInfo : BaseUtilK() {
    @JvmStatic
    fun get(context: Context, strPackageName: String, flags: Int): PackageInfo? =
        UtilKPackageManagerWrapper.getPackageInfoSafe(context, strPackageName, flags)

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getApplicationInfo(context: Context, strPackageName: String, flags: Int): ApplicationInfo? =
        getApplicationInfo(get(context, strPackageName, flags))

    @JvmStatic
    fun getApplicationInfo(packageInfo: PackageInfo?): ApplicationInfo? =
        packageInfo?.applicationInfo

    @JvmStatic
    fun getRequestedPermissions(context: Context, strPackageName: String, flags: Int): Array<String>? =
        getRequestedPermissions(get(context, strPackageName, flags))

    @JvmStatic
    fun getRequestedPermissions(packageInfo: PackageInfo?): Array<String>? =
        packageInfo?.requestedPermissions

    @JvmStatic
    fun getPackageName(context: Context, strPackageName: String, flags: Int): String? =
        getPackageName(get(context, strPackageName, flags))

    @JvmStatic
    fun getPackageName(packageInfo: PackageInfo?): String? =
        packageInfo?.packageName

    @JvmStatic
    fun getVersionName(context: Context, strPackageName: String, flags: Int): String? =
        getVersionName(get(context, strPackageName, flags))

    @JvmStatic
    fun getVersionName(packageInfo: PackageInfo?): String? =
        packageInfo?.versionName

    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    fun getLongVersionCode(context: Context, strPackageName: String, flags: Int): Long? =
        getLongVersionCode(get(context, strPackageName, flags))

    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    fun getLongVersionCode(packageInfo: PackageInfo?): Long? =
        packageInfo?.longVersionCode

    @JvmStatic
    fun getVersionCode(context: Context, strPackageName: String, flags: Int): Int? =
        getVersionCode(get(context, strPackageName, flags))

    @JvmStatic
    fun getVersionCode(packageInfo: PackageInfo?): Int? =
        packageInfo?.versionCode
}