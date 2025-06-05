package com.mozhimen.kotlin.utilk.java.text

import android.content.Context
import com.mozhimen.kotlin.elemk.java.util.cons.CDateFormat
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.util.UtilKLocale
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.ConcurrentHashMap

/**
 * @ClassName UtilKSimpleDateFormatWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/13
 * @Version 1.0
 */
object UtilKSimpleDateFormatWrapper : IUtilK {
    private val _simpleDateFormats by lazy { ConcurrentHashMap<String, SimpleDateFormat>() }

    //////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun get(context: Context, style: Int): SimpleDateFormat {
        val key = "$style"
        if (_simpleDateFormats.containsKey(key))
            return _simpleDateFormats[key]!!
        else {
            val simpleDateFormat = when (style) {
                CDateFormat.Style.LONG -> UtilKSimpleDateFormat.get_long(context)
                CDateFormat.Style.MEDIUM -> UtilKSimpleDateFormat.get_medium(context)
                CDateFormat.Style.SHORT -> UtilKSimpleDateFormat.get_short(context)
                else -> UtilKSimpleDateFormat.get_medium(context)
            }
            _simpleDateFormats[key] = simpleDateFormat
            return simpleDateFormat
        }
    }

    @JvmStatic
    fun get(pattern: String, locale: Locale, timeZone: TimeZone? = null): SimpleDateFormat {
        val key = if (timeZone != null) {
            "$pattern$locale$timeZone"
        } else
            "$pattern$locale"
//        return _simpleDateFormats[key] ?: run {
//            val simpleDateFormat = UtilKSimpleDateFormat.get(pattern, locale)
//            _simpleDateFormats[key] = simpleDateFormat
//            simpleDateFormat
//        }
        return if (_simpleDateFormats.containsKey(key))
            _simpleDateFormats[key]!!
        else {
            UtilKSimpleDateFormat.get(pattern, locale).apply {
                if (timeZone != null) {
                    setTimeZone(timeZone)
                }
            }.also { _simpleDateFormats[key] = it }
        }
    }

    @JvmStatic
    fun get(pattern: String): SimpleDateFormat =
        get(pattern, UtilKLocale.get_default())

    @JvmStatic
    fun get(pattern: String, timeZone: TimeZone): SimpleDateFormat =
        get(pattern, UtilKLocale.get_default(), timeZone)
}