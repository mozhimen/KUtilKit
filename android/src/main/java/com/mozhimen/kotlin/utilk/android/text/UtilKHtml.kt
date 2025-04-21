package com.mozhimen.kotlin.utilk.android.text

import android.text.Html
import android.text.Html.ImageGetter
import android.text.Html.TagHandler
import android.text.Spanned
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName UtilKHtml
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/20
 * @Version 1.0
 */
object UtilKHtml {

    @JvmStatic
    @RequiresApi(CVersCode.V_24_7_N)
    fun fromHtml(strHtml: String, flags: Int): Spanned =
        Html.fromHtml(strHtml, flags)

    @JvmStatic
    @RequiresApi(CVersCode.V_24_7_N)
    fun fromHtml(strHtml: String, flags: Int, imageGetter: ImageGetter, tagHandler: TagHandler?): Spanned =
        Html.fromHtml(strHtml, flags, imageGetter, tagHandler)

    @JvmStatic
    fun fromHtml(strHtml: String): Spanned =
        Html.fromHtml(strHtml)

    @JvmStatic
    fun fromHtml(strHtml: String, imageGetter: ImageGetter, tagHandler: TagHandler?): Spanned =
        Html.fromHtml(strHtml, imageGetter, tagHandler)
}