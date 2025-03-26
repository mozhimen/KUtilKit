package com.mozhimen.kotlin.utilk.android.app

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKDownloadManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/9/18 18:10
 * @Version 1.0
 */
object UtilKDownloadManager {
    @JvmStatic
    fun get(context: Context): DownloadManager =
        UtilKContextGet.getSystemService_DOWNLOAD(context)

    @JvmStatic
    fun getUriForDownloadedFile(context: Context, id: Long): Uri? =
        get(context).getUriForDownloadedFile(id)
}