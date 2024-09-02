package com.mozhimen.kotlin.utilk.wrapper

import android.content.Context
import com.mozhimen.kotlin.utilk.android.content.UtilKConfiguration
import com.mozhimen.kotlin.utilk.androidx.appcompat.UtilKAppCompatDelegate

/**
 * @ClassName UtilKConfig
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/3/3 21:31
 * @Version 1.0
 */
object UtilKConfig {
    @JvmStatic
    fun isLightMode_ofAppCompatDelegate(): Boolean =
        UtilKAppCompatDelegate.isLightMode()

    @JvmStatic
    fun isLightMode_ofConfiguration(context: Context): Boolean =
        UtilKConfiguration.isLightMode_ofApp(context)

    @JvmStatic
    fun isNightMode_ofAppCompatDelegate(): Boolean =
        UtilKAppCompatDelegate.isNightMode()

    @JvmStatic
    fun isNightMode_ofConfiguration(context: Context): Boolean =
        UtilKConfiguration.isNightMode_ofApp(context)
}