package com.mozhimen.kotlin.utilk.kotlin.text

import androidx.annotation.MainThread
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.getSplitFirstIndexToStart

/**
 * @ClassName UtilKStringsWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/28
 * @Version 1.0
 */
fun String.checkStrUrl(): Boolean =
    UtilKStringsWrapper.checkStrUrl(this)

///////////////////////////////////////////////////////////////////////////////////

object UtilKStringsWrapper :IUtilK{

    /**
     * 判断url是否合法
     */
    @JvmStatic
    @MainThread
    fun checkStrUrl(url: String): Boolean {
        UtilKLogWrapper.d(TAG, "isUrlValid: url $url")
        if (url.isEmpty()) {
            "输入为空".showToast()
            return false
        }
        if (!url.startsWith("http://") && !url.startsWith("https://") && !url.startsWith("tcp://")) {
            "请输入正确的协议头".showToast()
            return false
        }
        val splitArray = url.split(":")
        if (splitArray.size < 2) {
            "请输入正确的端口格式".showToast()
            return false
        }
        //first:http
        if (splitArray.getOrNull(0) == null) {
            "请输入正确的端口格式(http/https/tcp)接IP或域名".showToast()
            return false
        }
        val first = splitArray[0]
        if (first != "http" && first != "https" && first != "tcp") {
            "请输入正确的协议(http/https/tcp)".showToast()
            return false
        }
        //second:ip
        if (splitArray.getOrNull(1) == null) {
            "请输入正确的IP或域名".showToast()
            return false
        }
        var second = splitArray[1].replace("//", "")
        if (second.contains("/")) {
            second = second.getSplitFirstIndexToStart("/")
        }
        if (!second.matches_ip() && !second.matches_domain()) {
            "请输入正确的IP或域名".showToast()
            return false
        }
        if (splitArray.getOrNull(2) != null) {
            var third = splitArray[2]
            if (third.contains("/")) {
                third = third.getSplitFirstIndexToStart("/")
            }
            if (!third.matches_port()) {
                "请输入正确的端口".showToast()
                return false
            }
        }
        return true
    }
}