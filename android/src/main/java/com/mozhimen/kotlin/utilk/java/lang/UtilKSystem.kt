package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.elemk.cons.CPackage
import com.mozhimen.kotlin.elemk.cons.CStrPackage

/**
 * @ClassName UtilKSystem
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/4 11:32
 * @Version 1.0
 */
object UtilKSystem {
    @JvmStatic
    fun getProperty(key: String): String? =
        System.getProperty(key)

    @JvmStatic
    fun gc() {
        System.gc()
    }
}