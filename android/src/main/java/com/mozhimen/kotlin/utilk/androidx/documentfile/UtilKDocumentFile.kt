package com.mozhimen.kotlin.utilk.androidx.documentfile

import android.content.Context
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import com.mozhimen.kotlin.utilk.kotlin.strUri2uri

/**
 * @ClassName UtilKDocumentFile
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/12/10 0:21
 * @Version 1.0
 */
fun DocumentFile.isTypeZip(): Boolean =
    UtilKDocumentFile.isTypeZip(this)

//////////////////////////////////////////////////////////////////////////////

object UtilKDocumentFile {

    @JvmStatic
    fun get(strUriDocument: String, context: Context): DocumentFile? =
        fromTreeUri(strUriDocument.strUri2uri(), context)

    @JvmStatic
    fun get(uri: Uri, context: Context): DocumentFile? =
        fromTreeUri(uri, context)

    ////////////////////////////////////////////////////////

    @JvmStatic
    fun isTypeZip(documentFile: DocumentFile): Boolean =
        documentFile.type == "application/zip"

    ////////////////////////////////////////////////////////

    @JvmStatic
    fun fromTreeUri(strUriDocument: String, context: Context): DocumentFile? =
        DocumentFile.fromTreeUri(context, strUriDocument.strUri2uri())

    @JvmStatic
    fun fromTreeUri(uri: Uri, context: Context): DocumentFile? =
        DocumentFile.fromTreeUri(context, uri)
}