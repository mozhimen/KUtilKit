package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.java.net.UtilKNetworkInterface.TAG
import com.mozhimen.kotlin.utilk.kotlin.intIp2strIp

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
        val inetAddress = UtilKInetAddress.get { networkInterface->
            name = networkInterface.name;true
        }
        UtilKLogWrapper.i(TAG, "printStrIP Found new IP: ${inetAddress?.hashCode()?.intIp2strIp()} at $name")
    }
}