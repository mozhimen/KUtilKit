package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.PackageInfo
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_QUERY_ALL_PACKAGES
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
        UtilKPackageInfo.get(strPackageName, flags, _context)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getVersionCode(strPackageName: String, flags: Int): Int =
        UtilKPackageInfoWrapper.gainVersionCode(strPackageName, flags, _context)

    @JvmStatic
    fun getVersionCode(flags: Int): Int =
        UtilKPackageInfoWrapper.gainVersionCode(getPackageName(), flags, _context)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getPackageName(): String =
        UtilKContext.getPackageName(_context)

    @JvmStatic
    fun getVersionName(strPackageName: String, flags: Int): String =
        UtilKPackageInfoWrapper.gainVersionName(strPackageName, flags, _context)

    @JvmStatic
    fun getVersionName(flags: Int): String =
        UtilKPackageInfoWrapper.gainVersionName(getPackageName(), flags, _context)

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getRequestedPermissionsStr(strPackageName: String, flags: Int): String =
        UtilKPackageInfo.getRequestedPermissions(strPackageName, flags, _context).contentToString()

    @JvmStatic
    fun getRequestedPermissionsStr(flags: Int): String =
        UtilKPackageInfo.getRequestedPermissions(getPackageName(), flags, _context).contentToString()

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取所有安装程序包名
     */
    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getInstalledPackages(hasSystemPackages: Boolean): List<PackageInfo> =
        UtilKPackageManagerWrapper.getInstalledPackages(hasSystemPackages, _context)

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun hasPackage(strPackageName: String, flags: Int): Boolean =
        hasPackage_ofPackageManager_enabled(strPackageName, flags)
                || hasPackage_ofPackageInfo_enabled(strPackageName, flags)
                || hasPackage_ofPackageManager(strPackageName, flags)
                || hasPackage_ofPackageInfo(strPackageName, flags)
                || hasPackage_ofClazz("${strPackageName}.MainActivity")

    @JvmStatic
    fun hasPackage_ofPackageManager_enabled(strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfoWrapper.enabled_ofPackageManager(strPackageName, flags, _context)

    @JvmStatic
    fun hasPackage_ofPackageInfo_enabled(strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfoWrapper.enabled_ofPackageInfo(strPackageName, flags, _context)

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun hasPackage_ofPackageManager(strPackageName: String, flags: Int): Boolean =
        UtilKPackageManager.queryIntentActivities(UtilKIntentGet.getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName), flags, _context).isNotEmpty()

    @JvmStatic
    fun hasPackage_ofPackageInfo(strPackageName: String, flags: Int): Boolean =
        UtilKPackageInfoWrapper.hasPackage(strPackageName, flags, _context)

    @JvmStatic
    fun hasPackage_ofClazz(strPackageNameWithActivity: String): Boolean =
        UtilKStrClazz.isStrClassPackageExists(strPackageNameWithActivity)

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 系统的下载组件是否可用
     */
    @JvmStatic
    fun isDownloadComponentEnabled(context: Context = _context): Boolean =
        UtilKPackageManagerWrapper.isDownloadComponentEnabled(context)

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 是否有前置
     */
    @JvmStatic
    fun hasFrontCamera(): Boolean =
        UtilKPackageManagerWrapper.hasSystemFeature_CAMERA_FRONT(_context)

    /**
     * 是否有后置
     */
    @JvmStatic
    fun hasBackCamera(): Boolean =
        UtilKPackageManagerWrapper.hasSystemFeature_CAMERA(_context)
}