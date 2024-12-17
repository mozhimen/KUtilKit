package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.java.net.UtilKNetworkInterface.TAG
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp
import java.net.Inet6Address

/**
 * @ClassName UtilKInetAddressWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKInetAddressWrapper {
    @JvmStatic
    fun printStrIp() {
        var name = ""
        val inetAddress = UtilKInetAddress.get { networkInterface, inetAddress ->
            name = networkInterface.name
            inetAddress !is Inet6Address && !inetAddress.isLoopbackAddress && inetAddress.hostAddress != "127.0.0.1"
        }
        UtilKLogWrapper.i(TAG, "printStrIP Found new IP: ${inetAddress?.hashCode()?.intIp2strIp()} at $name")
    }
}