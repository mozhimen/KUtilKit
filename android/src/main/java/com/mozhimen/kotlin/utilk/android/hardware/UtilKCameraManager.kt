package com.mozhimen.kotlin.utilk.android.hardware

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKCameraManager
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/26
 * @Version 1.0
 */
object UtilKCameraManager {
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get(context: Context): CameraManager =
        UtilKContextGet.getSystemService_CAMERA(context)
}