package com.mozhimen.kotlin.utilk.android.app

import android.app.ActivityManager
import android.app.ActivityManager.MemoryInfo
import android.app.ActivityManager.RunningTaskInfo
import android.content.Context
import android.content.pm.ConfigurationInfo
import android.os.Debug
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet
import com.mozhimen.kotlin.utilk.android.os.UtilKProcess

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
        UtilKContextGet.getSystemService_ACTIVITY(context)

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

    /**
     * 2. 通过接口ActivityManager接口获取运行时内存（PSS）
     *
     * 优点：获取的是PSS
     * 缺点：安卓P以上限制频率，需要隔约5分钟（不同手机间隔不同）才能获取到新的值。而且获取的 PSS 不包括 Graphics。
     */
    @JvmStatic
    fun getProcessMemoryInfo(context: Context, pids: IntArray): Array<out Debug.MemoryInfo>? =
        get(context).getProcessMemoryInfo(pids)

//        try {
//            get(context).getProcessMemoryInfo(intArrayOf(UtilKProcess.getMyPid()))[0].totalPss
//        } catch (e: Exception) {
//            0
//        }
}