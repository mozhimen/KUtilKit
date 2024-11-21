package com.mozhimen.kotlin.utilk.android.os

import android.os.Bundle

/**
 * @ClassName UtilKBundle
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/17
 * @Version 1.0
 */
fun Bundle?.getStrDump():String =
    UtilKBundleWrapper.getStrDump(this)

///////////////////////////////////////////////////////////////////////////////

object UtilKBundleWrapper {
    @JvmStatic
    fun getStrDump(bundle: Bundle?): String {
        if (bundle == null) return "null"
        val stringBuilder = StringBuilder("Extras:\n")
        bundle.keySet()
            .toSet()
            .forEach { key ->
                stringBuilder.append(key).append(": ").append(bundle.get(key)).append("\n")
            }
        return stringBuilder.toString()
    }
}