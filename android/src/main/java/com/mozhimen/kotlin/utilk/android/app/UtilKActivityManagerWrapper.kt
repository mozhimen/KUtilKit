package com.mozhimen.kotlin.utilk.android.app

import android.app.ActivityManager
import android.content.Context
import android.text.TextUtils
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK


/**
 * @ClassName UtilKActivityManagerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/13
 * @Version 1.0
 */
object UtilKActivityManagerWrapper : IUtilK {
    /**
     * 判断当前应用是否启动
     */
    @JvmStatic
    fun isTaskRunning(context: Context): Boolean {
        val runningTaskInfos: List<ActivityManager.RunningTaskInfo> = UtilKActivityManager.getRunningTasks(context, Integer.MAX_VALUE) //获取当前所有存活task的信息
        for (runningTaskInfo in runningTaskInfos) {
            if (runningTaskInfo.baseActivity?.packageName == context.packageName || runningTaskInfo.topActivity?.packageName == context.packageName) {
                return true
            }
        }
        return false
    }

    /**
     * 返回app运行状态
     * @return int 1:前台 2:后台 0:不存在
     */
    @JvmStatic
    fun isTaskForeground(context: Context, maxNum: Int): Int {
        val runningTaskInfos = UtilKActivityManager.getRunningTasks(context, maxNum)
        if (runningTaskInfos[0].topActivity!!.packageName == context.packageName) {
            return 1
        } else {
            for (info in runningTaskInfos) {// 判断程序是否在栈里
                if (info.topActivity!!.packageName == context.packageName) {
                    return 2
                }
            }
            return 0 // 栈里找不到，返回0
        }
    }


    /**
     * 判断某个界面是否在前台
     * @param className 某个界面名称
     */
    @JvmStatic
    fun isActivityForeground(context: Context, className: String): Boolean {
        if (TextUtils.isEmpty(className)) {
            UtilKLogWrapper.d(TAG, "isActivityForeground: className is null")
            return false
        }
        val runningTaskInfos = UtilKActivityManager.getRunningTasks(context,1)
        if (runningTaskInfos.isNotEmpty()) {
            val component = runningTaskInfos[0].topActivity
            if (className == component?.className) {
                return true
            }
        }
        return false
    }
}