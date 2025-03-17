package com.mozhimen.kotlin.utilk.android.os

import android.os.Debug.MemoryInfo

/**
 * @ClassName UtilKDebug
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/15 22:39
 * @Version 1.0
 */
object UtilKDebug {
    @JvmStatic
    fun getMemoryInfo(): MemoryInfo =
        MemoryInfo()
}