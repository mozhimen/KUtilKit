package com.mozhimen.kotlin.utilk.android.os

import android.content.Context
import android.os.Vibrator
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_VIBRATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet


/**
 * @ClassName UtilKVibrator
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/31 15:14
 * @Version 1.0
 */
object UtilKVibrator {
    @JvmStatic
    fun get(context: Context): Vibrator =
        UtilKContextGet.getSystemService_VIBRATOR(context)

    ////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hasVibrator(context: Context): Boolean =
        get(context).hasVibrator()

    ////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_VIBRATE
    @RequiresPermission(CPermission.VIBRATE)
    fun vibrate(milliseconds: Long, context: Context) {
        if (hasVibrator(context))
            get(context).vibrate(milliseconds)
    }

    /**
     * 让手机以我们自己设定的pattern[]模式振动
     * long pattern[] = {1000, 20000, 10000, 10000, 30000};
     */
    @JvmStatic
    @OUsesPermission_VIBRATE
    @RequiresPermission(CPermission.VIBRATE)
    fun vibrate(pattern: LongArray, repeat: Int, context: Context) {
        if (hasVibrator(context))
            get(context).vibrate(pattern, repeat)
    }

    @JvmStatic
    @OUsesPermission_VIBRATE
    @RequiresPermission(CPermission.VIBRATE)
    fun cancel(context: Context) {
        if (hasVibrator(context))
            get(context).cancel()
    }
}