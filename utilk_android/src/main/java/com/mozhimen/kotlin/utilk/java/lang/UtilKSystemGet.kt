package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.elemk.cons.CStrPackage

/**
 * @ClassName UtilKSystemProperty
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/30 13:43
 * @Version 1.0
 */
object UtilKSystemGet {
    @JvmStatic
    fun getProperty_line_separator(): String? =
        UtilKSystem.getProperty(CStrPackage.line_separator)
}