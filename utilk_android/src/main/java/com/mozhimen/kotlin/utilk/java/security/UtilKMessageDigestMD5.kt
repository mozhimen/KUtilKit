package com.mozhimen.kotlin.utilk.java.security

import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * @ClassName UtilKEncryptMd5
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/6/11 17:13
 * @Version 1.0
 */
object UtilKMessageDigestMD5 : BaseUtilK() {
    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun get(): MessageDigest =
        UtilKMessageDigest.get_ofMD5()

    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun digest(bytes: ByteArray): ByteArray =
        get().digest(bytes)
}