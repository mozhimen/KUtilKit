package com.mozhimen.kotlin.utilk.java.net

import com.mozhimen.kotlin.elemk.java.net.cons.CURI
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.net.URI
import java.net.URISyntaxException

/**
 * @ClassName UtilKURI
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/3 18:17
 * @Version 1.0
 */
object UtilKURI : IUtilK {

    @JvmStatic
    fun isSchemeValid(uRI: URI): Boolean =
        uRI.scheme.equals(CURI.Scheme.http) || uRI.scheme.equals(CURI.Scheme.https) || uRI.scheme.equals(CURI.Scheme.tcp) || uRI.scheme.equals(CURI.Scheme.udp)

    /**
     * 判断strUrl是否可连
     */
    @JvmStatic
    fun isStrUrlConnectable(strUrl: String): Boolean {
        val uRI: URI?
        try {
            uRI = URI(strUrl)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return false
        }
        if (uRI.host == null) {
            return false
        } else if (!isSchemeValid(uRI)) {
            return false
        }
        return true
    }
}