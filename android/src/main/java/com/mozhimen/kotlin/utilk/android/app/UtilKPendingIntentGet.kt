package com.mozhimen.kotlin.utilk.android.app

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.mozhimen.kotlin.elemk.android.app.cons.CPendingIntent
import com.mozhimen.kotlin.lintk.optins.api.OApiDeprecated_Official_AfterV_31_11_S
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKPendingIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/2 21:48
 * @Version 1.0
 */
object UtilKPendingIntentGet : IUtilK {

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getActivity_IMMUTABLE(requestCode: Int, intent: Intent, context: Context): PendingIntent =
        UtilKPendingIntent.getActivity( requestCode, intent, getFlag_IMMUTABLE(),context)

    @JvmStatic
    fun getActivity_UPDATE_CURRENT(requestCode: Int, intent: Intent, context: Context): PendingIntent =
        UtilKPendingIntent.getActivity( requestCode, intent, getFlag_UPDATE_CURRENT(),context)

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getBroadcast_IMMUTABLE(requestCode: Int, intent: Intent, context: Context): PendingIntent =
        UtilKPendingIntent.getBroadcast( requestCode, intent, getFlag_IMMUTABLE(),context)

    @JvmStatic
    fun getBroadcast_UPDATE_CURRENT(requestCode: Int, intent: Intent, context: Context): PendingIntent =
        UtilKPendingIntent.getBroadcast( requestCode, intent, getFlag_UPDATE_CURRENT(),context)

    /////////////////////////////////////////////////////////////////

    @OptIn(OApiDeprecated_Official_AfterV_31_11_S::class)
    @JvmStatic
    fun getFlag_IMMUTABLE(): Int =
        if (UtilKBuildVersion.isAfterV_31_12_S())
            CPendingIntent.FLAG_IMMUTABLE
        else
            CPendingIntent.FLAG_NONE

    @JvmStatic
    fun getFlag_UPDATE_CURRENT(): Int =
        if (UtilKBuildVersion.isAfterV_23_6_M())
            CPendingIntent.FLAG_UPDATE_CURRENT or CPendingIntent.FLAG_IMMUTABLE
        else
            CPendingIntent.FLAG_UPDATE_CURRENT
}