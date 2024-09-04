package com.mozhimen.kotlin.utilk.java.io

import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContextDir
import com.mozhimen.kotlin.utilk.android.os.UtilKEnvironment
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.io.File


/**
 * @ClassName UtilKDir
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/27 16:41
 * @Version 1.0
 */
object UtilKFileDir : BaseUtilK() {

    object Internal {
        @JvmStatic
        fun getFiles(): File =
            UtilKContextDir.Internal.getFilesDir(_context)

        @JvmStatic
        fun getCache(): File =
            UtilKContextDir.Internal.getCacheDir(_context)

        @JvmStatic
        fun getData(): File =
            UtilKContextDir.Internal.getDataDir(_context)

        @JvmStatic
        fun getObb(): File =
            UtilKContextDir.Internal.getObbDir(_context)

        @JvmStatic
        fun getObbs(): Array<File>? =
            UtilKContextDir.Internal.getObbDirs(_context)

        @JvmStatic
        @RequiresApi(CVersCode.V_21_5_L)
        fun getCodeCache(): File =
            UtilKContextDir.Internal.getCodeCacheDir(_context)

        @JvmStatic
        @RequiresApi(CVersCode.V_21_5_L)
        fun getNoBackupFiles(): File =
            UtilKContextDir.Internal.getNoBackupFilesDir(_context)

        @JvmStatic
        fun getFileStream(name: String): File =
            UtilKContextDir.Internal.getFileStreamDir(_context, name)

        /**
         * 内部使用，外部程序无法访问。主要是 SQLite 数据库的目录
         */
        @JvmStatic
        fun getDatabase(name: String): File =
            UtilKContextDir.Internal.getDatabaseDir(_context, name)

        @JvmStatic
        fun getPackageCode(): String =
            UtilKContextDir.Internal.getPackageCodeDir(_context)

        @JvmStatic
        fun getPackageResource(): String =
            UtilKContextDir.Internal.getPackageResourceDir(_context)

        @JvmStatic
        fun getPatch(): File =
            UtilKContextDir.Internal.getPatchDir(_context)

        @JvmStatic
        fun getDex2opt(): File =
            UtilKContextDir.Internal.getDex2optDir(_context)
    }

    object External {
        @JvmStatic
        fun getCache(): File? =
            UtilKContextDir.External.getCacheDir(_context)

        @JvmStatic
        fun getFiles(): File? =
            UtilKContextDir.External.getFilesDir(_context)

        @JvmStatic
        fun getFiles_freeSpace(): Long =
            getFiles()?.freeSpace ?: 0

        //////////////////////////////////////////////////////////////

        @JvmStatic
        fun getFilesDownloads(): File? =
            UtilKContextDir.External.getFilesDownloadsDir(_context)

        //////////////////////////////////////////////////////////////

        @JvmStatic
        fun getStorage_ofEnvironment(): File =
            UtilKEnvironment.getExternalStorageDir()

        @JvmStatic
        fun getStoragePublic_ofPictures_ofEnvironment(): File =
            UtilKEnvironment.getExternalStoragePublicDir_ofPictures()

        @JvmStatic
        fun getStoragePublic_ofDCIM_ofEnvironment(): File =
            UtilKEnvironment.getExternalStoragePublicDir_ofDCIM()

        @JvmStatic
        fun getData_ofEnvironment(): File =
            UtilKEnvironment.getDataDir()
    }

}