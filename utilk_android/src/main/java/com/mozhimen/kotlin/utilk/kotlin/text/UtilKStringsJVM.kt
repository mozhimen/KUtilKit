package com.mozhimen.kotlin.utilk.kotlin.text

import com.mozhimen.kotlin.elemk.cons.CMsg

/**
 * @ClassName UtilKFilter
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/2
 * @Version 1.0
 */
fun String.replaceLineBreak2strHtmlBr(): String =
    UtilKStringsJVM.replaceLineBreak2strHtmlBr(this)

fun String.replaceDot(): String =
    UtilKStringsJVM.replaceDot(this)

fun String.removeLineBreakStr(): String =
    UtilKStringsJVM.removeLineBreakStr(this)

fun String.removeLineBreak(): String =
    UtilKStringsJVM.removeLineBreak(this)

fun String.removeEnd_ofLineBreak(): String =
    UtilKStringsJVM.removeEnd_ofLineBreak(this)

fun String.removeStart_ofLineBreak(): String =
    UtilKStringsJVM.removeStart_ofLineBreak(this)

fun String.removeEnd_ofSeparator(): String =
    UtilKStringsJVM.removeEnd_ofSeparator(this)

fun String.removeStart_ofSeparator(): String =
    UtilKStringsJVM.removeStart_ofSeparator(this)

fun String.removeStart_of(prefix: String): String =
    UtilKStringsJVM.removeStart_of(this, prefix)

fun String.addStart_of0_ofDot(): String =
    UtilKStringsJVM.addStart_of0_ofDot(this)

fun String.addStart_ofPlus(): String =
    UtilKStringsJVM.addStart_ofPlus(this)

fun String.replaceSqliteSpecialCharacters(): String =
    UtilKStringsJVM.replaceSqliteSpecialCharacters(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKStringsJVM {
    @JvmStatic
    fun replaceSqliteSpecialCharacters(str: String): String {
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
    fun replaceLineBreak2strHtmlBr(str: String): String =
        str.replace(CMsg.LINE_BREAK, "<br>")

    @JvmStatic
    fun replaceDot(str: String): String =
        str.replace(",", ".")

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun removeLineBreakStr(str: String): String =
        str.replace(CMsg.LINE_BREAK_STR, "")

    @JvmStatic
    fun removeLineBreak(str: String): String =
        str.replace(CMsg.LINE_BREAK, "")

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun removeEnd_ofLineBreak(str: String): String =
        if (str.endsWith(CMsg.LINE_BREAK)) str.substring(0, str.length - 1) else str

    @JvmStatic
    fun removeEnd_ofSeparator(str: String): String =
        if (str.endsWith("/")) str.substring(0, str.length - 1) else str

    @JvmStatic
    fun removeStart_ofLineBreak(str: String): String =
        if (str.startsWith(CMsg.LINE_BREAK)) str.substring(1) else str

    @JvmStatic
    fun removeStart_ofSeparator(str: String): String =
        if (str.startsWith("/")) str.substring(1) else str

    @JvmStatic
    fun removeStart_of(str: String, prefix: String): String =
        if (str.startsWith(prefix)) str.substring(prefix.length) else str

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addStart_of0_ofDot(str: String): String =
        if (str.startsWith(".")) "0$str" else str

    @JvmStatic
    fun addStart_ofPlus(str: String): String =
        if (!str.startsWith("+")) "+$str" else str

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun fillStart_of0(number: Number, decimal: Int): String =
        String.format("%0${decimal}d", number)
}