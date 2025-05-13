package com.mozhimen.kotlin.utilk.android.text

import android.text.Spanned

/**
 * @ClassName UtilKSpanned
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/13
 * @Version 1.0
 */
object UtilKSpannedWrapper {
    /**
     * Html.fromHtml sometimes adds extra space at the bottom.
     * This methods removes this space again.
     * See https://github.com/SufficientlySecure/html-textview/issues/19
     */
    fun removeLastBottomPadding(spanned: Spanned): Spanned {
        var text = spanned
        while (text.isNotEmpty() && text[text.length - 1] == '\n') {
            text = text.subSequence(0, text.length - 1) as Spanned
        }
        return text
    }
}