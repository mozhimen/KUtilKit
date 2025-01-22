package com.mozhimen.kotlin.utilk.android.app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion

/**
 * @ClassName UtilKNotificationChannel
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/3
 * @Version 1.0
 */
object UtilKNotificationChannel {
    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun get(channelId: String, channelName: String, importance: Int): NotificationChannel =
        NotificationChannel(channelId, channelName, importance)

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun get(notificationManager: NotificationManager, channelId: String): NotificationChannel? =
        UtilKNotificationManager.getNotificationChannel(notificationManager, channelId)

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun applyDescription(notificationChannel: NotificationChannel, description: String) {
        notificationChannel.description = description
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun applyLockscreenVisibility(notificationChannel: NotificationChannel, lockscreenVisibility: Int) {
        notificationChannel.lockscreenVisibility = lockscreenVisibility
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun applySound(notificationChannel: NotificationChannel, uri: Uri, audioAttributes: AudioAttributes) {
        notificationChannel.setSound(uri, audioAttributes)
    }
}