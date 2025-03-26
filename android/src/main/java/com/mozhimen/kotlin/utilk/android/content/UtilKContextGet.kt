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
        UtilKContext.getSystemService(context, CContext.INPUT_SERVICE) as InputManager

    @JvmStatic
    fun getSystemService_SENSOR(context: Context): SensorManager =
        UtilKContext.getSystemService(context, CContext.SENSOR_SERVICE) as SensorManager

    @JvmStatic
    fun getSystemService_UI_MODE(context: Context): UiModeManager =
        UtilKContext.getSystemService(context, CContext.UI_MODE_SERVICE) as UiModeManager

    @JvmStatic
    fun getSystemService_DOWNLOAD(context: Context): DownloadManager =
        UtilKContext.getSystemService(context, CContext.DOWNLOAD_SERVICE) as DownloadManager

    @JvmStatic
    fun getSystemService_LOCATION(context: Context): LocationManager =
        UtilKContext.getSystemService(context, CContext.LOCATION_SERVICE) as LocationManager

    @JvmStatic
    fun getSystemService_VIBRATOR(context: Context): Vibrator =
        UtilKContext.getSystemService(context, CContext.VIBRATOR_SERVICE) as Vibrator

    @RequiresApi(CVersCode.V_31_12_S)
    @JvmStatic
    fun getSystemService_VIBRATOR_MANAGER(context: Context): VibratorManager =
        UtilKContext.getSystemService(context, CContext.VIBRATOR_MANAGER_SERVICE) as VibratorManager

    @JvmStatic
    fun getSystemService_WINDOW(context: Context): WindowManager =
        UtilKContext.getSystemService(context, CContext.WINDOW_SERVICE) as WindowManager

    @JvmStatic
    fun getSystemService_INPUT_METHOD(context: Context): InputMethodManager =
        UtilKContext.getSystemService(context, CContext.INPUT_METHOD_SERVICE) as InputMethodManager

    @JvmStatic
    fun getSystemService_TELEPHONY(context: Context): TelephonyManager =
        UtilKContext.getSystemService(context, CContext.TELEPHONY_SERVICE) as TelephonyManager

    @JvmStatic
    fun getSystemService_WIFI(context: Context): WifiManager =
        UtilKContext.getSystemService(context, CContext.WIFI_SERVICE) as WifiManager

    @JvmStatic
    fun getSystemService_AUDIO(context: Context): AudioManager =
        UtilKContext.getSystemService(context, CContext.AUDIO_SERVICE) as AudioManager

    @JvmStatic
    fun getSystemService_CONNECTIVITY(context: Context): ConnectivityManager =
        UtilKContext.getSystemService(context, CContext.CONNECTIVITY_SERVICE) as ConnectivityManager

    @JvmStatic
    fun getSystemService_DISPLAY(context: Context): DisplayManager =
        UtilKContext.getSystemService(context, CContext.DISPLAY_SERVICE) as DisplayManager

    @JvmStatic
    fun getSystemService_ACTIVITY(context: Context) =
        UtilKContext.getSystemService(context, CContext.ACTIVITY_SERVICE) as ActivityManager

    @JvmStatic
    fun getSystemService_LAYOUT_INFLATER(context: Context): LayoutInflater =
        UtilKContext.getSystemService(context, CContext.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @JvmStatic
    fun getSystemService_USB(context: Context): UsbManager =
        UtilKContext.getSystemService(context, CContext.USB_SERVICE) as UsbManager

    @JvmStatic
    fun getSystemService_NOTIFICATION(context: Context): NotificationManager =
        UtilKContext.getSystemService(context, CContext.NOTIFICATION_SERVICE) as NotificationManager

    @JvmStatic
    fun getSystemService_CLIPBOARD(context: Context): ClipboardManager =
        UtilKContext.getSystemService(context, CContext.CLIPBOARD_SERVICE) as ClipboardManager

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getSystemService_CAMERA(context: Context): CameraManager =
        UtilKContext.getSystemService(context, CContext.CAMERA_SERVICE) as CameraManager

    @JvmStatic
    fun getSystemService_POWER(context: Context): PowerManager =
        UtilKContext.getSystemService(context, CContext.POWER_SERVICE) as PowerManager

    @JvmStatic
    fun getSystemService_BLUETOOTH(context: Context): BluetoothManager =
        UtilKContext.getSystemService(context, CContext.BLUETOOTH_SERVICE) as BluetoothManager
}