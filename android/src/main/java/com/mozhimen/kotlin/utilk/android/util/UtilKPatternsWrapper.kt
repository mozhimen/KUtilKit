package com.mozhimen.kotlin.utilk.android.util

import android.util.Patterns
import com.mozhimen.kotlin.elemk.android.util.cons.CPatterns
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKStringsMatches

/**
 * @ClassName UtilKPatterns
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/6
 * @Version 1.0
 */
fun String.matches_EMAIL_ADDRESS(): Boolean =
    UtilKPatternsWrapper.matches_EMAIL_ADDRESS(this)

/////////////////////////////////////////////////////////////////////////

object UtilKPatternsWrapper {
    @JvmStatic
    fun matches_EMAIL_ADDRESS(strEmail: String): Boolean =
        CPatterns.EMAIL_ADDRESS.matcher(strEmail).matches()
}