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
    fun getSharedPreferences(name: String, mode: Int, context: Context): SharedPreferences =
        context.getSharedPreferences(name, mode)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getDir(name: String, mode: Int, context: Context): File =
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
    fun getFileStreamDir(name: String, context: Context): File =
        context.getFileStreamPath(name)

    /**
     * 内部使用，外部程序无法访问。主要是 SQLite 数据库的目录
     */
    @JvmStatic
    fun getDatabasePath(name: String, context: Context): File =
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
    fun getExternalFilesDir(type: String?, context: Context): File? =
        context.getExternalFilesDir(type)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getSystemService(name: String, context: Context): Any =
        context.getSystemService(name)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getString(@StringRes intResStr: Int, context: Context): String =
        context.getString(intResStr)

    @JvmStatic
    fun getString(@StringRes intResStr: Int, context: Context, vararg formatArgs: Any): String =
        context.getString(intResStr, *formatArgs)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColor(@ColorRes intResColor: Int, context: Context): Int =
        context.getColor(intResColor)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColorStateList(@ColorRes intResColor: Int, context: Context): ColorStateList =
        context.getColorStateList(intResColor)

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawable(@DrawableRes intResDrawable: Int, context: Context): Drawable? =
        context.getDrawable(intResDrawable)

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun grantUriPermission(uri: Uri, modeFlags: Int, context: Context) {
        grantUriPermission(getPackageName(context), uri, modeFlags, context)
    }

    @JvmStatic
    fun grantUriPermission(strPackageName: String, uri: Uri, modeFlags: Int, context: Context) {
        context.grantUriPermission(strPackageName, uri, modeFlags)
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    fun checkSelfPermission(permission: String, context: Context): Int =
        context.checkSelfPermission(permission)

    @JvmStatic
    fun checkCallingOrSelfPermission(permission: String, context: Context): Int =
        context.checkCallingOrSelfPermission(permission)
}