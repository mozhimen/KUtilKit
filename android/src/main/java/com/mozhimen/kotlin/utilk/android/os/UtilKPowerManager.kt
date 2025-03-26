package com.mozhimen.kotlin.utilk.android.os

import android.content.Context
import android.os.PowerManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKPowerManager
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/4
 * @Version 1.0
 */
object UtilKPowerManager {
    @JvmStatic
    fun get(context: Context): PowerManager =
        UtilKContextGet.getSystemService_POWER(context)
}