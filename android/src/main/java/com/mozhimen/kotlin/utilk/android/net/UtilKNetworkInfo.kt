package com.mozhimen.kotlin.utilk.android.net

import android.content.Context
import android.net.NetworkInfo
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.net.cons.CConnectivityManager
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.annors.ADescription
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_NETWORK_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission

/**
 * @ClassName UtilKNetworkInterface
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/8/7 1:48
 * @Version 1.0
 */
object UtilKNetworkInfo {
    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get(networkType: Int, context: Context): NetworkInfo? =
        UtilKConnectivityManager.getNetworkInfo( networkType,context)

    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    @JvmStatic
    fun get_ofActive(context: Context): NetworkInfo? =
        UtilKConnectivityManager.getActiveNetworkInfo(context)

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get_ofMobile(context: Context): NetworkInfo? =
        get(CConnectivityManager.TYPE_MOBILE, context)

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get_ofEthernet(context: Context): NetworkInfo? =
        get(CConnectivityManager.TYPE_ETHERNET, context)

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get_ofWifi(context: Context): NetworkInfo? =
        get(CConnectivityManager.TYPE_WIFI, context)

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresApi(CVersCode.V_21_5_L)
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun get_ofVpn(context: Context): NetworkInfo? =
        get(CConnectivityManager.TYPE_VPN, context)

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getType(networkInfo: NetworkInfo): Int =
        networkInfo.type

    @JvmStatic
    fun getState(networkInfo: NetworkInfo): NetworkInfo.State =
        networkInfo.state

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isAvailable(networkInfo: NetworkInfo): Boolean =
        networkInfo.isAvailable

    @JvmStatic
    fun isConnected(networkInfo: NetworkInfo): Boolean =
        networkInfo.isConnected

    @JvmStatic
    fun isConnectedOrConnecting(networkInfo: NetworkInfo): Boolean =
        networkInfo.isConnectedOrConnecting

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isAvailable_ofMobile(context: Context): Boolean =
        get_ofMobile(context)?.let { isAvailable(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isAvailable_ofEthernet(context: Context): Boolean =
        get_ofEthernet(context)?.let { isAvailable(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isAvailable_ofWifi(context: Context): Boolean =
        get_ofWifi(context)?.let { isAvailable(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresApi(CVersCode.V_21_5_L)
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isAvailable_ofVpn(context: Context): Boolean =
        get_ofVpn(context)?.let { isAvailable(it) } ?: false

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isConnected_ofMobile(context: Context): Boolean =
        get_ofMobile(context)?.let { isConnected(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isConnected_ofEthernet(context: Context): Boolean =
        get_ofEthernet(context)?.let { isConnected(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isConnected_ofWifi(context: Context): Boolean =
        get_ofWifi(context)?.let { isConnected(it) } ?: false

    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresApi(CVersCode.V_21_5_L)
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun isConnected_ofVpn(context: Context): Boolean =
        get_ofVpn(context)?.let { isConnected(it) } ?: false

    //////////////////////////////////////////////////////////////////////////////

    //网络是否连接
    @ADescription("isNetAvailable", "isConnectionUseful")
    @JvmStatic
    @OUsesPermission_ACCESS_NETWORK_STATE
    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    fun hasNetworkConnected(context: Context): Boolean {
        UtilKConnectivityManager.getAllNetworkInfo(context).forEach {
            if (isConnected(it)) return true
        }
        return false
    }
}