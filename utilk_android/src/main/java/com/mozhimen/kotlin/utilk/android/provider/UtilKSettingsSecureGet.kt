package com.mozhimen.kotlin.utilk.android.provider

import android.content.Context
import com.mozhimen.kotlin.elemk.android.provider.cons.CSettings

/**
 * @ClassName UtilKSettingsSecureGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKSettingsSecureGet {
    /**
     * 等同于 [UtilKSettingsSystemGet.getString_ANDROID_ID]
     */
    @JvmStatic
    fun getString_ANDROID_ID(context: Context): String =
        UtilKSettingsSecure.getString(context, CSettings.Secure.ANDROID_ID)
}