package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.ApplicationInfo
import com.mozhimen.kotlin.elemk.android.content.cons.CApplicationInfo

/**
 * @ClassName UtilKApplicationInfoWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/28
 * @Version 1.0
 */
object UtilKApplicationInfoWrapper {
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