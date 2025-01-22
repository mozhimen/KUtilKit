package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits2
import org.junit.Test

/**
 * @ClassName TestUtilKRegexMatch
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/28
 * @Version 1.0
 */
class TestUtilKRegexMatch {
    @Test
    fun test() {
        "123".matches_digits().printlog()
        "123A".matches_digits().printlog()
        "123".matches_digits2().printlog()
        "123A".matches_digits2().printlog()
    }
}