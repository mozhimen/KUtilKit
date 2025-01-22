package com.mozhimen.kotlin.utilk.android.provider

import android.content.Context
import com.mozhimen.kotlin.elemk.android.provider.cons.CSettings

/**
 * @ClassName UtilKSettingsSystemGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKSettingsSystemGet {
    /**
     * 等同于 [UtilKSettingsSecureGet.getString_ANDROID_ID]
     */
    @JvmStatic
    fun getString_ANDROID_ID(context: Context): String =
        UtilKSettingsSystem.getString(context, CSettings.System.ANDROID_ID)
}