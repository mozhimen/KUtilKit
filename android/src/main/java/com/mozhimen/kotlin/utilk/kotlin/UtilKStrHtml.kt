package com.mozhimen.kotlin.utilk.kotlin

import android.text.Html.ImageGetter
import android.text.Html.TagHandler
import android.text.Spanned
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.text.cons.CHtml
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.text.UtilKHtml

/**
 * @ClassName UtilKStrHtml
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/20
 * @Version 1.0
 */
@RequiresApi(CVersCode.V_24_7_N)
fun String.strHtml2chars(flags: Int): Spanned =
    UtilKStrHtml.strHtml2chars(this, flags)

fun String.strHtml2chars(): Spanned =
    UtilKStrHtml.strHtml2chars(this)

fun String.strHtml2chars(imageGetter: ImageGetter, tagHandler: TagHandler?): Spanned =
    UtilKStrHtml.strHtml2chars(this, imageGetter, tagHandler)

/////////////////////////////////////////////////////////////////////////////

object UtilKStrHtml {
    //CHtml.FROM_HTML_MODE_COMPACT
    @JvmStatic
    @RequiresApi(CVersCode.V_24_7_N)
    fun strHtml2chars(strHtml: String, flags: Int): Spanned =
        UtilKHtml.fromHtml(strHtml, flags)

    @JvmStatic
    @RequiresApi(CVersCode.V_24_7_N)
    fun strHtml2chars(strHtml: String, flags: Int, imageGetter: ImageGetter, tagHandler: TagHandler?): Spanned =
        UtilKHtml.fromHtml(strHtml, flags, imageGetter, tagHandler)

    @JvmStatic
    fun strHtml2chars(strHtml: String): Spanned =
        if (UtilKBuildVersion.isAfterV_24_7_N())
            strHtml2chars(strHtml, CHtml.FROM_HTML_MODE_COMPACT)
        else
            UtilKHtml.fromHtml(strHtml)

    @JvmStatic
    fun strHtml2chars(strHtml: String, imageGetter: ImageGetter, tagHandler: TagHandler?): Spanned =
        if (UtilKBuildVersion.isAfterV_24_7_N())
            strHtml2chars(strHtml, CHtml.FROM_HTML_MODE_COMPACT, imageGetter, tagHandler)
        else
            UtilKHtml.fromHtml(strHtml, imageGetter, tagHandler)
}