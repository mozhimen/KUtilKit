package com.mozhimen.kotlin.utilk.android.os

import android.content.Context
import android.os.Debug.MemoryInfo
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityManager

/**
 * @ClassName UtilKDebug_MemoryInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/15 22:41
 * @Version 1.0
 */
object UtilKDebug_MemoryInfo {
    @JvmStatic
    fun get(): MemoryInfo =
        MemoryInfo()

    @JvmStatic
    fun get_myPid(context: Context): MemoryInfo? =
        UtilKActivityManager.getProcessMemoryInfo(context, intArrayOf(UtilKProcess.getMyPid()))?.get(0)

    /////////////////////////////////////////////////////////////

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat(memoryInfo: MemoryInfo, statName: String): String? {
        return memoryInfo.getMemoryStat(statName)
    }

    /////////////////////////////////////////////////////////////

    /**
     * 优点：获取的是PSS
     * 缺点：安卓P以上限制频率，需要隔约5分钟（不同手机间隔不同）才能获取到新的值。而且获取的 PSS 不包括 Graphics。
     */
    @JvmStatic
    fun getTotalPss_myPid(context: Context): Int =
        try {
            get_myPid(context)?.totalPss ?: 0
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
}