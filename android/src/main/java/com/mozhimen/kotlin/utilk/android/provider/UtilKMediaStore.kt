package com.mozhimen.kotlin.utilk.android.provider

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import com.mozhimen.kotlin.elemk.android.provider.cons.CMediaStore
import com.mozhimen.kotlin.utilk.android.content.UtilKContentResolver
import com.mozhimen.kotlin.utilk.android.database.getColumnString
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKMideaStore
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/8/2 23:20
 * @Version 1.0
 */

object UtilKMediaStore : BaseUtilK() {

    @JvmStatic
    fun getImagesMediaBitmap(context: Context, uri: Uri): Bitmap =
        MediaStore.Images.Media.getBitmap(UtilKContentResolver.get(context), uri)
}