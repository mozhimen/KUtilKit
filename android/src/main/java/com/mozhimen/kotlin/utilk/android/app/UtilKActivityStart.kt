package com.mozhimen.kotlin.utilk.android.app

import android.app.Activity
import android.content.Context
import android.net.Uri
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentGet
import com.mozhimen.kotlin.utilk.android.content.createChooser
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.java.lang.UtilKRuntimeWrapper
import java.io.File

/**
 * @ClassName UtilKPermission
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/12/7 15:17
 * @Version 1.0
 */
object UtilKActivityStart {
    //分享文本
    @JvmStatic
    fun startSendTextChooser(context: Context, title: String, str: String) {
        context.startContext(UtilKIntentGet.getIntent_ACTION_SEND_TYPE_TEXT(str).createChooser(title))
    }

    ///////////////////////////////////////////////////////////////////////

    //打开外部浏览器
    @JvmStatic
    fun startView(context: Context, strUrl: String) {
        context.startContext(UtilKIntentGet.getIntent_ACTION_VIEW(strUrl)/*Intent(Intent.ACTION_VIEW, Uri.parse(strUrl)*/)
    }

    //安装 if sdk >= 24 add provider
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    @JvmStatic
    fun startViewApk(context: Context, strPathNameApk: String): Boolean {
        context.startContext(
            UtilKIntentGet.getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(strPathNameApk.apply {
                if (UtilKBuildVersion.isBeforeVersion(CVersCode.V_24_7_N))
                    UtilKRuntimeWrapper.exec_chmod_777(this)
            }) ?: return false
        )
        return true
    }

    //安装 if sdk >= 24 add provider
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    @JvmStatic
    fun startViewApk(context: Context, fileApk: File) {
        context.startContext(UtilKIntentGet.getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(fileApk) ?: return)
    }

    //安装 if sdk >= 24 add provider
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    @JvmStatic
    fun startViewApk(context: Context, uriApk: Uri) {
        context.startContext(UtilKIntentGet.getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(uriApk))
    }

    ///////////////////////////////////////////////////////////////////////

    //打开包安装权限
    @JvmStatic
    fun startSettingsManageUnknownInstallSource(context: Context) {
        if (UtilKBuildVersion.isAfterV_26_8_O())
            context.startContext(UtilKIntentGet.getSettings_ACTION_MANAGE_UNKNOWN_APP_SOURCES(context))
    }

    //打开包安装权限
    @JvmStatic
    fun startSettingsManageUnknownInstallSource_ofResult(activity: Activity, requestCode: Int) {
        if (UtilKBuildVersion.isAfterV_26_8_O())
            activity.startActivityForResult(UtilKIntentGet.getSettings_ACTION_MANAGE_UNKNOWN_APP_SOURCES(activity), requestCode)
    }

    //设置申请权限 当系统在23及以上
    @JvmStatic
    fun startSettingsManageOverlayPermission(context: Context) {
        if (UtilKBuildVersion.isAfterV_23_6_M())
            context.startContext(UtilKIntentGet.getSettings_ACTION_MANAGE_OVERLAY_PERMISSION(context))
    }

    //设置申请权限 当系统在11及以上
    @JvmStatic
    fun startSettingsManageAllFilesAccessPermission(context: Context) {
        if (UtilKBuildVersion.isAfterV_30_11_R()) {
            context.startContext(UtilKIntentGet.getSettings_ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION(context))
        } else startSettingsApplicationDetailsSettings(context)
    }

    @JvmStatic
    fun startSettingsAppNotificationSettings(context: Context) {
        if (UtilKBuildVersion.isAfterV_26_8_O())
            context.startContext(UtilKIntentGet.getSettings_ACTION_APP_NOTIFICATION_SETTINGS(context))
        else
            startSettingsApplicationDetailsSettings(context)
    }

    //设置申请app权限
    @JvmStatic
    fun startSettingsApplicationDetailsSettings(context: Context) {
        context.startContext(UtilKIntentGet.getSettings_ACTION_APPLICATION_DETAILS_SETTINGS(context))
    }

    @JvmStatic
    fun startSettingsApplicationDetailsSettings_ofDownloads(context: Context) {
        context.startContext(UtilKIntentGet.getSettings_ACTION_APPLICATION_DETAILS_SETTINGS_downloads())
    }

    //设置申请无障碍权限
    @JvmStatic
    fun startSettingsAccessibilitySettings(context: Context) {
        context.startContext(UtilKIntentGet.getSettings_ACTION_ACCESSIBILITY_SETTINGS())
    }

    //设置申请定位
    @JvmStatic
    fun startSettingsLocationSourceSettings(context: Context) {
        context.startContext(UtilKIntentGet.getSettings_ACTION_LOCATION_SOURCE_SETTINGS())
    }

    //设置生物识别
    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    fun startForResultSettingsBiometricEnroll(activity: Activity, allowedAuthenticators: Int, requestCode: Int) {
        activity.startActivityForResult(UtilKIntentGet.getSettings_ACTION_BIOMETRIC_ENROLL(allowedAuthenticators), requestCode)
    }

    ///////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun startBluetoothAdapterRequestEnable(context: Context){
        context.startContext(UtilKIntentGet.getBluetoothAdapter_ACTION_REQUEST_ENABLE())
    }
}