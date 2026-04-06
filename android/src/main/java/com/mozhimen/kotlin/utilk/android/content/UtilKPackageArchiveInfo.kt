package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.pm.PackageInfo
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKPackageArchiveInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/9/27 1:10
 * @Version 1.0
 */
object UtilKPackageArchiveInfo : BaseUtilK() {
    @JvmStatic
    fun get(archiveFilePath: String, flags: Int, context: Context): PackageInfo? =
        UtilKPackageManager.getPackageArchiveInfo(archiveFilePath, flags, context)

    @JvmStatic
    fun get_ofGET_ACTIVITIES(archiveFilePath: String, context: Context): PackageInfo? =
        get(archiveFilePath, CPackageManager.GET_ACTIVITIES, context)
}