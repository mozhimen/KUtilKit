package com.mozhimen.kotlin.utilk.kotlin.text

import com.mozhimen.kotlin.elemk.cons.CMsg

/**
 * @ClassName UtilKFilter
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/2
 * @Version 1.0
 */
fun String.replace_sqliteSpecialCharacters(): String =
    UtilKStringsJVMWrapper.replace_sqliteSpecialCharacters(this)

fun String.replace_lineBreak2strHtmlBr(): String =
    UtilKStringsJVMWrapper.replace_lineBreak2strHtmlBr(this)

fun String.replace_dot2period(): String =
    UtilKStringsJVMWrapper.replace_dot2period(this)

fun String.replace_lineBreakStr2none(): String =
    UtilKStringsJVMWrapper.replace_lineBreakStr2none(this)

fun String.replace_lineBreak2none(): String =
    UtilKStringsJVMWrapper.replace_lineBreak2none(this)

/////////////////////////////////////////////////////////////////////////////

fun String.substring_end_lineBreak(): String =
    UtilKStringsJVMWrapper.substring_end_lineBreak(this)

fun String.substring_end_separator(): String =
    UtilKStringsJVMWrapper.substring_end_separator(this)

fun String.substring_end(suffix: String): String =
    UtilKStringsJVMWrapper.substring_end(this, suffix)

fun String.substring_sta_lineBreak(): String =
    UtilKStringsJVMWrapper.substring_sta_lineBreak(this)

fun String.substring_sta_separator(): String =
    UtilKStringsJVMWrapper.substring_sta_separator(this)

fun String.substring_sta(prefix: String): String =
    UtilKStringsJVMWrapper.substring_sta(this, prefix)

/////////////////////////////////////////////////////////////////////////////

fun String.join_sta_0(): String =
    UtilKStringsJVMWrapper.join_sta_0(this)

fun String.join_sta_plus(): String =
    UtilKStringsJVMWrapper.join_sta_plus(this)

fun String.join_end_lineBreak(): String =
    UtilKStringsJVMWrapper.join_end_lineBreak(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKStringsJVMWrapper {
    @JvmStatic
    fun replace_sqliteSpecialCharacters(str: String): String {
        return str.replace("'", "''")
            .replace("/", "//")
            .replace("[", "/[")
            .replace("]", "/]")
            .replace("%", "/%")
            .replace("&", "/&")
            .replace("_", "/_")
            .replace("(", "/(")
            .replace(")", "/)")
            .replace("（", "/（")
            .replace("）", "/）")
            .replace("\u0000", "")// 1. 移除字符串中的 NULL 字符 (\0)
            .replace("\b", "") // 删除退格符
            .replace("\t", " ") // 替换制表符为一个空格
            .replace("\n", " ") // 替换换行为一个空格
            .replace("\r", " ") // 替换回车为一个空格
    }

    @JvmStatic
    fun replace_lineBreak2strHtmlBr(str: String): String =
        str.replace(CMsg.LINE_BREAK, "<br>")

    @JvmStatic
    fun replace_dot2period(str: String): String =
        str.replace(",", ".")

    @JvmStatic
    fun replace_lineBreakStr2none(str: String): String =
        str.replace(CMsg.LINE_BREAK_STR, "")

    @JvmStatic
    fun replace_lineBreak2none(str: String): String =
        str.replace(CMsg.LINE_BREAK, "")

    ///////////////////////////////////////////////////////////////////

    /**
     * 过滤长度
     */
    @JvmStatic
    fun substring_length(str: String, endIndex: Int): String =
        if (endIndex in str.indices) str.substring(0, endIndex) else str

    @JvmStatic
    fun substring_end_lineBreak(str: String): String =
        substring_end(str, CMsg.LINE_BREAK)

    @JvmStatic
    fun substring_end_separator(str: String): String =
        substring_end(str, "/")

    @JvmStatic
    fun substring_end(str: String, suffix: String): String =
        if (str.endsWith(suffix)) str.substring(0, str.length - 1) else str

    @JvmStatic
    fun substring_sta_lineBreak(str: String): String =
        substring_sta(str, CMsg.LINE_BREAK)

    @JvmStatic
    fun substring_sta_separator(str: String): String =
        substring_sta(str, "/")

    @JvmStatic
    fun substring_sta(str: String, prefix: String): String =
        if (str.startsWith(prefix)) str.substring(prefix.length) else str

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun join_sta_0(str: String): String =
        if (str.startsWith(".")) "0$str" else str

    @JvmStatic
    fun join_sta_plus(str: String): String =
        if (!str.startsWith("+")) "+$str" else str

    @JvmStatic
    fun join_end_lineBreak(str: String): String =
        if (!str.endsWith(CMsg.LINE_BREAK)) str + CMsg.LINE_BREAK else str

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun format_fillStart0(digit: Int, obj: Number): String =
        String.format("%0${digit}d", obj)

    @JvmStatic
    fun format_fillStart0(digit: Int, obj: String): String =
        String.format("%0${digit}s", obj).replace(" ", "0")
}