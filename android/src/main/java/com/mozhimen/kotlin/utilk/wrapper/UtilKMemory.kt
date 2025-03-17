package com.mozhimen.kotlin.utilk.wrapper

import android.content.Context
import com.mozhimen.kotlin.utilk.android.os.UtilKDebug_MemoryInfo

/**
 * @ClassName UtilKMemory
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/15 22:49
 * @Version 1.0
 */
/**
 * RSS和PSS 的区别：
 *
 * RSS - Resident Set Size 实际使用物理内存（包含共享库占用的内存）
 * PSS - Proportional Set Size 实际使用的物理内存（比例分配共享库占用的内存）假如有3个进程使用同一个共享库，那么每个进程的PSS就包括了1/3大小的共享库内存。通常我们使用PSS大小来作为内存性能指标。
 */
object UtilKMemory {
    @JvmStatic
    fun getPss_activityManager(context: Context): Int =
        UtilKDebug_MemoryInfo.getTotalPss_myPid(context)
}