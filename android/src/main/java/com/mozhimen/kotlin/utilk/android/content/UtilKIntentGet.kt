package com.mozhimen.kotlin.utilk.android.content

import android.app.DownloadManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.bluetooth.cons.CBluetoothAdapter
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.elemk.android.media.cons.CMediaFormat
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.provider.cons.CMediaStore
import com.mozhimen.kotlin.elemk.android.provider.cons.CSettings
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.webkit.cons.EMineTypeMap_application
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityInfoWrapper
import com.mozhimen.kotlin.utilk.android.net.UtilKUri
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.java.io.file2uri
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.UtilKStringWrapper
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2uri
import com.mozhimen.kotlin.utilk.kotlin.strUri2uri
import java.io.File

/**
 * @ClassName UtilKIntentWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/9/26 22:12
 * @Version 1.0
 */
object UtilKIntentGet {

    ///////////////////////////////////////////////////////////////////////////////////////
    //CIntent
    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getIntent_ACTION_SEND(): Intent =
        UtilKIntent.get(CIntent.ACTION_SEND)

    //分享文字
    @JvmStatic
    fun getIntent_ACTION_SEND_TYPE_TEXT(str: String): Intent =
        getIntent_ACTION_SEND().apply {
            type = CMediaFormat.MIMETYPE_TEXT_PLAIN
            putExtra(CIntent.EXTRA_TEXT, str)
        }

    @JvmStatic
    fun getIntent_ACTION_SEND_TYPE_IMAGE(uriImage: Uri): Intent =
        getIntent_ACTION_SEND().apply {
            type = CMediaFormat.MIMETYPE_IMAGE_ALL
            putExtra(CIntent.EXTRA_STREAM, uriImage)
        }

//    @JvmStatic
//    fun getSendFileApk(uriApk: Uri): Intent =
//        getSend().apply {
//            if (UtilKBuildVersion.isAfterV_24_7_N()) //判断安卓系统是否大于7.0  大于7.0使用以下方法
//                addFlags(CIntent.FLAG_GRANT_READ_URI_PERMISSION) //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
//            setDataAndType(uriApk, "application/vnd.android.package-archive")
//        }

    ///////////////////////////////////////////////////////////////////////////////////////

    //选择系统文件
    @JvmStatic
    fun getIntent_ACTION_PICK(): Intent =
        UtilKIntent.get(CIntent.ACTION_PICK)

    @JvmStatic
    fun getIntent_ACTION_PICK_TYPE_IMAGE(): Intent =
        getIntent_ACTION_PICK().apply {
            type = CMediaFormat.MIMETYPE_IMAGE_ALL
        }

    //选择系统图像
    @JvmStatic
    fun getINTENT_ACTION_PICK_TYPE_IMAGE_MEDIA(): Intent =
        getIntent_ACTION_PICK().apply {
            setDataAndType(CMediaStore.Images.Media.EXTERNAL_CONTENT_URI, CMediaFormat.MIMETYPE_IMAGE_ALL)
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getIntent_ACTION_GET_CONTENT(): Intent =
        UtilKIntent.get(CIntent.ACTION_GET_CONTENT)

    @JvmStatic
    fun getIntent_ACTION_GET_CONTENT_TYPE_IMAGE(): Intent =
        getIntent_ACTION_GET_CONTENT().apply {
            type = CMediaFormat.MIMETYPE_IMAGE_ALL
            addCategory(Intent.CATEGORY_OPENABLE)
        }

    @JvmStatic
    fun getIntent_ACTION_GET_CONTENT_TYPE_AUDIO(): Intent =
        getIntent_ACTION_GET_CONTENT().apply {
            type = CMediaFormat.MIMETYPE_AUDIO_ALL
        }

    @JvmStatic
    fun getIntent_ACTION_GET_CONTENT_TYPE_VIDEO(): Intent =
        getIntent_ACTION_GET_CONTENT().apply {
            type = CMediaFormat.MIMETYPE_VIDEO_ALL
        }

    @JvmStatic
    fun getIntent_ACTION_GET_CONTENT_TYPE_AUDIO_VIDEO(): Intent =
        getIntent_ACTION_GET_CONTENT().apply {
            type = "${CMediaFormat.MIMETYPE_AUDIO_ALL};${CMediaFormat.MIMETYPE_VIDEO_ALL}"
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getIntent_ACTION_MAIN(): Intent =
        UtilKIntent.get(CIntent.ACTION_MAIN)

    @JvmStatic
    fun getIntent_ACTION_MAIN(uri: Uri?): Intent =
        UtilKIntent.get(CIntent.ACTION_MAIN, uri)

    //获取mainLauncher
    @JvmStatic
    fun getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_CLASSNAME(strPackageName: String, strActivityName: String): Intent =
        getIntent_ACTION_MAIN().apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setClassName(strPackageName, strActivityName)
        }

    //获取启动App的Intent
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_CLASSNAME(context: Context, strPackageName: String): Intent? {
        val strLauncherActivityName: String = UtilKActivityInfoWrapper.getMainLauncherName(context, strPackageName)
        if (UtilKStringWrapper.hasSpace(strLauncherActivityName) || strLauncherActivityName.isEmpty()) return UtilKPackageManager.getLaunchIntentForPackage(context, strPackageName)
        return getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_CLASSNAME(strPackageName, strLauncherActivityName)
    }

    //获取mainLauncher
    @JvmStatic
    fun getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName: String): Intent =
        getIntent_ACTION_MAIN().apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setPackage(strPackageName)
//            addFlags(CIntent.FLAG_ACTIVITY_NEW_TASK)
        }

    //获取mainLauncher
    @JvmStatic
    fun getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName: String, uri: Uri?): Intent =
        getIntent_ACTION_MAIN(uri).apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setPackage(strPackageName)
        }

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_COMPONENT(context: Context, strPackageName: String): Intent? {
        val intent = getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName)
        val resolveInfos = UtilKPackageManager.queryIntentActivities(context, intent, 0) //查询要启动的Activity
        return if (resolveInfos.isNotEmpty()) { //如果包名存在
            val resolveInfo = resolveInfos[0]
            intent.component = ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)//组装包名和类名//设置给Intent
            intent//根据包名类型打开Activity
        } else null
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun get_COMPONENT(strPackageName: String, strActivityName: String): Intent =
        UtilKIntent.get().apply {
            component = ComponentName(strPackageName, "$strPackageName.$strActivityName")
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getIntent_ACTION_VIEW(): Intent =
        UtilKIntent.get(CIntent.ACTION_VIEW)

    @JvmStatic
    fun getIntent_ACTION_VIEW(uri: Uri): Intent =
        UtilKIntent.get(CIntent.ACTION_VIEW, uri)

    @JvmStatic
    fun getIntent_ACTION_VIEW(uri: Uri, type: String): Intent =
        getIntent_ACTION_VIEW(uri).apply { setType(type) }

    @JvmStatic
    fun getIntent_ACTION_VIEW(strUrl: String): Intent =
        getIntent_ACTION_VIEW(strUrl.strUri2uri())

    @JvmStatic
    fun getIntent_ACTION_VIEW_TYPE_AUDIO(uri: Uri, context: Context): Intent =
        getIntent_ACTION_VIEW(uri, context.contentResolver.getType(uri) ?: CMediaFormat.MIMETYPE_AUDIO_ALL)

    @JvmStatic
    fun getIntent_ACTION_VIEW_TYPE_VIDEO(uri: Uri, context: Context): Intent =
        getIntent_ACTION_VIEW(uri, context.contentResolver.getType(uri) ?: CMediaFormat.MIMETYPE_VIDEO_ALL)

    @JvmStatic
    fun getIntent_ACTION_VIEW_TYPE_APK(uri: Uri): Intent =
        getIntent_ACTION_VIEW(uri, EMineTypeMap_application.apk.type)

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(uri: Uri): Intent =
        getIntent_ACTION_VIEW().apply {
            if (UtilKBuildVersion.isAfterV_24_7_N()) //判断安卓系统是否大于7.0  大于7.0使用以下方法
                addFlags(CIntent.FLAG_GRANT_READ_URI_PERMISSION) //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
            setDataAndType(uri, EMineTypeMap_application.apk.type)
        }

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(strFilePathName: String): Intent? =
        UtilKStrFile.strFilePath2uri(strFilePathName)?.let { getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(it) }

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(fileApk: File): Intent? =
        fileApk.file2uri()?.let { getIntent_ACTION_VIEW_TYPE_APK_FLAGS_PERMISSION(it) }

    ///////////////////////////////////////////////////////////////////////////////////////
    //CSettings
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get location source settings
     *  定位服务
     */
    @JvmStatic
    fun getSettings_ACTION_LOCATION_SOURCE_SETTINGS(): Intent =
        UtilKIntent.get(CSettings.ACTION_LOCATION_SOURCE_SETTINGS)

    /**
     * 获取设置无障碍
     */
    @JvmStatic
    fun getSettings_ACTION_ACCESSIBILITY_SETTINGS(): Intent =
        UtilKIntent.get(CSettings.ACTION_ACCESSIBILITY_SETTINGS)

    /**
     * 管理APP设置
     */
    @JvmStatic
    fun getSettings_ACTION_APPLICATION_DETAILS_SETTINGS(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_APPLICATION_DETAILS_SETTINGS, UtilKUri.getPackage_ofParts(context))

    /**
     * 管理APP下载
     */
    fun getSettings_ACTION_APPLICATION_DETAILS_SETTINGS_downloads(): Intent =
        UtilKIntent.get(CSettings.ACTION_APPLICATION_DETAILS_SETTINGS, "package:${CStrPackage.com_android_providers_downloads}".strUri2uri())

    /**
     * 管理通知
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettings_ACTION_APP_NOTIFICATION_SETTINGS(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
            putExtra(CSettings.EXTRA_APP_PACKAGE, context.packageName)
        }

    /**
     * 管理通知
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettings_ACTION_APP_NOTIFICATION_SETTINGS_uid(context: Context): Intent =
        getSettings_ACTION_APP_NOTIFICATION_SETTINGS(context).apply {
            putExtra("app_package", context.packageName)
            putExtra("app_uid", context.applicationInfo.uid)
        }

    /**
     * 获取管理所有APP
     */
    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    fun getSettings_ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, UtilKUri.getPackage(context))

    /**
     * 获取管理悬浮窗
     */
    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getSettings_ACTION_MANAGE_OVERLAY_PERMISSION(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_OVERLAY_PERMISSION, UtilKUri.getPackage(context))

    /**
     * 获取管理安装
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettings_ACTION_MANAGE_UNKNOWN_APP_SOURCES(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, UtilKUri.getPackage(context))

    /**
     * androidx.biometric提供的录入生物信息的API仅在Android R(30)以上有效
     */
    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    fun getSettings_ACTION_BIOMETRIC_ENROLL(allowedAuthenticators: Int): Intent =
        UtilKIntent.get(CSettings.ACTION_BIOMETRIC_ENROLL).apply {
            putExtra(CSettings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED, allowedAuthenticators)
        }

    ///////////////////////////////////////////////////////////////////////////////////////
    //MediaStore
    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getMediaStore_ACTION_IMAGE_CAPTURE(): Intent =
        UtilKIntent.get(CMediaStore.ACTION_IMAGE_CAPTURE)

    @JvmStatic
    fun getMediaStore_ACTION_IMAGE_CAPTURE(uri: Uri): Intent =
        getMediaStore_ACTION_IMAGE_CAPTURE().apply {
            putExtra(CMediaStore.EXTRA_OUTPUT, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

    @JvmStatic
    fun getMediaStore_ACTION_IMAGE_CAPTURE(strFilePathName: String): Intent? =
        strFilePathName.strFilePath2uri()?.let { getMediaStore_ACTION_IMAGE_CAPTURE(it) }

    @JvmStatic
    fun getMediaStore_ACTION_IMAGE_CAPTURE(file: File): Intent? =
        file.file2uri()?.let { getMediaStore_ACTION_IMAGE_CAPTURE(it) }

    ///////////////////////////////////////////////////////////////////////////////////////
    //DownloadManager
    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getDownloadManager_ACTION_VIEW_DOWNLOADS(): Intent =
        UtilKIntent.get(DownloadManager.ACTION_VIEW_DOWNLOADS)

    ///////////////////////////////////////////////////////////////////////////////////////
    //MediaStore
    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getBluetoothAdapter_ACTION_REQUEST_ENABLE(): Intent =
        UtilKIntent.get(CBluetoothAdapter.ACTION_REQUEST_ENABLE)

    /**
     * 在ACTION_REQUEST_DISCOVERABLE中作为一个可选的int额外字段，用于请求以秒为单位的可发现性持续时间。当前的默认值是120秒，超过300秒的请求会被限制。这些值可以改变。
     */
    @JvmStatic
    fun getBluetoothAdapter_ACTION_REQUEST_DISCOVERABLE(discoverableDuration: Int): Intent =
        UtilKIntent.get(CBluetoothAdapter.ACTION_REQUEST_DISCOVERABLE).apply {
            putExtra(CBluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, discoverableDuration)
        }
}