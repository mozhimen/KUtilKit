package com.mozhimen.kotlin.utilk.kotlin.text

import com.mozhimen.kotlin.utilk.kotlin.str2regex

/**
 * @ClassName UtilKRegexGet
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/28
 * @Version 1.0
 */
object UtilKRegexGet {
    //////////////////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////////////////

    //只包含数字的字符串（或空字符串） 验证一个字符串是否由纯数字组成（可以为空）。
    @JvmStatic
    fun get_digits(): Regex =
        "^[0-9]*\$".str2regex()

    //至少包含一个数字的字符串片段 匹配一个或多个连续的数字
    @JvmStatic
    fun get_digits2(): Regex =
        "[0-9]+".str2regex()

    //单个非数字字符 用于查找非数字字符
    fun get_digits3(): Regex =
        "[^(0-9)]".str2regex()

    //过滤数字字母
    @JvmStatic
    fun get_digits_alphabets(): Regex =
        "[^a-zA-Z0-9]+".str2regex()

    //同时包含数字和字母
    @JvmStatic
    fun get_digits_alphabets2(): Regex =
        "^(?![0-9]+\$)(?![a-zA-Z]+\$)[0-9A-Za-z]{2,}\$".str2regex()

    @JvmStatic
    fun get_alphabets(): Regex =
        "[^(A-Za-z)]".str2regex()

    @JvmStatic
    fun get_digits_alphabets_chinese(): Regex =
        "[^(a-zA-Z0-9\\u4e00-\\u9fa5)]".str2regex()

    @JvmStatic
    fun get_chinese(): Regex =
        "[^(\\u4e00-\\u9fa5)]".str2regex()

    @JvmStatic
    fun get_v(): Regex =
        "[vV]".str2regex()

    @JvmStatic
    fun get_end_(): Regex =
        "-+$".str2regex()

    //////////////////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun get_lineBreak(): Regex =
        "\\n".str2regex()

    @JvmStatic
    fun get_doubleQuote(): Regex =
        "\"".str2regex()

    @JvmStatic
    fun get_underline(): Regex =
        "_".str2regex()

    @JvmStatic
    fun get_blanks(): Regex =
        "\\s+".str2regex()

    @JvmStatic
    fun get_blank(): Regex =
        " ".str2regex()

    @JvmStatic
    fun get_strikethrough(): Regex =
        "-".str2regex()

    @JvmStatic
    fun get_colon(): Regex =
        ":".str2regex()

    @JvmStatic
    fun get_brackets_content(): Regex =
        "\\(.*\\)".str2regex()

    //////////////////////////////////////////////////////////////////
    // net
    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun get_port(): Regex =
        "^[-+]?[\\d]{1,6}$".str2regex()

    @JvmStatic
    fun get_domain(): Regex =
        "^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$".str2regex()

    @JvmStatic
    fun get_ip(): Regex =
        "((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)".str2regex()

    @JvmStatic
    fun get_url(): Regex =
        ("^(https?|ftp|ws)://" + // 协议（http 或 https，可选）//"^(https?|ftp|ws)://" // 支持 http、https、ftp、ws
                "([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})" + // 域名（支持子域名）
                "(:[0-9]{1,5})?" + // 端口（可选）
                "(/[\\w\\-./?%&=]*)?" + // 路径和查询参数（可选）
                "(#[\\w\\-]*)?$" // 片段（可选）
                ).str2regex()

    //////////////////////////////////////////////////////////////////
    // id card
    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun get_idCardPp(): Regex =
        "^([a-zA-z]|[0-9]){5,17}\$".str2regex()

    @JvmStatic
    fun get_idCardTw(): Regex =
        "^\\d{8}|^[a-zA-Z0-9]{10}|^\\d{18}\$".str2regex()

    @JvmStatic
    fun get_idCardHk(): Regex =
        "^([A-Z]\\d{6,10}(\\(\\w{1}\\))?)\$".str2regex()

    @JvmStatic
    fun get_idCard(): Regex =
        "^(([1][1-5])|([2][1-3])|([3][1-7])|([4][1-6])|([5][0-4])|([6][1-5])|([7][1])|([8][1-2]))\\d{4}(([1][9]\\d{2})|([2]\\d{3}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))\\d{3}[0-9xX]$".str2regex()
}