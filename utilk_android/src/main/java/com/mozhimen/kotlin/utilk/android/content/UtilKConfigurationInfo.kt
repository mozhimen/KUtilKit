package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.ConfigurationInfo
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityManager

/**
 * @ClassName UtilKConfigurationInfo
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/13
 * @Version 1.0
 */
object UtilKConfigurationInfo {
    @JvmStatic
    fun get(context: Context): ConfigurationInfo =
        UtilKActivityManager.getDeviceConfigurationInfo(context)

    @JvmStatic
    fun getRegGlEsVersion(context: Context): Int =
        get(context).reqGlEsVersion

    @JvmStatic
    fun getIntRegGlEsVersion(context: Context): Int =
        if (getRegGlEsVersion(context) >= 0x30000) 3 else 2
}