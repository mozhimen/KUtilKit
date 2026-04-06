package com.mozhimen.kotlin.utilk.android.net

import android.content.Context
import android.net.wifi.ScanResult
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_FINE_LOCATION
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_WIFI_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKWifiManager
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/3/20 22:12
 * @Version 1.0
 */
@OUsesPermission_ACCESS_WIFI_STATE
@OUsesPermission_ACCESS_FINE_LOCATION
object UtilKWifiManager {
    @JvmStatic
    fun get(context: Context): WifiManager =
        UtilKContextGet.getSystemService_WIFI(context)

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_ACCESS_WIFI_STATE
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_WIFI_STATE, CPermission.ACCESS_FINE_LOCATION])
    fun getScanResults(context: Context): List<ScanResult> =
        get(context).scanResults

    @JvmStatic
    @OUsesPermission_ACCESS_WIFI_STATE
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_WIFI_STATE, CPermission.ACCESS_FINE_LOCATION])
    fun getConnectionInfo(context: Context): WifiInfo? =
        get(context).connectionInfo

    @JvmStatic
    @OUsesPermission_ACCESS_WIFI_STATE
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_WIFI_STATE, CPermission.ACCESS_FINE_LOCATION])
    fun getConfiguredNetworks(context: Context): List<WifiConfiguration>? =
        get(context).configuredNetworks

    /////////////////////////////////////////////////////////////////////////////

    fun isWifiEnabled(context: Context): Boolean =
        get(context).isWifiEnabled
}