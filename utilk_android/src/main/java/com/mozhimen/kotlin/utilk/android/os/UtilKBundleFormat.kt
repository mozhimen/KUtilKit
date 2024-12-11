package com.mozhimen.kotlin.utilk.android.os

import android.os.Bundle

/**
 * @ClassName UtilKBundle
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/17
 * @Version 1.0
 */
fun Bundle.bundle2strDump():String =
    UtilKBundleFormat.bundle2strDump(this)

///////////////////////////////////////////////////////////////////////////////

object UtilKBundleFormat {
    @JvmStatic
    fun bundle2strDump(bundle: Bundle): String {
        val stringBuilder = StringBuilder("{")
        bundle.keySet()
            .toSet()
            .forEach { key ->
                stringBuilder.append(key).append(":").append(bundle.get(key)).append(" ")
            }
        stringBuilder.append("}")
        return stringBuilder.toString()
    }
}