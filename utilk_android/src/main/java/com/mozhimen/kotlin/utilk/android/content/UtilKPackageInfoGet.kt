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
    fun get_0(context: Context, strPackageName: String): PackageInfo? =
        get(context, strPackageName, 0)//0

    @JvmStatic
    fun get_GET_CONFIGURATIONS(context: Context, strPackageName: String): PackageInfo? =
        get(context, strPackageName, CPackageManager.GET_CONFIGURATIONS)

    @JvmStatic
    fun get_GET_ACTIVITIES(context: Context, strPackageName: String): PackageInfo? =
        get(context, strPackageName, CPackageManager.GET_ACTIVITIES)
}