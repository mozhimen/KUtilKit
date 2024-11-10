package com.mozhimen.kotlin.elemk.java.util.cons

import java.text.DateFormat

/**
 * @ClassName CDateFormat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CDateFormat {
    object Format {
        const val yyyy_MM_dd_HH_mm_ss_SS = "yyyy-MM-dd HH:mm:ss:SS"
        const val yyyy_MM_dd_HH_mm_ss_S = "yyyy-MM-dd HH:mm:ss:S"
        const val yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss"
        const val yyyyMMddHHmmss = "yyyyMMddHHmmss"
        const val yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm"
        const val yyyy_MM_dd_HH = "yyyy-MM-dd HH"
        const val yyyy_MM_dd = "yyyy-MM-dd"
        const val yyyyMMdd = "yyyyMMdd"
        const val HH_mm_ss = "HH:mm:ss"
        const val HH_mm = "HH:mm"
        const val mm_ss = "mm:ss"
        const val yyyy = "yyyy"
        const val MM = "MM"
        const val dd = "dd"
        const val HH = "HH"
        const val mm = "mm"
        const val ss = "ss"
    }

    object SKELETON {
        const val YYYYMMMMd = "YYYYMMMMd"
    }

    const val FULL = DateFormat.FULL
    const val LONG = DateFormat.LONG
    const val MEDIUM = DateFormat.MEDIUM
    const val SHORT = DateFormat.SHORT
    const val DEFAULT = DateFormat.DEFAULT
}