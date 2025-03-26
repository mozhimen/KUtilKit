package com.mozhimen.kotlin.utilk.android.app

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion

/**
 * @ClassName UtilKNotificationManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/2 21:33
 * @Version 1.0
 */
object UtilKNotificationManager {
    @JvmStatic
    fun get(context: Context): NotificationManager =
        UtilKContextGet.getSystemService_NOTIFICATION(context)

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun getNotificationChannel(notificationManager: NotificationManager, channelId: String): NotificationChannel? =
        notificationManager.getNotificationChannel(channelId)

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun createNotificationChannel(notificationManager: NotificationManager, notificationChannel: NotificationChannel) {
        notificationManager.createNotificationChannel(notificationChannel)
    }
}