package com.mozhimen.kotlin.utilk.android.hardware

import android.content.Context
import android.hardware.display.DisplayManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet


/**
 * @ClassName UtilKDisplayManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/21 11:36
 * @Version 1.0
 */
object UtilKDisplayManager {
    @JvmStatic
    fun get(context: Context): DisplayManager =
        UtilKContextGet.getSystemService_DISPLAY(context)
}