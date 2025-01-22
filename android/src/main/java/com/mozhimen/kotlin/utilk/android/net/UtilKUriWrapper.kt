package com.mozhimen.kotlin.utilk.android.net

import android.net.Uri
import androidx.core.net.toFile
import com.mozhimen.kotlin.elemk.android.content.cons.CContentResolver
import com.mozhimen.kotlin.elemk.android.provider.cons.COpenableColumns
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.utilk.android.content.UtilKContentResolverWrapper

/**
 * @ClassName UtilKUriWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/21
 * @Version 1.0
 */
fun Uri.getDisplayName(): String =
    UtilKUriWrapper.getDisplayName(this)

//////////////////////////////////////////////////////////////////////////

fun Uri.isAuthorityDownloadsDocument(): Boolean =
    UtilKUriWrapper.isAuthorityDownloadsDocument(this)

fun Uri.isAuthorityExternalStorageDocument(): Boolean =
    UtilKUriWrapper.isAuthorityExternalStorageDocument(this)

fun Uri.isAuthorityMediaDocument(): Boolean =
    UtilKUriWrapper.isAuthorityMediaDocument(this)

//////////////////////////////////////////////////////////////////////////

object UtilKUriWrapper {
    @JvmStatic
    fun getDisplayName(uri: Uri): String =
        if (uri.scheme == CContentResolver.SCHEME_FILE) uri.toFile().name
        else UtilKContentResolverWrapper.getString(uri, arrayOf(COpenableColumns.DISPLAY_NAME)) ?: ""

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isAuthorityDownloadsDocument(uri: Uri): Boolean =
        uri.authority == CStrPackage.com_android_providers_downloads_documents//"com.android.providers.downloads.documents"

    @JvmStatic
    fun isAuthorityExternalStorageDocument(uri: Uri): Boolean =
        uri.authority == CStrPackage.com_android_externalstorage_documents//"com.android.externalstorage.documents"

    @JvmStatic
    fun isAuthorityMediaDocument(uri: Uri): Boolean =
        uri.authority == CStrPackage.com_android_internal_policy_Decorview//"com.android.providers.media.documents"
}