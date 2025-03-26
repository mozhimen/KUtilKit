package com.mozhimen.kotlin.utilk.android.hardware

import android.content.Context
import android.hardware.input.InputManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKInputManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/28
 * @Version 1.0
 */
object UtilKInputManager {
    @JvmStatic
    fun get(context: Context): InputManager =
        UtilKContextGet.getSystemService_INPUT(context)
}