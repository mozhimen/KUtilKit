package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.elemk.java.util.cons.CDateFormat
import com.mozhimen.kotlin.utilk.java.text.date2strDate
import org.junit.Test
import java.util.Date
import java.util.Locale

/**
 * @ClassName TestUtilKDateFormat
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/13
 * @Version 1.0
 */
class TestUtilKDateFormatFormat {
    @Test
    fun date2strDate() {
        val date = Date()
        println(date.date2strDate(CDateFormat.Style.DEFAULT, Locale.CHINESE))
        println(date.date2strDate(CDateFormat.Style.FULL, Locale.CHINESE))
        println(date.date2strDate(CDateFormat.Style.LONG, Locale.CHINESE))
        println(date.date2strDate(CDateFormat.Style.MEDIUM, Locale.CHINESE))
        println(date.date2strDate(CDateFormat.Style.SHORT, Locale.CHINESE))

        println("//////////////////////////////////////")
        println(date.date2strDate(CDateFormat.Style.DEFAULT, Locale.ENGLISH))
        println(date.date2strDate(CDateFormat.Style.FULL, Locale.ENGLISH))
        println(date.date2strDate(CDateFormat.Style.LONG, Locale.ENGLISH))
        println(date.date2strDate(CDateFormat.Style.MEDIUM, Locale.ENGLISH))
        println(date.date2strDate(CDateFormat.Style.SHORT, Locale.ENGLISH))
        println("//////////////////////////////////////")

        println(date.date2strDate(CDateFormat.Style.DEFAULT, Locale.KOREA))
        println(date.date2strDate(CDateFormat.Style.FULL, Locale.KOREA))
        println(date.date2strDate(CDateFormat.Style.LONG, Locale.KOREA))
        println(date.date2strDate(CDateFormat.Style.MEDIUM, Locale.KOREA))
        println(date.date2strDate(CDateFormat.Style.SHORT, Locale.KOREA))
    }
}