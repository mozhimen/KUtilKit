package com.mozhimen.kotlin.utilk.android.app

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName UtilKPendingIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/6/18 23:18
 * @Version 1.0
 */
object UtilKPendingIntent {
    @JvmStatic
    fun getActivity(requestCode: Int, intent: Intent, flags: Int, context: Context): PendingIntent =
        PendingIntent.getActivity(context, requestCode, intent, flags)

    @JvmStatic
    fun getActivity(requestCode: Int, intent: Intent, flags: Int, opts: Bundle?, context: Context): PendingIntent =
        PendingIntent.getActivity(context, requestCode, intent, flags, opts)

    @JvmStatic
    fun getBroadcast(requestCode: Int, intent: Intent, flags: Int, context: Context): PendingIntent =
        PendingIntent.getBroadcast(context, requestCode, intent, flags)

    @JvmStatic
    fun getService(requestCode: Int, intent: Intent, flags: Int, context: Context): PendingIntent =
        PendingIntent.getService(context, requestCode, intent, flags)

    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getForegroundService(requestCode: Int, intent: Intent, flags: Int, context: Context): PendingIntent =
        PendingIntent.getForegroundService(context, requestCode, intent, flags)

    @JvmStatic
    fun getActivities(requestCode: Int, intents: Array<Intent>, flags: Int, context: Context): PendingIntent =
        PendingIntent.getActivities(context, requestCode, intents, flags)

    @JvmStatic
    fun getActivities(requestCode: Int, intents: Array<Intent>, flags: Int, opts: Bundle?, context: Context): PendingIntent =
        PendingIntent.getActivities(context, requestCode, intents, flags, opts)

}