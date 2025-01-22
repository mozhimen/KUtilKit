package com.mozhimen.kotlin.utilk.android.content

import android.content.Intent

/**
 * @ClassName UtilKIntentFormat
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/3
 * @Version 1.0
 */
fun Intent.intent2strURI(): String =
    UtilKIntentFormat.intent2strURI(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKIntentFormat {
    @JvmStatic
    fun intent2strURI(intent: Intent): String =
        UtilKIntent.toURI(intent)
}