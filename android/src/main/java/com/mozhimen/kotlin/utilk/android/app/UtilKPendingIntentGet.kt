package com.mozhimen.kotlin.utilk.android.app

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.mozhimen.kotlin.elemk.android.app.cons.CPendingIntent
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
    @Deprecated(
        """
        Targeting S+ (version 31 and above) requires that one of FLAG_IMMUTABLE or FLAG_MUTABLE be specified when creating a PendingIntent.
        Strongly consider using FLAG_IMMUTABLE, only use FLAG_MUTABLE if some functionality depends on the PendingIntent being mutable, e.g. if it needs to be used with inline replies or bubbles.
    """
    )
    @JvmStatic
    fun getActivity_NONE(context: Context, requestCode: Int, intent: Intent): PendingIntent =
        UtilKPendingIntent.getActivity(context, requestCode, intent, CPendingIntent.FLAG_NONE)

    @JvmStatic
    fun getActivity_IMMUTABLE(context: Context, requestCode: Int, intent: Intent): PendingIntent =
        UtilKPendingIntent.getActivity(context, requestCode, intent, CPendingIntent.FLAG_IMMUTABLE)

    @JvmStatic
    fun getActivity_UPDATE_CURRENT(context: Context, requestCode: Int, intent: Intent): PendingIntent =
        UtilKPendingIntent.getActivity(context, requestCode, intent, getFlag_UPDATE_CURRENT())

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getBroadCast_UPDATE_CURRENT(context: Context, requestCode: Int, intent: Intent): PendingIntent =
        UtilKPendingIntent.getBroadcast(context, requestCode, intent, getFlag_UPDATE_CURRENT())

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getFlag_UPDATE_CURRENT(): Int =
        if (UtilKBuildVersion.isAfterV_23_6_M()) {
            CPendingIntent.FLAG_UPDATE_CURRENT or CPendingIntent.FLAG_IMMUTABLE
        } else CPendingIntent.FLAG_UPDATE_CURRENT
}