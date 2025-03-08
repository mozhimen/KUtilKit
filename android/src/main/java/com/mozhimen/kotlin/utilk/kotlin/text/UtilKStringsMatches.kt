package com.mozhimen.kotlin.utilk.kotlin.text

/**
 * @ClassName UtilKStringsMatch
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/28
 * @Version 1.0
 */
fun String.matches_digits(): Boolean =
    UtilKStringsMatches.matches_digits(this)

fun String.matches_digits2(): Boolean =
    UtilKStringsMatches.matches_digits2(this)

fun String.matches_digits_alphabets(): Boolean =
    UtilKStringsMatches.matches_digits_alphabets(this)

//////////////////////////////////////////////////////////////////

fun String.matches_idCard(): Boolean =
    UtilKStringsMatches.matches_idCard(this)

fun String.matches_idCardHk(): Boolean =
    UtilKStringsMatches.matches_idCardHk(this)

fun String.matches_idCardTw(): Boolean =
    UtilKStringsMatches.matches_idCardTw(this)

fun String.matches_idCardPp(): Boolean =
    UtilKStringsMatches.matches_idCardPp(this)

//////////////////////////////////////////////////////////////////

fun String.matches_ip(): Boolean =
    UtilKStringsMatches.matches_ip(this)

fun String.matches_domain(): Boolean =
    UtilKStringsMatches.matches_domain(this)

fun String.matches_port(): Boolean =
    UtilKStringsMatches.matches_port(this)

fun String.matches_url(): Boolean =
    UtilKStringsMatches.matches_url(this)

//////////////////////////////////////////////////////////////////

object UtilKStringsMatches {
    //region number
    //是否是数字
    @JvmStatic
    fun matches_digits(str: String): Boolean =
        str.matches(UtilKRegexGet.get_digits())

    //是否是数字
    @JvmStatic
    fun matches_digits2(str: String) =
        str.matches(UtilKRegexGet.get_digits2())

    //同时包含数字和字母
    @JvmStatic
    fun matches_digits_alphabets(str: String): Boolean =
        str.matches(UtilKRegexGet.get_digits_alphabets2())
    //endregion

    //////////////////////////////////////////////////////////////////

    //region # card
    /**
     * 身份证校验
     */
    @JvmStatic
    fun matches_idCard(strId: String): Boolean =
        strId.matches(UtilKRegexGet.get_idCard())

    /**
     * 港澳居民来往内地通行证校验
     * 规则： H/M + 10位或6位数字
     * 样本： H1234567890
     */
    @JvmStatic
    fun matches_idCardHk(strId: String): Boolean =
        strId.matches(UtilKRegexGet.get_idCardHk())

    /**
     * 台湾居民来往大陆通行证校验
     * 规则： 新版8位或18位数字， 旧版10位数字 + 英文字母
     * 样本： 12345678 或 1234567890B
     */
    @JvmStatic
    fun matches_idCardTw(strId: String): Boolean =
        strId.matches(UtilKRegexGet.get_idCardTw())

    /**
     * 护照校验
     * 规则： 14/15开头 + 7位数字, G + 8位数字, P + 7位数字, S/D + 7或8位数字,等
     * 样本： 141234567, G12345678, P1234567
     */
    @JvmStatic
    fun matches_idCardPp(strId: String): Boolean =
        strId.matches(UtilKRegexGet.get_idCardPp())
    //endregion

    //////////////////////////////////////////////////////////////////

    //ip是否合法
    @JvmStatic
    fun matches_ip(strIp: String): Boolean =
        strIp.matches(UtilKRegexGet.get_ip())

    //域名是否合法
    @JvmStatic
    fun matches_domain(strDomain: String): Boolean =
        strDomain.matches(UtilKRegexGet.get_domain())

    //端口是否合法
    @JvmStatic
    fun matches_port(strPort: String): Boolean =
        strPort.matches(UtilKRegexGet.get_port())

    @JvmStatic
    fun matches_url(strUrl: String): Boolean =
        strUrl.matches(UtilKRegexGet.get_url())
}