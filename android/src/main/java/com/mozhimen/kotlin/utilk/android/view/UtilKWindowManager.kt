package com.mozhimen.kotlin.utilk.android.view

import android.content.Context
import android.view.Display
import android.view.WindowManager
import android.view.WindowMetrics
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet


/**
 * @ClassName UtilKWindowManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 10:33
 * @Version 1.0
 */
object UtilKWindowManager {

    @JvmStatic
    fun get(context: Context): WindowManager =
        UtilKContextGet.getSystemService_WINDOW(context)

    @RequiresApi(CVersCode.V_30_11_R)
    @JvmStatic
    fun getCurrentWindowMetrics(context: Context): WindowMetrics =
        get(context).currentWindowMetrics

    @JvmStatic
    fun getDefaultDisplay(context: Context): Display =
        get(context).defaultDisplay
}