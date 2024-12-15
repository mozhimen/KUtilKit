package com.mozhimen.kotlin.utilk.java.net

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
}