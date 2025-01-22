package com.mozhimen.kotlin.utilk.java.util

import com.mozhimen.kotlin.utilk.java.text.UtilKSimpleDateFormatFormat
import java.util.Date

/**
 * @ClassName UtilKDate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/29
 * @Version 1.0
 */
object UtilKDate {
    @JvmStatic
    fun get(): Date =
        Date()

    @JvmStatic
    fun get(date: Long): Date =
        Date(date)

    @JvmStatic
    fun getTime(date: Date): Long =
        date.time

    /**
     * 时间比较
     * @return Int -1: date2 larger, 1: date1 larger, 0: same
     */
    @JvmStatic
    fun compareTo(date1: Date, date2: Date): Int =
        date1.compareTo(date2)

    //时间比较
    @JvmStatic
    fun compareTo(strDate1: String, strDate2: String, strFormatDate: String): Int? {
        val date1 = UtilKSimpleDateFormatFormat.strDate2date(strDate1, strFormatDate)
        val date2 = UtilKSimpleDateFormatFormat.strDate2date(strDate2, strFormatDate)
        if (date1 == null || date2 == null) return null
        return compareTo(date1, date2)
    }
}