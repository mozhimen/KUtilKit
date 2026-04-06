package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.content.cons.CContext
import com.mozhimen.kotlin.elemk.android.os.cons.CEnvironment
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2file
import java.io.File

/**
 * @ClassName UtilKContextDir
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/4/17 13:09
 * @Version 1.0
 */
object UtilKContextDir {

    /**
     * 无需申请权限
     * 内部使用，外部程序无法访问。卸载应用时删除。
     */
    object Internal {
        /**
         * 系统空间不足时可能会删除
         */
        @JvmStatic
        fun getCacheDir(context: Context): File =
            UtilKContext.getCacheDir(context)

        @JvmStatic
        fun getFilesDir(context: Context): File =
            UtilKContext.getFilesDir(context)

        @JvmStatic
        fun getDataDir(context: Context): File =
            if (UtilKBuildVersion.isAfterV_24_7_N()) UtilKContext.getDataDir(context)
            else UtilKApplicationInfo.get(context).dataDir.strFilePath2file()

        @JvmStatic
        fun getObbDir(context: Context): File =
            UtilKContext.getObbDir(context)

        @JvmStatic
        fun getObbDirs(context: Context): Array<File>? =
            UtilKContext.getObbDirs(context)

        @RequiresApi(CVersCode.V_21_5_L)
        @JvmStatic
        fun getCodeCacheDir(context: Context): File =
            UtilKContext.getCodeCacheDir(context)

        @RequiresApi(CVersCode.V_21_5_L)
        @JvmStatic
        fun getNoBackupFilesDir(context: Context): File =
            UtilKContext.getNoBackupFilesDir(context)

        @JvmStatic
        fun getFileStreamDir(name: String, context: Context): File =
            UtilKContext.getFileStreamDir(name, context)

        /**
         * 内部使用，外部程序无法访问。主要是 SQLite 数据库的目录
         */
        @JvmStatic
        fun getDatabaseDir(name: String, context: Context): File =
            UtilKContext.getDatabasePath(name, context)

        @JvmStatic
        fun getPackageCodeDir(context: Context): String =
            UtilKContext.getPackageCodePath(context)

        @JvmStatic
        fun getPackageResourceDir(context: Context): String =
            UtilKContext.getPackageResourcePath(context)

        @JvmStatic
        fun getPatchDir(context: Context): File =
            UtilKContext.getDir("patch", CContext.MODE_PRIVATE, context)

        @JvmStatic
        fun getDex2optDir(context: Context): File =
            UtilKContext.getDir("dex2opt", CContext.MODE_PRIVATE, context)
    }

    /**
     * 读写需要申请权限
     * 外部程序可以访问。卸载应用可能会删除。
     */
    object External {

        @JvmStatic
        fun getCacheDir(context: Context): File? =
            UtilKContext.getExternalCacheDir(context)

        @JvmStatic
        fun getFilesDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(null, context)

        //////////////////////////////////////////////////////////////

        @JvmStatic
        fun getFilesMusicDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_MUSIC, context)

        @JvmStatic
        fun getFilesPodcastsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_PODCASTS, context)

        @JvmStatic
        fun getFilesRingtonesDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_RINGTONES, context)

        @JvmStatic
        fun getFilesAlarmsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_ALARMS, context)

        @JvmStatic
        fun getFilesNotificationsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_NOTIFICATIONS, context)

        @JvmStatic
        fun getFilesPicturesDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_PICTURES, context)

        @JvmStatic
        fun getFilesMoviesDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_MOVIES, context)

        @JvmStatic
        fun getFilesDownloadsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_DOWNLOADS, context)

        @JvmStatic
        fun getFilesDCIMDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_DCIM, context)

        @JvmStatic
        fun getFilesDocumentsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_DOCUMENTS, context)

        @JvmStatic
        @RequiresApi(CVersCode.V_29_10_Q)
        fun getFilesScreenshotsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_SCREENSHOTS, context)

        @JvmStatic
        @RequiresApi(CVersCode.V_29_10_Q)
        fun getFilesAudiobooksDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_AUDIOBOOKS, context)

        @JvmStatic
        @RequiresApi(CVersCode.V_31_12_S)
        fun getFilesRecordingsDir(context: Context): File? =
            UtilKContext.getExternalFilesDir(CEnvironment.DIRECTORY_RECORDINGS, context)
    }
}