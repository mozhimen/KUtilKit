package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.mozhimen.kotlin.elemk.android.content.cons.CApplicationInfo
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes

/**
 * @ClassName UtilKApplicationInfoWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/28
 * @Version 1.0
 */
object UtilKApplicationInfoWrapper {

    @JvmStatic
    fun getMetaDataStr(context: Context, strPackageName: String, flags: Int, strMetaData: String): String =
        getMetaDataStr(UtilKApplicationInfo.get_ofPackageManager(context, strPackageName, flags), strMetaData)

    @JvmStatic
    fun getMetaDataStr(applicationInfo: ApplicationInfo, strMetaDataName: String): String {
        try {
            return UtilKApplicationInfo.getMetaData(applicationInfo).getString(strMetaDataName) ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    @SuppressLint("ResourceType")
    @JvmStatic
    fun getLabelResStr(context: Context): String {
        try {
            val intResStr: Int = UtilKApplicationInfo.getLabelRes(context)
            if (intResStr == 0) return ""
            return UtilKRes.getString_ofContext(context, intResStr)
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun enabled_ofPackageManager_throw(context: Context, strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfo.enabled(UtilKApplicationInfo.get_ofPackageManager(context, strPackageName, flags))

    @JvmStatic
    fun enabled_ofPackageManager(context: Context, strPackageName: String, flags: Int): Boolean {
        return try {
            enabled_ofPackageManager_throw(context, strPackageName, flags)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }
    }

    @JvmStatic
    fun enabled_ofPackageInfo_throw(context: Context, strPackageName: String, flags: Int): Boolean =
        UtilKApplicationInfo.enabled(UtilKApplicationInfo.get_ofPackageManager(context, strPackageName, flags))

    @JvmStatic
    fun enabled_ofPackageInfo(context: Context, strPackageName: String, flags: Int): Boolean {
        return try {
            enabled_ofPackageInfo_throw(context, strPackageName, flags)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isSystemApp(context: Context): Boolean =
        isSystemApp(UtilKApplicationInfo.get(context))

    @JvmStatic
    fun isSystemApp(applicationInfo: ApplicationInfo): Boolean =
        (UtilKApplicationInfo.getFlags(applicationInfo) and CApplicationInfo.FLAG_SYSTEM) != 0

    ////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isSystemUpdateApp(context: Context): Boolean =
        isSystemUpdateApp(UtilKApplicationInfo.get(context))

    @JvmStatic
    fun isSystemUpdateApp(applicationInfo: ApplicationInfo): Boolean =
        (UtilKApplicationInfo.getFlags(applicationInfo) and CApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0

    ////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isSystemOrSystemUpdateApp(context: Context): Boolean =
        isSystemOrSystemUpdateApp(UtilKApplicationInfo.get(context))

    @JvmStatic
    fun isSystemOrSystemUpdateApp(applicationInfo: ApplicationInfo): Boolean =
        isSystemApp(applicationInfo) || isSystemUpdateApp(applicationInfo)

    ////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isUserApp(context: Context): Boolean =
        isUserApp(UtilKApplicationInfo.get(context))

    @JvmStatic
    fun isUserApp(applicationInfo: ApplicationInfo): Boolean =
        !isSystemApp(applicationInfo) && !isSystemUpdateApp(applicationInfo)
}