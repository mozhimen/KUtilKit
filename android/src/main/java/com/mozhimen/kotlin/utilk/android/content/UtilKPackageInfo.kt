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
    fun get(strPackageName: String, flags: Int, context: Context = _context): PackageInfo? =
        UtilKPackageManagerWrapper.getPackageInfoSafe(strPackageName, flags, context)

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getApplicationInfo(strPackageName: String, flags: Int, context: Context): ApplicationInfo? =
        getApplicationInfo(get(strPackageName, flags, context))

    @JvmStatic
    fun getApplicationInfo(packageInfo: PackageInfo?): ApplicationInfo? =
        packageInfo?.applicationInfo

    @JvmStatic
    fun getRequestedPermissions(strPackageName: String, flags: Int, context: Context): Array<String>? =
        getRequestedPermissions(get(strPackageName, flags, context))

    @JvmStatic
    fun getRequestedPermissions(packageInfo: PackageInfo?): Array<String>? =
        packageInfo?.requestedPermissions

    @JvmStatic
    fun getPackageName(strPackageName: String, flags: Int, context: Context): String? =
        getPackageName(get(strPackageName, flags, context))

    @JvmStatic
    fun getPackageName(packageInfo: PackageInfo?): String? =
        packageInfo?.packageName

    @JvmStatic
    fun getVersionName(strPackageName: String, flags: Int, context: Context): String? =
        getVersionName(get(strPackageName, flags, context))

    @JvmStatic
    fun getVersionName(packageInfo: PackageInfo?): String? =
        packageInfo?.versionName

    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    fun getLongVersionCode(strPackageName: String, flags: Int, context: Context): Long? =
        getLongVersionCode(get(strPackageName, flags, context))

    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    fun getLongVersionCode(packageInfo: PackageInfo?): Long? =
        packageInfo?.longVersionCode

    @JvmStatic
    fun getVersionCode(strPackageName: String, flags: Int, context: Context): Int? =
        getVersionCode(get(strPackageName, flags, context))

    @JvmStatic
    fun getVersionCode(packageInfo: PackageInfo?): Int? =
        packageInfo?.versionCode
}