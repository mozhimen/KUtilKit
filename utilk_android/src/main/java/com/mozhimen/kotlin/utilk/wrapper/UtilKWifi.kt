package com.mozhimen.kotlin.utilk.wrapper

import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.net.cons.CWifiManager
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_FINE_LOCATION
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_NETWORK_STATE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_WIFI_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.net.UtilKWifiInfo
import com.mozhimen.kotlin.utilk.android.net.UtilKWifiManager
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.kotlin.text.removeRegexDoubleQuote

object UtilKWifi : BaseUtilK() {

    @JvmStatic
    @RequiresPermission(allOf = [CPermission.ACCESS_WIFI_STATE, CPermission.ACCESS_FINE_LOCATION, CPermission.ACCESS_NETWORK_STATE])
    @OPermission_ACCESS_WIFI_STATE
    @OPermission_ACCESS_NETWORK_STATE
    @OPermission_ACCESS_FINE_LOCATION
    fun getIpAddress(): String {
        var ipAddress = 0
        ipAddress = if (UtilKBuildVersion.isAfterV_29_10_Q()) {
            UtilKWifiInfo.getIpAddress_ofActive(_context) ?: 0
        } else
            UtilKWifiInfo.getIpAddress_ofMgr(_context) ?: 0
        if (ipAddress == 0) return ""
        return (ipAddress and 0xFF).toString() + "." + (ipAddress shr 8 and 0xFF) + "." + (ipAddress shr 16 and 0xFF) + "." + (ipAddress shr 24 and 0xFF)
    }

    @JvmStatic
    @OPermission_ACCESS_WIFI_STATE
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_WIFI_STATE, CPermission.ACCESS_FINE_LOCATION])
    fun getName(): String {
        if (!UtilKWifiManager.isWifiEnabled(_context))
            return CWifiManager.DISABLED
        val wifiInfo = UtilKWifiManager.getConnectionInfo(_context) ?: return CWifiManager.NO_CONNECT
        return if (wifiInfo.ssid == CWifiManager.UNKNOWN_SSID) {
            if (UtilKBuildVersion.isAfterV_26_8_O()) {
                if (UtilKPermission.isSelfGranted(CPermission.ACCESS_FINE_LOCATION)) {
                    val configuredNetworks = UtilKWifiManager.getConfiguredNetworks(_context)
                    if (!configuredNetworks.isNullOrEmpty()) {
                        for (wifiConfiguration in configuredNetworks) {
                            if (wifiConfiguration.networkId == wifiInfo.networkId)
                                return wifiConfiguration.SSID.removeRegexDoubleQuote()
                        }
                    }
                } else CWifiManager.PERMISSION_DENIED
            } else CWifiManager.NO_CONNECT
            CWifiManager.UNKNOWN
        } else wifiInfo.ssid.removeRegexDoubleQuote()
    }
}