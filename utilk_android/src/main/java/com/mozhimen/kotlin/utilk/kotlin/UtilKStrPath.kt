package com.mozhimen.kotlin.utilk.kotlin

import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.java.io.UtilKFileDir

/**
 * @ClassName UtilKStringPath
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/1 15:42
 * @Version 1.0
 */
object UtilKStrPath {
    object Absolute {
        object Internal {
            @JvmStatic
            fun getFiles(): String =
                UtilKFileDir.Internal.getFiles().absolutePath

            @JvmStatic
            fun getCache(): String =
                UtilKFileDir.Internal.getCache().absolutePath

            @JvmStatic
            fun getData(): String =
                UtilKFileDir.Internal.getData().absolutePath

            @JvmStatic
            fun getObb(): String =
                UtilKFileDir.Internal.getObb().absolutePath

            @JvmStatic
            @RequiresApi(CVersCode.V_21_5_L)
            fun getCodeCache(): String =
                UtilKFileDir.Internal.getCodeCache().absolutePath

            @JvmStatic
            @RequiresApi(CVersCode.V_21_5_L)
            fun getNoBackupFiles(): String =
                UtilKFileDir.Internal.getNoBackupFiles().absolutePath

            @JvmStatic
            fun getFileStream(name: String): String =
                UtilKFileDir.Internal.getFileStream(name).absolutePath

            /**
             * 内部使用，外部程序无法访问。主要是 SQLite 数据库的目录
             */
            @JvmStatic
            fun getDatabase(name: String): String =
                UtilKFileDir.Internal.getDatabase(name).absolutePath

            @JvmStatic
            fun getPackageCode(): String =
                UtilKFileDir.Internal.getPackageCode()

            @JvmStatic
            fun getPackageResource(): String =
                UtilKFileDir.Internal.getPackageResource()

            @JvmStatic
            fun getPatch(): String =
                UtilKFileDir.Internal.getPatch().absolutePath

            @JvmStatic
            fun getDex2opt(): String =
                UtilKFileDir.Internal.getDex2opt().absolutePath
        }

        object External {
            @JvmStatic
            fun getCache(): String? =
                UtilKFileDir.External.getCache()?.absolutePath

            @JvmStatic
            fun getFiles(): String? =
                UtilKFileDir.External.getFiles()?.absolutePath

            @JvmStatic
            fun getEnvStorage(): String =
                UtilKFileDir.External.getStorage_ofEnvironment().absolutePath

            @JvmStatic
            fun getEnvStoragePublicPictures(): String =
                UtilKFileDir.External.getStoragePublic_ofPictures_ofEnvironment().absolutePath

            @JvmStatic
            fun getEnvStoragePublicDCIM(): String =
                UtilKFileDir.External.getStoragePublic_ofDCIM_ofEnvironment().absolutePath

            @JvmStatic
            fun getEnvData(): String =
                UtilKFileDir.External.getData_ofEnvironment().absolutePath
        }
    }
}