package com.mozhimen.kotlin.utilk.android.text

import android.content.Context
import android.text.format.DateUtils

/**
 * @ClassName UtilKDateUtils
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/14
 * @Version 1.0
 */
object UtilKDateUtils {
    @JvmStatic
    fun formatDateTime(millis: Long, flags: Int, context: Context): String =
        DateUtils.formatDateTime(context, millis, flags)
}