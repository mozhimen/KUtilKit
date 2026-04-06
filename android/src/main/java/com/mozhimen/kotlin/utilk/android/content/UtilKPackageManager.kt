package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageInstaller
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PackageInfoFlags
import android.content.pm.PermissionGroupInfo
import android.content.pm.PermissionInfo
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.annors.ADescription
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.commons.IUtilK


/**
 * @ClassName UtilKPackageManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 10:50
 * @Version 1.0
 */
object UtilKPackageManager : IUtilK {

    @JvmStatic
    fun get(context: Context): PackageManager =
        UtilKContext.getPackageManager(context)

    @JvmStatic
    fun getPackageInfo(strPackageName: String, flags: Int, context: Context): PackageInfo? =
        get(context).getPackageInfo(strPackageName, flags)

    @JvmStatic
    fun getPackageArchiveInfo(archiveFilePath: String, flags: Int, context: Context): PackageInfo? =
        get(context).getPackageArchiveInfo(archiveFilePath, flags)

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getPackageInstaller(context: Context): PackageInstaller =
        get(context).packageInstaller

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getApplicationInfo(strPackageName: String, flags: Int, context: Context): ApplicationInfo =
        get(context).getApplicationInfo(strPackageName, flags)

    /**
     * 得到应用名
     */
    @JvmStatic
    fun getApplicationLabel(applicationInfo: ApplicationInfo, context: Context): String =
        get(context).getApplicationLabel(applicationInfo).toString()

    @JvmStatic
    fun getApplicationEnabledSetting(strPackageName: String, context: Context): Int =
        get(context).getApplicationEnabledSetting(strPackageName)

    /**
     * 得到图标
     */
    @JvmStatic
    fun getApplicationIcon(applicationInfo: ApplicationInfo, context: Context): Drawable =
        get(context).getApplicationIcon(applicationInfo)

    /**
     * 得到图标
     */
    @JvmStatic
    fun getApplicationIcon(strPackageName: String, context: Context): Drawable =
        get(context).getApplicationIcon(strPackageName)

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded")
    fun getInstalledPackages(flags: Int, context: Context): List<PackageInfo> =
        get(context).getInstalledPackages(flags)

    @JvmStatic
    @RequiresApi(CVersCode.V_33_13_T)
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded")
    fun getInstalledPackages(flags: PackageInfoFlags, context: Context): List<PackageInfo> =
        get(context).getInstalledPackages(flags)

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getPermissionInfo(permName: String, flags: Int, context: Context): PermissionInfo =
        get(context).getPermissionInfo(permName, flags)

    @JvmStatic
    fun getAllPermissionGroups(flags: Int, context: Context): List<PermissionGroupInfo> =
        get(context).getAllPermissionGroups(flags)

    @JvmStatic
    fun getActivityInfo(component: ComponentName, flags: Int, context: Context): ActivityInfo =
        get(context).getActivityInfo(component, flags)

    @JvmStatic
    fun getLaunchIntentForPackage(strPackageName: String, context: Context): Intent? =
        get(context).getLaunchIntentForPackage(strPackageName)

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 是否有配置
     */
    @JvmStatic
    fun hasSystemFeature(featureName: String, context: Context): Boolean =
        get(context).hasSystemFeature(featureName)

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 是否有包安装权限
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OUsesPermission_REQUEST_INSTALL_PACKAGES
    @ADescription(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)
    fun canRequestPackageInstalls(context: Context): Boolean =
        if (UtilKBuildVersion.isAfterV_26_8_O())
            get(context).canRequestPackageInstalls()
        else true

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询所有的符合Intent的Activities
     */
    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded")
    fun queryIntentActivities(intent: Intent, flags: Int, context: Context): List<ResolveInfo> =
        get(context).queryIntentActivities(intent, flags)

    @JvmStatic
    fun queryIntentServices(intent: Intent, flags: Int, context: Context): List<ResolveInfo> =
        get(context).queryIntentServices(intent, flags)

    @JvmStatic
    fun queryBroadcastReceivers(intent: Intent, flags: Int, context: Context): List<ResolveInfo> =
        get(context).queryBroadcastReceivers(intent, flags)
}