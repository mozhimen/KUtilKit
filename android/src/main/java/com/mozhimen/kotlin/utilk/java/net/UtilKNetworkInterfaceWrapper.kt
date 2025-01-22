package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.commons.IAB_CListener
import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.Enumeration

/**
 * @ClassName UtilKNetworkInterfaceWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKNetworkInterfaceWrapper:IUtilK {
    @JvmStatic
    fun getNetworkInterface(condition: IA_BListener<NetworkInterface, Boolean>): NetworkInterface? {
        try {
            val networkInterfaces: Enumeration<NetworkInterface> = UtilKNetworkInterface.gets()
            var networkInterface: NetworkInterface
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement()
                if (condition.invoke(networkInterface)) {
                    return networkInterface
                }
            }
        } catch (e: SocketException) {
            e.printStackTrace()
            "getInetAddress SocketException ${e.message}".e(TAG)
        }
        return null
    }

    @JvmStatic
    fun getInetAddress(condition: IAB_CListener<NetworkInterface, InetAddress, Boolean>): InetAddress? {
        try {
            val networkInterfaces: Enumeration<NetworkInterface> = UtilKNetworkInterface.gets()
            var networkInterface: NetworkInterface
            var inetAddresses: Enumeration<InetAddress>
            var inetAddress: InetAddress
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement()
                inetAddresses = networkInterface.inetAddresses
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement()
                    if (condition.invoke(networkInterface, inetAddress)) {
                        return inetAddress
                    }
                }
            }
        } catch (e: SocketException) {
            e.printStackTrace()
            "getInetAddress SocketException ${e.message}".e(TAG)
        }
        return null
    }
}