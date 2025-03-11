package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.DownloadManager
import android.app.NotificationManager
import android.app.UiModeManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.graphics.drawable.Drawable
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.PowerManager
import android.os.Vibrator
import android.os.VibratorManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import com.mozhimen.kotlin.elemk.android.content.cons.CContext
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import java.io.File


/**
 * @ClassName UtilKContext
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 18:19
 * @Version 1.0
 */
object UtilKContext {
    @JvmStatic
    fun getClassLoader(context: Context): ClassLoader =
        context.classLoader

    @JvmStatic
    fun getApplicationContext(context: Context): Context =
        context.applicationContext

    @JvmStatic
    fun getApplicationInfo(context: Context): ApplicationInfo =
        context.applicationInfo

    @JvmStatic
    fun getContentResolver(context: Context): ContentResolver =
        context.contentResolver

    @JvmStatic
    fun getPackageName(context: Context): String =
        context.packageName

    @JvmStatic
    fun getPackageManager(context: Context): PackageManager =
        context.packageManager

    @JvmStatic
    fun getResources(context: Context): Resources =
        context.resources

    @JvmStatic
    fun getAssets(context: Context): AssetManager =
        context.assets

    @JvmStatic
    fun getTheme(context: Context): Theme =
        context.theme

    @JvmStatic
    fun getSharedPreferences(context: Context, name: String, mode: Int): SharedPreferences =
        context.getSharedPreferences(name, mode)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getDir(context: Context, name: String, mode: Int): File =
        context.getDir(name, mode)

    /**
     * 系统空间不足时可能会删除
     */
    @JvmStatic
    fun getCacheDir(context: Context): File =
        context.cacheDir

    @JvmStatic
    fun getFilesDir(context: Context): File =
        context.filesDir

    @RequiresApi(CVersCode.V_24_7_N)
    @JvmStatic
    fun getDataDir(context: Context): File =
        context.dataDir

    @JvmStatic
    fun getObbDir(context: Context): File =
        context.obbDir

    @JvmStatic
    fun getObbDirs(context: Context): Array<File>? =
        context.obbDirs

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getCodeCacheDir(context: Context): File =
        context.codeCacheDir

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getNoBackupFilesDir(context: Context): File =
        context.noBackupFilesDir

    @JvmStatic
    fun getFileStreamDir(context: Context, name: String): File =
        context.getFileStreamPath(name)

    /**
     * 内部使用，外部程序无法访问。主要是 SQLite 数据库的目录
     */
    @JvmStatic
    fun getDatabasePath(context: Context, name: String): File =
        context.getDatabasePath(name)

    @JvmStatic
    fun getPackageCodePath(context: Context): String =
        context.packageCodePath

    @JvmStatic
    fun getPackageResourcePath(context: Context): String =
        context.packageResourcePath

    @JvmStatic
    fun getExternalCacheDir(context: Context): File? =
        context.externalCacheDir

    @JvmStatic
    fun getExternalFilesDir(context: Context, type: String?): File? =
        context.getExternalFilesDir(type)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getSystemService(context: Context, name: String): Any =
        context.getSystemService(name)

    @JvmStatic
    fun getInputManager(context: Context): InputManager =
        getSystemService(context, CContext.INPUT_SERVICE) as InputManager

    @JvmStatic
    fun getSensorManager(context: Context): SensorManager =
        getSystemService(context, CContext.SENSOR_SERVICE) as SensorManager

    @JvmStatic
    fun getUiModeManager(context: Context): UiModeManager =
        getSystemService(context, CContext.UI_MODE_SERVICE) as UiModeManager

    @JvmStatic
    fun getDownloadManager(context: Context): DownloadManager =
        getSystemService(context, CContext.DOWNLOAD_SERVICE) as DownloadManager

    @JvmStatic
    fun getLocationManager(context: Context): LocationManager =
        getSystemService(context, CContext.LOCATION_SERVICE) as LocationManager

    @JvmStatic
    fun getVibrator(context: Context): Vibrator =
        getSystemService(context, CContext.VIBRATOR_SERVICE) as Vibrator

    @RequiresApi(CVersCode.V_31_12_S)
    @JvmStatic
    fun getVibratorManager(context: Context): VibratorManager =
        getSystemService(context, CContext.VIBRATOR_MANAGER_SERVICE) as VibratorManager

    @JvmStatic
    fun getWindowManager(context: Context): WindowManager =
        getSystemService(context, CContext.WINDOW_SERVICE) as WindowManager

    @JvmStatic
    fun getInputMethodManager(context: Context): InputMethodManager =
        getSystemService(context, CContext.INPUT_METHOD_SERVICE) as InputMethodManager

    @JvmStatic
    fun getTelephonyManager(context: Context): TelephonyManager =
        getSystemService(context, CContext.TELEPHONY_SERVICE) as TelephonyManager

    @JvmStatic
    fun getWifiManager(context: Context): WifiManager =
        getApplicationContext(context).getSystemService(CContext.WIFI_SERVICE) as WifiManager

    @JvmStatic
    fun getAudioManager(context: Context): AudioManager =
        getSystemService(context, CContext.AUDIO_SERVICE) as AudioManager

    @JvmStatic
    fun getConnectivityManager(context: Context): ConnectivityManager =
        getSystemService(context, CContext.CONNECTIVITY_SERVICE) as ConnectivityManager

    @JvmStatic
    fun getDisplayManager(context: Context): DisplayManager =
        getSystemService(context, CContext.DISPLAY_SERVICE) as DisplayManager

    @JvmStatic
    fun getActivityManager(context: Context) =
        getSystemService(context, CContext.ACTIVITY_SERVICE) as ActivityManager

    @JvmStatic
    fun getLayoutInflater(context: Context): LayoutInflater =
        getSystemService(context, CContext.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @JvmStatic
    fun getUsbManager(context: Context): UsbManager =
        getSystemService(context, CContext.USB_SERVICE) as UsbManager

    @JvmStatic
    fun getNotificationManager(context: Context): NotificationManager =
        getSystemService(context, CContext.NOTIFICATION_SERVICE) as NotificationManager

    @JvmStatic
    fun getClipboardManager(context: Context): ClipboardManager =
        getSystemService(context, CContext.CLIPBOARD_SERVICE) as ClipboardManager

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getCameraManager(context: Context): CameraManager =
        getSystemService(context, CContext.CAMERA_SERVICE) as CameraManager

    @JvmStatic
    fun getPowerManager(context: Context): PowerManager =
        getSystemService(context, CContext.POWER_SERVICE) as PowerManager

    @JvmStatic
    fun getBluetoothManager(context: Context): BluetoothManager =
        getSystemService(context, CContext.BLUETOOTH_SERVICE) as BluetoothManager

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getString(context: Context, @StringRes intResStr: Int): String =
        context.getString(intResStr)

    @JvmStatic
    fun getString(context: Context, @StringRes intResStr: Int, vararg formatArgs: Any): String =
        context.getString(intResStr, *formatArgs)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColor(context: Context, @ColorRes intResColor: Int): Int =
        context.getColor(intResColor)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColorStateList(context: Context, @ColorRes intResColor: Int): ColorStateList =
        context.getColorStateList(intResColor)

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawable(context: Context, @DrawableRes intResDrawable: Int): Drawable? =
        context.getDrawable(intResDrawable)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun grantUriPermission(context: Context, uri: Uri, modeFlags: Int) {
        grantUriPermission(context, getPackageName(context), uri, modeFlags)
    }

    @JvmStatic
    fun grantUriPermission(context: Context, strPackageName: String, uri: Uri, modeFlags: Int) {
        context.grantUriPermission(strPackageName, uri, modeFlags)
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    fun checkSelfPermission(context: Context, permission: String): Int =
        context.checkSelfPermission(permission)

    @JvmStatic
    fun checkCallingOrSelfPermission(context: Context, permission: String): Int =
        context.checkCallingOrSelfPermission(permission)
}