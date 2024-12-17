package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.lintk.optins.OApiDeprecated_Official_AfterV_28_9_P
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp
import java.net.Inet6Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.Enumeration


/**
 * @ClassName UtilKNetworkInterface
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/9/27 11:34
 * @Version 1.0
 */
object UtilKNetworkInterface : IUtilK {
    @JvmStatic
    fun gets(): Enumeration<NetworkInterface> =
        NetworkInterface.getNetworkInterfaces()

    @JvmStatic
    fun get(condition: IA_BListener<NetworkInterface, Boolean>): NetworkInterface? =
        UtilKNetworkInterfaceWrapper.getNetworkInterface(condition)

    @JvmStatic
    fun get_ofWlan(): NetworkInterface? =
        get { networkInterface -> networkInterface.name == "wlan0" }

    ////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getHardwareAddress(): ByteArray? =
        get_ofWlan()?.hardwareAddress

    /**
     * 23-28
     * 获取代码和上面一致，但是从API 29（Android10.0）开始，连接不同的WI-FI时会获取到不同的MAC地址。
     * 从API 30（Android11.0）开始，已无法获取到MAC地址。
     */
    @OApiDeprecated_Official_AfterV_28_9_P
    @JvmStatic
    fun getMac(): String? =
        getHardwareAddress()?.joinToString(":") { macAddress -> String.format("%02X", macAddress) }
}