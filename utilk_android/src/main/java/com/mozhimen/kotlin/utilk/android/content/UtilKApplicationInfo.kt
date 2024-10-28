package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.annotation.IdRes
import com.mozhimen.kotlin.elemk.android.content.cons.CApplicationInfo
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKApplicationInfo
 * @Description TODO
 * @Author Mozhimen & Kolin
 * @Date 2023/4/18 11:24
 * @Version 1.0
 */
object UtilKApplicationInfo : IUtilK {

    @JvmStatic
    fun get(context: Context): ApplicationInfo =
        UtilKContext.getApplicationInfo(context)

    @JvmStatic
    fun get_ofPackageInfo(context: Context, strPackageName: String, flags: Int): ApplicationInfo? =
        UtilKPackageInfo.getApplicationInfo(context, strPackageName, flags)

    @JvmStatic
    fun get_ofPackageManager(context: Context, strPackageName: String, flags: Int): ApplicationInfo =
        UtilKPackageManager.getApplicationInfo(context, strPackageName, flags)

    //////////////////////////////////////////////////////////////////////

    //得到包名
    @JvmStatic
    fun getPackageName(context: Context): String =
        getPackageName(get(context))

    //得到包名
    @JvmStatic
    fun getPackageName(applicationInfo: ApplicationInfo): String =
        applicationInfo.packageName

    @JvmStatic
    fun getFlags(context: Context): Int =
        getFlags(get(context))

    @JvmStatic
    fun getFlags(applicationInfo: ApplicationInfo): Int =
        applicationInfo.flags

    @JvmStatic
    fun getIcon(context: Context): Int =
        getIcon(get(context))

    @JvmStatic
    fun getIcon(applicationInfo: ApplicationInfo): Int =
        applicationInfo.icon

    /**
     * 和这个方法一样[UtilKPackageManager.getApplicationIcon]
     */
    @JvmStatic
    fun loadIcon(context: Context, packageManager: PackageManager): Drawable? =
        loadIcon(get(context), packageManager)

    /**
     * 和这个方法一样[UtilKPackageManager.getApplicationIcon]
     */
    @JvmStatic
    fun loadIcon(applicationInfo: ApplicationInfo?, packageManager: PackageManager): Drawable? =
        applicationInfo?.loadIcon(packageManager)

    @JvmStatic
    fun enabled(applicationInfo: ApplicationInfo): Boolean =
        applicationInfo.enabled

    //////////////////////////////////////////////////////////////////////

    //app的目标版本
    @JvmStatic
    fun getTargetSdkVersion(context: Context): Int =
        get(context).targetSdkVersion

    @JvmStatic
    @IdRes
    fun getLabelRes(context: Context): Int =
        get(context).labelRes

    @SuppressLint("ResourceType")
    @JvmStatic
    fun getLabelResStr(context: Context): String {
        try {
            val intResStr:Int = getLabelRes(context)
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
        enabled(get_ofPackageManager(context, strPackageName, flags))

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
        enabled(get_ofPackageManager(context, strPackageName, flags))

    @JvmStatic
    fun enabled_ofPackageInfo(context: Context, strPackageName: String, flags: Int): Boolean {
        return try {
            enabled_ofPackageInfo_throw(context, strPackageName, flags)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }
    }
}

