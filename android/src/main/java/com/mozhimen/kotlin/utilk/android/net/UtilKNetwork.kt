package com.mozhimen.kotlin.utilk.android.net

import android.content.Context
import android.net.Network
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_NETWORK_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission

/**
 * @ClassName UtilKNetwork
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/2/18 23:22
 * @Version 1.0
 */
object UtilKNetwork {
    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    @OPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get_ofActive(context: Context): Network? =
        UtilKConnectivityManager.getActiveNetwork(context)
}