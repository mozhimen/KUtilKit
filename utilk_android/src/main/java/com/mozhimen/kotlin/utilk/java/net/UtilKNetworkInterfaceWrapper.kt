package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.IExtA_BListener
import com.mozhimen.kotlin.elemk.commons.IExt_AListener
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.java.net.UtilKNetworkInterface.TAG
import com.mozhimen.kotlin.utilk.java.net.UtilKNetworkInterface.gets
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp
import java.net.Inet6Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.Enumeration
import java.util.concurrent.locks.Condition

/**
 * @ClassName UtilKNetworkInterfaceWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKNetworkInterfaceWrapper {

    @JvmStatic
    fun getInetAddress(): InetAddress? {
        try {
            val networkInterfaces: Enumeration<NetworkInterface> = gets()
            var networkInterface: NetworkInterface
            var inetAddresses: Enumeration<InetAddress>
            var inetAddress: InetAddress
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement()
                inetAddresses = networkInterface.inetAddresses
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement()
                    if (inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1") {
                        return inetAddress
                    }
                }
            }
        } catch (e: SocketException) {
            e.printStackTrace()
            "getStrIp SocketException ${e.message}".e(TAG)
        }
        return null
    }

    @JvmStatic
    fun getInetAddress(): InetAddress? {
        try {
            val networkInterfaces: Enumeration<NetworkInterface> = gets()
            var networkInterface: NetworkInterface
            var inetAddresses: Enumeration<InetAddress>
            var inetAddress: InetAddress
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement()
                inetAddresses = networkInterface.inetAddresses
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement()
                    if (inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1") {
                        return inetAddress
                    }
                }
            }
        } catch (e: SocketException) {
            e.printStackTrace()
            "getStrIp SocketException ${e.message}".e(TAG)
        }
        return null
    }

    @JvmStatic
    fun getInetAddress(condition: IExtA_BListener<InetAddress, NetworkInterface, Boolean>): InetAddress? {
        try {
            val networkInterfaces: Enumeration<NetworkInterface> = gets()
            var networkInterface: NetworkInterface
            var inetAddresses: Enumeration<InetAddress>
            var inetAddress: InetAddress
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement()
                inetAddresses = networkInterface.inetAddresses
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement()
                    if (inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1") {
                        if (condition.invoke(inetAddress, networkInterface)) {
                            return inetAddress
                        } else {
                            continue
                        }
                    }
                }
            }
        } catch (e: SocketException) {
            e.printStackTrace()
            "getStrIp SocketException ${e.message}".e(TAG)
        }
        return null
    }
}