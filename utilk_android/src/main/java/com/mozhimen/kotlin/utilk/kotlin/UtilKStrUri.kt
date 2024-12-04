package com.mozhimen.kotlin.utilk.kotlin

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import com.mozhimen.kotlin.elemk.android.content.cons.CContentResolver
import com.mozhimen.kotlin.utilk.android.net.UtilKUri

/**
 * @ClassName UtilKStrUri
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 0:22
 * @Version 1.0
 */
fun String.strUri2uri(): Uri =
    UtilKStrUri.strUri2uri(this)

////////////////////////////////////////////////////////////

object UtilKStrUri {

    @JvmStatic
    fun getStrUri_ofRaw(context: Context, rawName: String): String =
        "${CContentResolver.SCHEME_ANDROID_RESOURCE}://${context.packageName}/raw/${rawName}"

    ////////////////////////////////////////////////////////////

    @JvmStatic
    fun strUri2uri(strUri: String): Uri =
        UtilKUri.get(strUri)
}