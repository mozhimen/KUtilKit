package com.mozhimen.kotlin.utilk.android.content

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKClipboardManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/21
 * @Version 1.0
 */
object UtilKClipboardManager {
    @JvmStatic
    fun get(context: Context): ClipboardManager =
        UtilKContextGet.getSystemService_CLIPBOARD(context)

    @JvmStatic
    fun getPrimaryClip(context: Context): ClipData? =
        get(context).primaryClip

}