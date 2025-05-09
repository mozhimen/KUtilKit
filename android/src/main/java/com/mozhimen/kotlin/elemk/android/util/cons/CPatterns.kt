package com.mozhimen.kotlin.elemk.android.util.cons

import android.util.Patterns
import java.util.regex.Pattern

/**
 * @ClassName CPatterns
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/6
 * @Version 1.0
 */
object CPatterns {
    val EMAIL_ADDRESS: Pattern
        get() = Patterns.EMAIL_ADDRESS
}