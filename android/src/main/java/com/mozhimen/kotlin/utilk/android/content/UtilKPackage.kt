package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.PackageInfo
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrClazz


/**
 * @ClassName UtilKPackage
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/21 16:19
 * @Version 1.0
 */
object UtilKPackage : BaseUtilK() {
    @JvmStatic
    fun getPackageInfo(strPackageName: String, flags: Int): PackageInfo? =
        UtilKPackageInfo.get(_context, strPackageName, flags)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getVersionCode(strPackageName: String, flags: Int): Int =
        UtilKPackageInfoWrapper.gainVersionCode(_context, strPackageName, flags)

    @JvmStatic
    fun getVersionCode(flags: Int): Int =
        UtilKPackageInfoWrapper.gainVersionCode(_context, getPackageName(), flags)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getPackageName(): String =
        UtilKContext.getPackageName(_context)

    @JvmStatic
    fun getVersionName(strPackageName: String, flags: Int): String =
        UtilKPackageInfoWrapper.gainVersionName(_context, strPackageName, flags)

    @JvmStatic
    fun getVersionName(flags: Int): String =
        UtilKPackageInfoWrapper.gainVersionName(_context, getPackageName(), flags)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getRequestedPermissionsStr(strPackageName: String, flags: Int): String =
        UtilKPackageInfo.getRequestedPermissions(_context, strPackageName, flags).contentToString()

    @JvmStatic
    fun getRequestedPermissionsStr(flags: Int): String =
        UtilKPackageInfo.getRequestedPermissions(_context, getPackageName(), flags).contentToString()

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取所有安装程序包名
     */
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getInstalledPackages(hasSystemPackages: Boolean): List<PackageInfo> =
        UtilKPackageManagerWrapper.getInstalledPackages(_context, hasSystemPackages)

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun hasPackage(strPackageName: String, flags: Int): Boolean =
        hasPackage_ofPackageManager_enabled(strPackageName, flags)
                || hasPackage_ofPackageInfo_enabled(strPackageName, flags)
                || hasPackage_ofPackageManager(strPackageName, flags)
                || hasPackage_ofPackageInfo(strPackageName, flags)
                || hasPackage_ofClazz("${strPackageName}.MainActivity")

    @JvmStatic
    fun hasPackage_ofPackageManager_enabled(strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfoWrapper.enabled_ofPackageManager(_context, strPackageName, flags)

    @JvmStatic
    fun hasPackage_ofPackageInfo_enabled(strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfoWrapper.enabled_ofPackageInfo(_context, strPackageName, flags)

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun hasPackage_ofPackageManager(strPackageName: String, flags: Int): Boolean =
        UtilKPackageManager.queryIntentActivities(_context, UtilKIntentGet.getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName), flags).isNotEmpty()

    @JvmStatic
    fun hasPackage_ofPackageInfo(strPackageName: String, flags: Int): Boolean =
        UtilKPackageInfoWrapper.hasPackage(_context, strPackageName, flags)

    @JvmStatic
    fun hasPackage_ofClazz(strPackageNameWithActivity: String): Boolean =
        UtilKStrClazz.isStrClassPackageExists(strPackageNameWithActivity)

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 系统的下载组件是否可用
     */
    @JvmStatic
    fun isDownloadComponentEnabled(context:Context = _context): Boolean =
        UtilKPackageManagerWrapper.isDownloadComponentEnabled(context)

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 是否有前置
     */
    @JvmStatic
    fun hasFrontCamera(): Boolean =
        UtilKPackageManagerWrapper.hasSystemFeature_camera_front(_context)

    /**
     * 是否有后置
     */
    @JvmStatic
    fun hasBackCamera(): Boolean =
        UtilKPackageManagerWrapper.hasSystemFeature_camera(_context)
}