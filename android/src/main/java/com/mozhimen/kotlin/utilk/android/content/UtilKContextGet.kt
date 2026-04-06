package com.mozhimen.kotlin.utilk.android.content

import android.app.ActivityManager
import android.app.DownloadManager
import android.app.NotificationManager
import android.app.UiModeManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.PowerManager
import android.os.Vibrator
import android.os.VibratorManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.content.cons.CContext
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName UtilKContextGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/26
 * @Version 1.0
 */
object UtilKContextGet {
    @JvmStatic
    fun getSystemService_INPUT(context: Context): InputManager =
        UtilKContext.getSystemService(CContext.INPUT_SERVICE, context) as InputManager

    @JvmStatic
    fun getSystemService_SENSOR(context: Context): SensorManager =
        UtilKContext.getSystemService(CContext.SENSOR_SERVICE, context) as SensorManager

    @JvmStatic
    fun getSystemService_UI_MODE(context: Context): UiModeManager =
        UtilKContext.getSystemService(CContext.UI_MODE_SERVICE, context) as UiModeManager

    @JvmStatic
    fun getSystemService_DOWNLOAD(context: Context): DownloadManager =
        UtilKContext.getSystemService(CContext.DOWNLOAD_SERVICE, context) as DownloadManager

    @JvmStatic
    fun getSystemService_LOCATION(context: Context): LocationManager =
        UtilKContext.getSystemService(CContext.LOCATION_SERVICE, context) as LocationManager

    @JvmStatic
    fun getSystemService_VIBRATOR(context: Context): Vibrator =
        UtilKContext.getSystemService(CContext.VIBRATOR_SERVICE, context) as Vibrator

    @RequiresApi(CVersCode.V_31_12_S)
    @JvmStatic
    fun getSystemService_VIBRATOR_MANAGER(context: Context): VibratorManager =
        UtilKContext.getSystemService(CContext.VIBRATOR_MANAGER_SERVICE, context) as VibratorManager

    @JvmStatic
    fun getSystemService_WINDOW(context: Context): WindowManager =
        UtilKContext.getSystemService(CContext.WINDOW_SERVICE, context) as WindowManager

    @JvmStatic
    fun getSystemService_INPUT_METHOD(context: Context): InputMethodManager =
        UtilKContext.getSystemService(CContext.INPUT_METHOD_SERVICE, context) as InputMethodManager

    @JvmStatic
    fun getSystemService_TELEPHONY(context: Context): TelephonyManager =
        UtilKContext.getSystemService(CContext.TELEPHONY_SERVICE, context) as TelephonyManager

    @JvmStatic
    fun getSystemService_WIFI(context: Context): WifiManager =
        UtilKContext.getSystemService(CContext.WIFI_SERVICE, context) as WifiManager

    @JvmStatic
    fun getSystemService_AUDIO(context: Context): AudioManager =
        UtilKContext.getSystemService(CContext.AUDIO_SERVICE, context) as AudioManager

    @JvmStatic
    fun getSystemService_CONNECTIVITY(context: Context): ConnectivityManager =
        UtilKContext.getSystemService(CContext.CONNECTIVITY_SERVICE, context) as ConnectivityManager

    @JvmStatic
    fun getSystemService_DISPLAY(context: Context): DisplayManager =
        UtilKContext.getSystemService(CContext.DISPLAY_SERVICE, context) as DisplayManager

    @JvmStatic
    fun getSystemService_ACTIVITY(context: Context) =
        UtilKContext.getSystemService(CContext.ACTIVITY_SERVICE, context) as ActivityManager

    @JvmStatic
    fun getSystemService_LAYOUT_INFLATER(context: Context): LayoutInflater =
        UtilKContext.getSystemService(CContext.LAYOUT_INFLATER_SERVICE, context) as LayoutInflater

    @JvmStatic
    fun getSystemService_USB(context: Context): UsbManager =
        UtilKContext.getSystemService(CContext.USB_SERVICE, context) as UsbManager

    @JvmStatic
    fun getSystemService_NOTIFICATION(context: Context): NotificationManager =
        UtilKContext.getSystemService(CContext.NOTIFICATION_SERVICE, context) as NotificationManager

    @JvmStatic
    fun getSystemService_CLIPBOARD(context: Context): ClipboardManager =
        UtilKContext.getSystemService(CContext.CLIPBOARD_SERVICE, context) as ClipboardManager

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getSystemService_CAMERA(context: Context): CameraManager =
        UtilKContext.getSystemService(CContext.CAMERA_SERVICE, context) as CameraManager

    @JvmStatic
    fun getSystemService_POWER(context: Context): PowerManager =
        UtilKContext.getSystemService(CContext.POWER_SERVICE, context) as PowerManager

    @JvmStatic
    fun getSystemService_BLUETOOTH(context: Context): BluetoothManager =
        UtilKContext.getSystemService(CContext.BLUETOOTH_SERVICE, context) as BluetoothManager
}