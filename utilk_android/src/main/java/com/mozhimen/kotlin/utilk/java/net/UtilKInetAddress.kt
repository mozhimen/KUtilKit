package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.commons.IAB_CListener
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp
import java.net.Inet6Address
import java.net.InetAddress
import java.net.NetworkInterface

/**
 * @ClassName UtilKInetAddress
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKInetAddress {

    @JvmStatic
    fun get(condition: IAB_CListener<NetworkInterface, InetAddress, Boolean>): InetAddress? =
        UtilKNetworkInterfaceWrapper.getInetAddress(condition)

    @JvmStatic
    fun get_ofIpv4(): InetAddress? =
        get { _, inetAddress -> inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1" }

    //获取网路IP(移动网络)
    @JvmStatic
    fun getHostAddress(): String? =
        get { _, inetAddress -> inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1" && inetAddress.hostAddress != null }?.hostAddress

    @JvmStatic
    fun getHasCode(): Int? =
        get_ofIpv4()?.hashCode()

    @JvmStatic
    fun getStrIp(): String? =
        getHasCode()?.intIp2strIp()
}