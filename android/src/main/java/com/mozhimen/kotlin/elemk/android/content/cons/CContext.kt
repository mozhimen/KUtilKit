package com.mozhimen.kotlin.elemk.android.content.cons

import android.content.Context
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode


/**
 * @ClassName CContext
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CContext {
    const val MODE_PRIVATE = Context.MODE_PRIVATE
    const val VIBRATOR_SERVICE = Context.VIBRATOR_SERVICE

    @RequiresApi(CVersCode.V_31_12_S)
    const val VIBRATOR_MANAGER_SERVICE = Context.VIBRATOR_MANAGER_SERVICE
    const val WINDOW_SERVICE = Context.WINDOW_SERVICE
    const val INPUT_METHOD_SERVICE = Context.INPUT_METHOD_SERVICE
    const val TELEPHONY_SERVICE = Context.TELEPHONY_SERVICE
    const val WIFI_SERVICE = Context.WIFI_SERVICE
    const val AUDIO_SERVICE = Context.AUDIO_SERVICE
    const val CONNECTIVITY_SERVICE = Context.CONNECTIVITY_SERVICE
    const val DISPLAY_SERVICE = Context.DISPLAY_SERVICE
    const val ACTIVITY_SERVICE = Context.ACTIVITY_SERVICE
    const val USB_SERVICE = Context.USB_SERVICE
    const val LAYOUT_INFLATER_SERVICE = Context.LAYOUT_INFLATER_SERVICE
    const val LOCATION_SERVICE = Context.LOCATION_SERVICE
    const val DOWNLOAD_SERVICE = Context.DOWNLOAD_SERVICE
    const val NOTIFICATION_SERVICE = Context.NOTIFICATION_SERVICE
    const val UI_MODE_SERVICE = Context.UI_MODE_SERVICE
    const val CLIPBOARD_SERVICE = Context.CLIPBOARD_SERVICE
    const val SENSOR_SERVICE = Context.SENSOR_SERVICE
    const val INPUT_SERVICE = Context.INPUT_SERVICE

    @RequiresApi(CVersCode.V_21_5_L)
    const val CAMERA_SERVICE = Context.CAMERA_SERVICE

    const val POWER_SERVICE = Context.POWER_SERVICE
}