package com.mozhimen.kotlin.utilk.javax.net

import com.mozhimen.kotlin.elemk.javax.net.bases.BaseX509TrustManager
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager

/**
 * @ClassName UtilKSSLContext
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/28 16:19
 * @Version 1.0
 */
object UtilKSSLContext : IUtilK {
    @JvmStatic
    fun get_ofTLS(): SSLContext =
        SSLContext.getInstance("TLS").apply {
            init(null, arrayOf<TrustManager>(BaseX509TrustManager()), SecureRandom())
        }

    @JvmStatic
    fun get_ofSSL(): SSLContext =
        SSLContext.getInstance("SSL").apply {
            init(null, arrayOf<TrustManager>(BaseX509TrustManager()), SecureRandom())
        }

    //////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getSocketFactory_ofTLS(): SSLSocketFactory =
        get_ofTLS().socketFactory

    @JvmStatic
    fun getSocketFactory_ofSSL(): SSLSocketFactory =
        get_ofSSL().socketFactory
}