package com.mozhimen.kotlin.utilk.android.graphics

import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import java.io.InputStream

/**
 * @ClassName UtilKBitmapDrawable
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/11/10 20:45
 * @Version 1.0
 */
object UtilKBitmapDrawable {
    @JvmStatic
    fun get(res: Resources?, inputStream: InputStream): BitmapDrawable =
        BitmapDrawable(res, inputStream)
}