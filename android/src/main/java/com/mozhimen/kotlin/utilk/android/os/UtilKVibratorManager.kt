package com.mozhimen.kotlin.utilk.android.os

import android.content.Context
import android.os.VibratorManager
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKVibratorManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/31 15:17
 * @Version 1.0
 */
object UtilKVibratorManager {
    @RequiresApi(CVersCode.V_31_12_S)
    fun get(context: Context): VibratorManager =
        UtilKContextGet.getSystemService_VIBRATOR_MANAGER(context)
}