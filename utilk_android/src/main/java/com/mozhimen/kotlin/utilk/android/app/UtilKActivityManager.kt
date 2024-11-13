package com.mozhimen.kotlin.utilk.android.app

import android.app.ActivityManager
import android.app.ActivityManager.MemoryInfo
import android.app.ActivityManager.RunningTaskInfo
import android.content.Context
import android.content.pm.ConfigurationInfo
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKActivityManager
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/3/20 23:23
 * @Version 1.0
 */
object UtilKActivityManager {
    @JvmStatic
    fun get(context: Context): ActivityManager =
        UtilKContext.getActivityManager(context)

    @JvmStatic
    fun getMemoryInfo(context: Context, memoryInfo: MemoryInfo) {
        get(context).getMemoryInfo(memoryInfo)
    }

    @JvmStatic
    fun getRunningAppProcesses(context: Context): List<ActivityManager.RunningAppProcessInfo> =
        get(context).runningAppProcesses

    @JvmStatic
    fun getDeviceConfigurationInfo(context: Context): ConfigurationInfo =
        get(context).deviceConfigurationInfo

    @JvmStatic
    fun getRunningTasks(context: Context, maxCount: Int): List<RunningTaskInfo> =
        get(context).getRunningTasks(maxCount)
}