package com.mozhimen.kotlin.utilk.android.content

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.UriPermission
import android.database.Cursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import java.io.InputStream
import java.io.OutputStream

/**
 * @ClassName UtilKContentResolver
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/31 18:12
 * @Version 1.0
 */
object UtilKContentResolver : IUtilK {
    @JvmStatic
    fun get(context: Context): ContentResolver =
        UtilKContext.getContentResolver(context)

    @JvmStatic
    fun getType(uri: Uri, context: Context): String? =
        getType(get(context), uri)

    @JvmStatic
    fun getType(contentResolver: ContentResolver, uri: Uri): String? =
        contentResolver.getType(uri)

    @JvmStatic
    fun getPersistedUriPermissions(context: Context): List<UriPermission> =
        get(context).persistedUriPermissions

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun query(@RequiresPermission.Read uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?, context: Context): Cursor? =
        get(context).query(uri, projection, selection, selectionArgs, sortOrder)

    @JvmStatic
    fun openInputStream(uri: Uri, context: Context): InputStream? =
        get(context).openInputStream(uri)

    @JvmStatic
    fun openOutputStream(uri: Uri, context: Context): OutputStream? =
        get(context).openOutputStream(uri)

    @JvmStatic
    fun openFileDescriptor(uri: Uri, mode: String, context: Context): ParcelFileDescriptor? =
        get(context).openFileDescriptor(uri, mode)

    @JvmStatic
    fun insert(@RequiresPermission.Write uri: Uri, values: ContentValues?, context: Context): Uri? =
        get(context).insert(uri, values)

    @JvmStatic
    fun delete(@RequiresPermission.Write uri: Uri, where: String?, selectionArgs: Array<String>?, context: Context) {
        get(context).delete(uri, where, selectionArgs)
    }
}