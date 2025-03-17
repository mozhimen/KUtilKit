package com.mozhimen.kotlin.utilk.android

import android.os.Debug.MemoryInfo
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName UtilKDebug_MemoryInfoWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/15 22:47
 * @Version 1.0
 */
object UtilKDebug_MemoryInfoWrapper {
    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_java_heap(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.java-heap")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_code(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.code")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_stack(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.stack")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_graphics(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.graphics")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_private_other(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.private-other")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_system(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.system")
    }

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getMemoryStat_total_swap(memoryInfo: MemoryInfo): String? {
        return memoryInfo.getMemoryStat("summary.total-swap")
    }
}