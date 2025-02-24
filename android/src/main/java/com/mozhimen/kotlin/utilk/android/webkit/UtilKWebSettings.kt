package com.mozhimen.kotlin.utilk.android.webkit

import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @ClassName UtilKWebSettings
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/24
 * @Version 1.0
 */
object UtilKWebSettings {
    @JvmStatic
    fun get(webView: WebView): WebSettings =
        webView.settings
}