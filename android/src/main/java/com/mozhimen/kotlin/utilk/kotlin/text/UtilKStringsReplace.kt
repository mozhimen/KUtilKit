package com.mozhimen.kotlin.utilk.kotlin.text

import com.mozhimen.kotlin.elemk.cons.CMsg

/**
 * @ClassName UtilKStringsReplace
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/29
 * @Version 1.0
 */
fun String.replace_lineBreak2lineBreak(): String =
    UtilKStringsReplace.replace_lineBreak2lineBreak(this)

fun String.replace_doubleQuote2none(): String =
    UtilKStringsReplace.replace_doubleQuote2none(this)

fun String.replace_brackets_content2none(): String =
    UtilKStringsReplace.replace_brackets_content2none(this)

fun String.replace_v2none(): String =
    UtilKStringsReplace.replace_v2none(this)

//////////////////////////////////////////////////////////////////////////////

fun String.replace_2digits(): String =
    UtilKStringsReplace.replace_2digits(this)

fun String.replace_2alphabets(): String =
    UtilKStringsReplace.replace_2alphabets(this)

fun String.replace_2chinese(): String =
    UtilKStringsReplace.replace_2chinese(this)

fun String.replace_2digits_alphabets_chinese(): String =
    UtilKStringsReplace.replace_2digits_alphabets_chinese(this)

//////////////////////////////////////////////////////////////////////////////

object UtilKStringsReplace {
    @JvmStatic
    fun replace_lineBreak2lineBreak(str: String): String =
        str.replace(UtilKRegexGet.get_lineBreak(), CMsg.LINE_BREAK)

    @JvmStatic
    fun replace_doubleQuote2none(str: String): String =
        str.replace(UtilKRegexGet.get_doubleQuote(), "")

    @JvmStatic
    fun replace_brackets_content2none(str: String): String =
        str.replace(UtilKRegexGet.get_brackets_content(), "")

    @JvmStatic
    fun replace_v2none(str: String): String =
        str.replace(UtilKRegexGet.get_v(), "")

    /**
     * 过滤出数字
     */
    @JvmStatic
    fun replace_2digits(str: String): String =
        str.replace(UtilKRegexGet.get_digits3(), "")

    /**
     * 过滤出字母
     */
    @JvmStatic
    fun replace_2alphabets(str: String): String =
        str.replace(UtilKRegexGet.get_alphabets(), "")

    /**
     * 过滤出中文
     */
    @JvmStatic
    fun replace_2chinese(str: String): String =
        str.replace(UtilKRegexGet.get_chinese(), "")

    /**
     * 过滤出字母、数字和中文
     */
    @JvmStatic
    fun replace_2digits_alphabets_chinese(str: String): String =
        str.replace(UtilKRegexGet.get_digits_alphabets_chinese(), "")
}