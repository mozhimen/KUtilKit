package com.mozhimen.kotlin.utilk.android.provider

import android.content.Context
import android.provider.Settings
import com.mozhimen.kotlin.elemk.android.provider.cons.CSettings
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion

/**
 * @ClassName UtilKSettingsSecureWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKSettingsSecureWrapper {
    //判断定位服务是否开启
    @JvmStatic
    fun isLocationModeOn(context: Context): Boolean {
        return if (UtilKBuildVersion.isAfterV_19_44_K()) {
            val locationMode = try {
                UtilKSettingsSecure.getInt(context, CSettings.Secure.LOCATION_MODE)
            } catch (e: Settings.SettingNotFoundException) {
                e.printStackTrace()
                return false
            }
            locationMode != CSettings.Secure.LOCATION_MODE_OFF
        } else {
            UtilKSettingsSecure.getString(context, CSettings.Secure.LOCATION_PROVIDERS_ALLOWED).isNotEmpty()
        }
    }
}