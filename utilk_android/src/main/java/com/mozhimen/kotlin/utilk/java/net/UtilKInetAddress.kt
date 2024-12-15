package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.commons.IExtA_BListener
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp
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
    fun get(): InetAddress? =
        UtilKNetworkInterfaceWrapper.getInetAddress()

    @JvmStatic
    fun get(condition: IExtA_BListener<InetAddress, NetworkInterface, Boolean>): InetAddress? =
        UtilKNetworkInterfaceWrapper.getInetAddress(condition)

    //获取网路IP(移动网络)
    @JvmStatic
    fun getHostAddress(): String? =
        get { hostAddress != null }?.hostAddress

    @JvmStatic
    fun getHasCode(): Int? =
        get()?.hashCode()

    @JvmStatic
    fun getStrIp(): String? =
        getHasCode()?.intIp2strIp()
}