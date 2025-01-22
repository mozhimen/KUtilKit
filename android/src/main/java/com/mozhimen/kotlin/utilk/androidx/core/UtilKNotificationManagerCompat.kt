package com.mozhimen.kotlin.utilk.androidx.core

import androidx.core.app.NotificationManagerCompat
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKNotificationManagerCompat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/9/18 17:52
 * @Version 1.0
 */
object UtilKNotificationManagerCompat : BaseUtilK() {
    @JvmStatic
    fun areNotificationsEnabled(): Boolean =
        NotificationManagerCompat.from(_context).areNotificationsEnabled()
}