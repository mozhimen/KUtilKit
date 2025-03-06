package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.I_AListener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.kotlin.ranges.constraint
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegexGet
import com.mozhimen.kotlin.utilk.kotlin.text.replace_brackets_content2none
import java.util.Locale

/**
 * @ClassName UtilKStringWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/11
 * @Version 1.0
 */
inline fun String?.getEmptyOrDefault(default: I_AListener<String> = { "" }): String =
    UtilKStringWrapper.getEmptyOrDefault(this, default)

/////////////////////////////////////////////////////////////////////////////

fun String.getSplitLastIndexToEnd(splitStr: String): String =
    UtilKStringWrapper.getSplitLastIndexToEnd(this, splitStr)

fun String.getSplitLastIndexToStart(splitStr: String, isContainSplitStr: Boolean = true): String =
    UtilKStringWrapper.getSplitLastIndexToStart(this, splitStr, isContainSplitStr)

fun String.getSplitFirstIndexToStart(splitStr: String): String =
    UtilKStringWrapper.getSplitFirstIndexToStart(this, splitStr)

fun String.getSplitFirstIndexToEnd(splitStr: String): String =
    UtilKStringWrapper.getSplitFirstIndexToEnd(this, splitStr)

/////////////////////////////////////////////////////////////////////////////

fun String.getAbbreviatedName(): String =
    UtilKStringWrapper.getAbbreviatedName(this)

fun String.getStandardName(): String =
    UtilKStringWrapper.getStandardName(this)

/////////////////////////////////////////////////////////////////////////////

fun String.isNotEmptyOrElse(isNotEmptyBlock: I_Listener, orElseBlock: I_Listener) {
    UtilKStringWrapper.isNotEmptyOrElse(this, isNotEmptyBlock, orElseBlock)
}

fun String.hasSpace(): Boolean =
    UtilKStringWrapper.hasSpace(this)

fun String.containStr(str: String): Boolean =
    UtilKStringWrapper.containStr(this, str)

fun String.containsAny(collection: Collection<String>): Boolean =
    UtilKStringWrapper.containsAny(this, collection)

fun String.containsAny_return(collection: List<String>): String? =
    UtilKStringWrapper.containsAny_return(this, collection)

fun String.equalsIgnoreCase(str: String): Boolean =
    UtilKStringWrapper.equalsIgnoreCase(this, str)

fun String.startsWithAny(strs: Collection<String>): Boolean =
    UtilKStringWrapper.startsWithAny(this, strs)

fun String.endsWithAny(strs: Collection<String>): Boolean =
    UtilKStringWrapper.endsWithAny(this, strs)

/////////////////////////////////////////////////////////////////////////////

fun String.findFirst(char: Char): Int =
    UtilKStringWrapper.findFirst(this, char)

fun String.findFirst(str: String): Int =
    UtilKStringWrapper.findFirst(this, str)

fun String.subStr(firstIndex: Int, length: Int): String =
    UtilKStringWrapper.subStr(this, firstIndex, length)

/////////////////////////////////////////////////////////////////////////////

fun String.hidePhone(): String =
    UtilKStringWrapper.hidePhone(this)

fun String.hideName(): String =
    UtilKStringWrapper.hideName(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKStringWrapper {


    @JvmStatic
    inline fun getEmptyOrDefault(str: String?, default: I_AListener<String> = { "" }): String =
        if (str.isNullOrEmpty())
            default()
        else str

    /////////////////////////////////////////////////////////////////////////////

    /**
     * 获取分割后的最后一个元素
     * "a/b/c".getSplitLastIndexToEnd("/").printlog()
     * c
     */
    @JvmStatic
    fun getSplitLastIndexToEnd(str: String, splitStr: String): String =
        str.substring(str.lastIndexOf(splitStr) + 1, str.length)

    /**
     * 获取分割后的最后一个元素的互斥集合
     * "a/b/c".getSplitLastIndexToStart("/").printlog()
     * "a/b/c".getSplitLastIndexToStart("/",false).printlog()
     * a/b/
     * a/b
     */
    @JvmStatic
    fun getSplitLastIndexToStart(str: String, splitStr: String, isContainSplitStr: Boolean = true): String =
        if (isContainSplitStr)
            str.substring(0, str.lastIndexOf(splitStr) + 1)
        else {
            val index = str.lastIndexOf(splitStr)
            if (index >= 0) str.substring(0, index) else str
        }

    /**
     * 获取分割后的第一个元素
     * "a/b/c".getSplitFirstIndexToStart("/").printlog()
     * a
     */
    @JvmStatic
    fun getSplitFirstIndexToStart(str: String, splitStr: String): String {
        val index = str.indexOf(splitStr)
        return if (index >= 0) str.substring(0, index) else str
    }

    /**
     * 获取分割后的第一个元素的互斥集合
     * "a/b/c".getSplitFirstIndexToEnd("/").printlog()
     * b/c
     */
    @JvmStatic
    fun getSplitFirstIndexToEnd(str: String, splitStr: String): String {
        val index = str.indexOf(splitStr)
        return if (index >= 0) str.substring(index + 1, str.length) else str
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * 获取缩略名
     * 示例输入和输出
     * 输入："Test123(World)"
     * 输出："T12"
     *
     * 输入："hello123"
     * 输出："H"
     *
     * 输入："Abc&123"
     * 输出："A&1"
     *
     * 输入："()!"
     * 输出："(" （括号被删除，最终返回原字符串的第一个字符）
     */
    @JvmStatic
    fun getAbbreviatedName(str: String): String {
        return str.replace_brackets_content2none()
            .asSequence()
            .filter { it.isDigit() or it.isUpperCase() or (it == '&') }
            .take(3)
            .joinToString("")
            .ifBlank { str.first().toString() }
            .capitalize()//首字母大写
    }

    /**
     * 获取标准名
     */
    @JvmStatic
    fun getStandardName(str: String): String {
        return str.replace(UtilKRegexGet.get_digits_alphabets(), "-") // 替换非字母数字字符为 '-'
            .replace(UtilKRegexGet.get_end_(), "")           // 去掉末尾的多余 '-'
            .ifEmpty { "-" }                     // 如果为空字符串，替换为 '-'
            .lowercase()
    }

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isNotEmptyOrElse(str: String, isNotEmptyBlock: I_Listener, orElseBlock: I_Listener) {
        if (str.isNotEmpty()) isNotEmptyBlock.invoke() else orElseBlock.invoke()
    }

    /**
     * 判断是否不为Empty
     */
    @JvmStatic
    fun isNotEmpty(vararg str: String): Boolean {
        for (char in str) if (char.isEmpty()) return false
        return true
    }

    /**
     * 是否含有空格
     */
    @JvmStatic
    fun hasSpace(str: String): Boolean {
        var i = 0
        val len = str.length
        while (i < len) {
            if (!Character.isWhitespace(str[i])) return false
            ++i
        }
        return true
    }

    /**
     * 包含String
     */
    @JvmStatic
    fun containStr(strContent: String, str: String): Boolean {
        if (strContent.isEmpty() || str.isEmpty()) return false
        return strContent.contains(str)
    }

    @JvmStatic
    fun containsAny(strContent: String, strs: Collection<String>): Boolean =
        strs.any { strContent.containStr(it) }

    @JvmStatic
    fun containsAny_return(strContent: String, strs: List<String>, ignoreCache: Boolean = false): String? {
        for (i in strs.indices) {
            if ((if (ignoreCache) strContent.lowercase(Locale.getDefault()) else strContent).contains(if (ignoreCache) strs[i].lowercase(Locale.getDefault()) else strs[i])) {
                return strs[i] // 如果发现任何一个关键词出现，则返回true
            }
        }
        return null // 如果没有任何关键词出现，则返回false
    }

    @JvmStatic
    fun equalsIgnoreCase(str: String, str1: String): Boolean =
        str.equals(str1, true)

    @JvmStatic
    fun startsWithAny(str: String, strs: Collection<String>): Boolean =
        strs.any { str.startsWith(it) }

    @JvmStatic
    fun endsWithAny(str: String, strs: Collection<String>): Boolean =
        strs.any { str.endsWith(it) }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * 找到第一个匹配的字符的位置
     */
    @JvmStatic
    fun findFirst(strContent: String, char: Char): Int =
        strContent.indexOfFirst { it == char }

    /**
     * 找到第一个匹配的字符串的位置
     */
    @JvmStatic
    fun findFirst(strContent: String, str: String): Int =
        strContent.indexOf(str)

    /**
     * 切割字符串
     */
    @JvmStatic
    fun subStr(strContent: String, firstIndex: Int, length: Int): String =
        strContent.substring(firstIndex.constraint(strContent.indices), if (firstIndex + length > strContent.length) strContent.length else firstIndex + length)

    /////////////////////////////////////////////////////////////////////////////

    /**
     * 电话号码隐藏中间四位
     */
    @JvmStatic
    fun hidePhone(str: String): String =
        if (str.length == 11) str.substring(0, 3) + "****" + str.substring(7, str.length) else str

    /**
     * 名字脱敏
     */
    @JvmStatic
    fun hideName(str: String): String {
        if (str.isEmpty()) return ""
        if (str.length <= 2) return str
        val stringBuilder = StringBuilder()
        repeat(str.length - 2) {
            stringBuilder.append("*")
        }
        return str.first() + stringBuilder.toString() + str.last()
    }
}