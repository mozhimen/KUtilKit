package com.mozhimen.kotlin.utilk.android.content

import android.app.DownloadManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
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
import com.mozhimen.kotlin.utilk.java.io.file2uri_internal
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.UtilKStringWrapper
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2uri_internal
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
    fun getSend(): Intent =
        UtilKIntent.get(CIntent.ACTION_SEND)

    //分享文字
    @JvmStatic
    fun getSendText(str: String): Intent =
        getSend().apply {
            type = CMediaFormat.MIMETYPE_TEXT_PLAIN
            putExtra(CIntent.EXTRA_TEXT, str)
        }

    @JvmStatic
    fun getSendImage(uriImage: Uri): Intent =
        getSend().apply {
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
    fun getPick(): Intent =
        UtilKIntent.get(CIntent.ACTION_PICK)

    @JvmStatic
    fun getPickImageAll(): Intent =
        getPick().apply {
            type = CMediaFormat.MIMETYPE_IMAGE_ALL
        }

    //选择系统图像
    @JvmStatic
    fun getPickUriImage(): Intent =
        getPick().apply {
            setDataAndType(CMediaStore.Images.Media.EXTERNAL_CONTENT_URI, CMediaFormat.MIMETYPE_IMAGE_ALL)
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getGetContent(): Intent =
        UtilKIntent.get(CIntent.ACTION_GET_CONTENT)

    @JvmStatic
    fun getGetContentImage(): Intent =
        getGetContent().apply {
            type = CMediaFormat.MIMETYPE_IMAGE_ALL
            addCategory(Intent.CATEGORY_OPENABLE)
        }

    @JvmStatic
    fun getGetContentAudio(): Intent =
        getGetContent().apply {
            type = CMediaFormat.MIMETYPE_AUDIO_ALL
        }

    @JvmStatic
    fun getGetContentVideo(): Intent =
        getGetContent().apply {
            type = CMediaFormat.MIMETYPE_VIDEO_ALL
        }

    @JvmStatic
    fun getGetContentAudioVideo(): Intent =
        getGetContent().apply {
            type = "${CMediaFormat.MIMETYPE_AUDIO_ALL};${CMediaFormat.MIMETYPE_VIDEO_ALL}"
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getMain(): Intent =
        UtilKIntent.get(CIntent.ACTION_MAIN)

    @JvmStatic
    fun getMain(uri: Uri?): Intent =
        UtilKIntent.get(CIntent.ACTION_MAIN, uri)

    //获取mainLauncher
    @JvmStatic
    fun getMainLauncher_ofClazz(strPackageName: String, strActivityName: String): Intent =
        getMain().apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setClassName(strPackageName, strActivityName)
        }

    //获取mainLauncher
    @JvmStatic
    fun getMainLauncher_ofPackage(strPackageName: String): Intent =
        getMain().apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setPackage(strPackageName)
//            addFlags(CIntent.FLAG_ACTIVITY_NEW_TASK)
        }

    //获取mainLauncher
    @JvmStatic
    fun getMainLauncher_ofPackage(strPackageName: String, uri: Uri?): Intent =
        getMain(uri).apply {
            addCategory(CIntent.CATEGORY_LAUNCHER)
            setPackage(strPackageName)
        }

    //获取启动App的Intent
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncher_ofPackageManger(context: Context, strPackageName: String): Intent? {
        val strLauncherActivityName: String = UtilKActivityInfoWrapper.getMainLauncherName(context, strPackageName)
        if (UtilKStringWrapper.hasSpace(strLauncherActivityName) || strLauncherActivityName.isEmpty()) return UtilKPackageManager.getLaunchIntentForPackage(context, strPackageName)
        return getMainLauncher_ofClazz(strPackageName, strLauncherActivityName)
    }

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncher_ofComponent(context: Context, strPackageName: String): Intent? {
        val intent = getMainLauncher_ofPackage(strPackageName)
        val resolveInfos = UtilKPackageManager.queryIntentActivities(context, intent, 0) //查询要启动的Activity
        return if (resolveInfos.isNotEmpty()) { //如果包名存在
            val resolveInfo = resolveInfos[0]
            intent.component = ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)//组装包名和类名//设置给Intent
            intent//根据包名类型打开Activity
        } else null
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getComponent(strPackageName: String, strActivityName: String): Intent =
        UtilKIntent.get().apply {
            component = ComponentName(strPackageName, "$strPackageName.$strActivityName")
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getView(): Intent =
        UtilKIntent.get(CIntent.ACTION_VIEW)

    @JvmStatic
    fun getView(uri: Uri): Intent =
        UtilKIntent.get(CIntent.ACTION_VIEW, uri)

    @JvmStatic
    fun getView(uri: Uri, type: String): Intent =
        getView(uri).apply { setType(type) }

    @JvmStatic
    fun getViewAudio(uri: Uri): Intent =
        getView(uri, CMediaFormat.MIMETYPE_AUDIO_ALL)

    @JvmStatic
    fun getViewVideo(uri: Uri): Intent =
        getView(uri, CMediaFormat.MIMETYPE_VIDEO_ALL)

    @JvmStatic
    fun getViewApk(uri: Uri): Intent =
        getView(uri, EMineTypeMap_application.apk.type)

    @JvmStatic
    fun getViewStrUrl(strUrl: String): Intent =
        getView(Uri.parse(strUrl))

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getView_install_internal(uriApk: Uri): Intent =
        getView().apply {
            if (UtilKBuildVersion.isAfterV_24_7_N()) //判断安卓系统是否大于7.0  大于7.0使用以下方法
                addFlags(CIntent.FLAG_GRANT_READ_URI_PERMISSION) //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
            setDataAndType(uriApk, EMineTypeMap_application.apk.type)
        }

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getView_install_internal(strFilePathName: String): Intent? =
        UtilKStrFile.strFilePath2uri_internal(strFilePathName)?.let { getView_install_internal(it) }

    /**
     * 获取安装app的intent
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun getView_install_internal(fileApk: File): Intent? =
        fileApk.file2uri_internal()?.let { getView_install_internal(it) }

    ///////////////////////////////////////////////////////////////////////////////////////
    //CSettings
    ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get location source settings
     *  定位服务
     */
    @JvmStatic
    fun getSettingLocationSourceSettings(): Intent =
        UtilKIntent.get(CSettings.ACTION_LOCATION_SOURCE_SETTINGS)

    /**
     * 获取设置无障碍
     */
    @JvmStatic
    fun getSettingAccessibilitySettings(): Intent =
        UtilKIntent.get(CSettings.ACTION_ACCESSIBILITY_SETTINGS)

    /**
     * 管理APP设置
     */
    @JvmStatic
    fun getSettingApplicationDetailsSettings(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_APPLICATION_DETAILS_SETTINGS, UtilKUri.getPackage_ofParts(context))

    /**
     * 管理APP下载
     */
    fun getSettingApplicationDetailsSettings_ofDownloads(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_APPLICATION_DETAILS_SETTINGS, "package:${CStrPackage.com_android_providers_downloads}".strUri2uri())

    /**
     * 管理通知
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettingAppNotificationSettings(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
            putExtra(CSettings.EXTRA_APP_PACKAGE, context.packageName)
        }

    /**
     * 管理通知
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettingAppNotificationSettings_ofUid(context: Context): Intent =
        getSettingAppNotificationSettings(context).apply {
            putExtra("app_package", context.packageName)
            putExtra("app_uid", context.applicationInfo.uid)
        }

    /**
     * 获取管理所有APP
     */
    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    @RequiresPermission(CPermission.MANAGE_EXTERNAL_STORAGE)
    @OPermission_MANAGE_EXTERNAL_STORAGE
    fun getSettingManageAppAllFilesAccessPermission(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, UtilKUri.getPackage(context))

    /**
     * 获取管理悬浮窗
     */
    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getSettingManageOverlayPermission(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_OVERLAY_PERMISSION, UtilKUri.getPackage(context))

    /**
     * 获取管理安装
     */
    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getSettingManageUnknownAppSources(context: Context): Intent =
        UtilKIntent.get(CSettings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, UtilKUri.getPackage(context))

    /**
     * androidx.biometric提供的录入生物信息的API仅在Android R(30)以上有效
     */
    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    fun getSettingBiometricEnroll(allowedAuthenticators: Int): Intent =
        UtilKIntent.get(CSettings.ACTION_BIOMETRIC_ENROLL).apply {
            putExtra(CSettings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED, allowedAuthenticators)
        }

    ///////////////////////////////////////////////////////////////////////////////////////
    //MediaStore
    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getMediaStoreImageCapture(): Intent =
        UtilKIntent.get(CMediaStore.ACTION_IMAGE_CAPTURE)

    @JvmStatic
    fun getMediaStoreImageCaptureOutput(uri: Uri): Intent =
        getMediaStoreImageCapture().apply {
            putExtra(CMediaStore.EXTRA_OUTPUT, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

    @JvmStatic
    fun getMediaStoreImageCaptureOutput(strFilePathName: String): Intent? =
        strFilePathName.strFilePath2uri_internal()?.let { getMediaStoreImageCaptureOutput(it) }

    @JvmStatic
    fun getMediaStoreImageCaptureOutput(file: File): Intent? =
        file.file2uri_internal()?.let { getMediaStoreImageCaptureOutput(it) }

    @JvmStatic
    fun getDownloadManager_downloads():Intent=
        UtilKIntent.get(DownloadManager.ACTION_VIEW_DOWNLOADS)
}