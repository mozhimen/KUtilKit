package com.mozhimen.kotlin.utilk.android.widget

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * @ClassName UtilKToast
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/27
 * @Version 1.0
 */
object UtilKToast {
    @SuppressLint("ShowToast")
    @JvmStatic
    fun makeText(chars: CharSequence, duration: Int, context: Context): Toast =
        Toast.makeText(context, chars, duration)

    @SuppressLint("ShowToast")
    @JvmStatic
    fun makeText(@StringRes intResStr: Int, duration: Int, context: Context): Toast =
        Toast.makeText(context, intResStr, duration)

    @JvmStatic
    fun makeText_show(chars: CharSequence, duration: Int, context: Context) {
        makeText(chars, duration, context).show()
    }

    @JvmStatic
    fun makeText_show(@StringRes intResStr: Int, duration: Int, context: Context) {
        makeText(intResStr, duration, context).show()
    }
}