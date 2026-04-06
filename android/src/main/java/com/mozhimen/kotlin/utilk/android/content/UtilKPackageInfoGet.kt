package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.PackageInfo
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageInfo.get

/**
 * @ClassName UtilKPackageInfoGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/6
 * @Version 1.0
 */
object UtilKPackageInfoGet {
    @JvmStatic
    fun get_0(strPackageName: String, context: Context): PackageInfo? =
        get(strPackageName, 0, context)//0

    @JvmStatic
    fun get_GET_CONFIGURATIONS(strPackageName: String, context: Context): PackageInfo? =
        get(strPackageName, CPackageManager.GET_CONFIGURATIONS, context)

    @JvmStatic
    fun get_GET_ACTIVITIES(strPackageName: String, context: Context): PackageInfo? =
        get(strPackageName, CPackageManager.GET_ACTIVITIES, context)
}