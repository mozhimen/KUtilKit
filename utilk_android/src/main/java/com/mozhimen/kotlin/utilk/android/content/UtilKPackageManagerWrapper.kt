package com.mozhimen.kotlin.utilk.android.content

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.PackageInfoFlags
import android.text.TextUtils
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.elemk.android.os.cons.CProcess
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageInfo
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageManager.TAG
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper

/**
 * @ClassName UtilKPackageManagerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/21
 * @Version 1.0
 */
object UtilKPackageManagerWrapper {
    @JvmStatic
    fun getPackageInfoSafe(context: Context, strPackageName: String, flags: Int): PackageInfo? =
        try {
            UtilKPackageManager.getPackageInfo(context, strPackageName, flags)
        } catch (e: Exception) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "getPackageInfo: ", e)
            null
        }

    @JvmStatic
    fun getApplicationInfo_INSTALL_LOCATION_AUTO(context: Context, strPackageName: String): ApplicationInfo =
        UtilKPackageManager.getApplicationInfo(context, strPackageName, CPackageInfo.INSTALL_LOCATION_AUTO)

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getInstalledPackages_GET_ACTIVITIES(context: Context): List<PackageInfo> =
        UtilKPackageManager.getInstalledPackages(context, CPackageManager.GET_ACTIVITIES)

    @JvmStatic
    fun getActivityInfo_GET_ACTIVITIES(context: Context, packageClazzName: String, activityClazzName: String): ActivityInfo =
        UtilKPackageManager.getActivityInfo(context, ComponentName(packageClazzName, activityClazzName), CPackageManager.GET_ACTIVITIES)

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getInstalledPackages(context: Context): List<PackageInfo> {
//        val flags = CPackageManager.GET_ACTIVITIES or CPackageManager.GET_SERVICES
        val flags = CPackageManager.GET_META_DATA
        val installedPackageInfos: List<PackageInfo> = if (UtilKBuildVersion.isAfterV_33_13_T()) {
            UtilKPackageManager.getInstalledPackages(context, PackageInfoFlags.of(flags.toLong()))
        } else {
            UtilKPackageManager.getInstalledPackages(context, flags)
        }
        return installedPackageInfos
    }

    //////////////////////////////////////////////////////////////////////////////////////

//    fun getService(context: Context, action: String, serviceClazz: Class<*>): Boolean? {
//        try {
//            val intent = Intent()
//            intent.setAction(action)
//            intent.setPackage(UtilKContext.getPackageName(context))
//            val resolveInfos = UtilKPackageManager.queryIntentServices(context, intent, 0)
//            for (resolveInfo in resolveInfos) {
//                val serviceInfo = resolveInfo.serviceInfo ?: continue
//                val className = serviceInfo.name
//                if (className.isEmpty()) continue
//                val clazz = Class.forName(className)
//                // MTCommonService是clazz的父类
//                if (serviceClazz.isAssignableFrom(clazz)) {
//                    return clazz.canonicalName.also { commonServiceName = it }
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return ""
//    }

    /**
     * 获取所有安装程序包名
     */
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getInstalledPackages(context: Context, hasSystemPackages: Boolean): List<PackageInfo> {
        var installedPackages = getInstalledPackages(context).toMutableList()
        if (installedPackages.isEmpty()) {
            installedPackages = getInstalledPackages_ofForce(context).toMutableList()
        }
        if (!hasSystemPackages) {
            val iterator = installedPackages.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (UtilKApplicationInfoWrapper.isSystemApp(next.applicationInfo))
                    iterator.remove()
            }
        }
        return installedPackages
    }

    /**
     * 强制获取软件包列表
     * @return 获取查询到的应用列表
     */
    @JvmStatic
    fun getInstalledPackages_ofForce(context: Context): List<PackageInfo> {
        val installedPackages = mutableListOf<PackageInfo>()
        val packageManager = UtilKPackageManager.get(context)
        for (uid in CProcess.SYSTEM_UID..CProcess.LAST_APPLICATION_UID) {
            val packagesForUid = try {
                packageManager.getPackagesForUid(uid)
            } catch (e: Exception) {
                null
            }
            packagesForUid?.forEach { strPackageName ->
                val packageInfo = try {
                    packageManager.getPackageInfo(strPackageName, 0)
                } catch (e: Exception) {
                    null
                }
                packageInfo?.let {
                    installedPackages.add(packageInfo)
                }
            }
        }
        return installedPackages
    }

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 是否有前置
     */
    @JvmStatic
    fun hasFrontCamera(context: Context): Boolean =
        UtilKPackageManager.hasSystemFeature(context, CPackageManager.FEATURE_CAMERA_FRONT)

    /**
     * 是否有后置
     */
    @JvmStatic
    fun hasBackCamera(context: Context): Boolean =
        UtilKPackageManager.hasSystemFeature(context, CPackageManager.FEATURE_CAMERA)

    /**
     * 系统的下载组件是否可用
     */
    @JvmStatic
    fun isDownloadComponentEnabled(context: Context): Boolean {
        try {
            val setting = UtilKPackageManager.getApplicationEnabledSetting(context, CStrPackage.com_android_providers_downloads)
            if (setting == CPackageManager.COMPONENT_ENABLED_STATE_DISABLED || setting == CPackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER || setting == CPackageManager.COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED)
                return false
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }
}