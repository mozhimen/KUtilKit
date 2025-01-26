package com.mozhimen.kotlin.utilk.android.net

import android.content.Context
import android.net.Uri
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.io.File


/**
 * @ClassName UtilKFileUri
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/1/12 18:58
 * @Version 1.0
 */
/**
 * example
uri: content://com.android.providers.media.documents/document/image%3A27391
authority: com.android.providers.media.documents
encodedAuthority: com.android.providers.media.documents
path: /document/image:27391
encodedFragment: null
encodedPath: /document/image%3A27391
encodedQuery: null
encodedSchemeSpecificPart: //com.android.providers.media.documents/document/image%3A27391
encodedUserInfo: null
fragment: null
host: com.android.providers.media.documents
isAbsolute: true
isHierarchical: true
isOpaque: false
isRelative: false
lastPathSegment: image:27391
pathSegments: [document, image:27391]
port: -1
query: null
queryParameterNames: []
scheme: content
schemeSpecificPart: //com.android.providers.media.documents/document/image:27391
userInfo: null
 */
object UtilKUri : BaseUtilK() {
    @JvmStatic
    fun get(strUri: String): Uri =
        parse(strUri)

    @JvmStatic
    fun get(scheme: String, ssp: String, fragment: String): Uri =
        fromParts(scheme, ssp, fragment)

    @JvmStatic
    fun get(file: File): Uri =
        fromFile(file)

    /////////////////////////////////////////////////////////////////////////////

    //获取PackageUri
    @JvmStatic
    fun getPackage(context: Context): Uri =
        Uri.parse("package:${UtilKContext.getPackageName(context)}")

    //获取PackageUri
    @JvmStatic
    fun getPackage_ofParts(context: Context): Uri =
        Uri.fromParts("package", UtilKContext.getPackageName(context), null)

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun fromParts(scheme: String, ssp: String, fragment: String): Uri =
        Uri.fromParts(scheme, ssp, fragment)

    @JvmStatic
    fun parse(strUri: String): Uri =
        Uri.parse(strUri)

    @JvmStatic
    fun encode(strUri: String): String =
        Uri.encode(strUri)

    @JvmStatic
    fun decode(strUri: String): String =
        Uri.decode(strUri)

    fun fromFile(file: File): Uri =
        Uri.fromFile(file)
}
