package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits2
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits_alphabets
import com.mozhimen.kotlin.utilk.kotlin.text.replace_2alphabets
import com.mozhimen.kotlin.utilk.kotlin.text.replace_2chinese
import com.mozhimen.kotlin.utilk.kotlin.text.replace_2digits
import com.mozhimen.kotlin.utilk.kotlin.text.replace_2digits_alphabets_chinese
import org.junit.Test


/**
 * @ClassName TestUtilKVerifyUrl
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/9 18:02
 * @Version 1.0
 */
class TestUtilKFilter {
    @Test
    fun verify() {
//        "192.168.33.102".checkIP().printlog()
//        "192.168".checkIP().printlog()
//        "1.1.1.1".checkIP().printlog()
//        "8080".checkPort().printlog()
//        "80".checkPort().printlog()

        "0123456789".matches_digits().printlog()
        "12322r".matches_digits().printlog()
        "ree".matches_digits().printlog()

        "0123456789".matches_digits2().printlog()
        "12322r".matches_digits2().printlog()
        "ree".matches_digits2().printlog()

        "ree123".matches_digits_alphabets().printlog()
        "123456".matches_digits_alphabets().printlog()
        "123".matches_digits_alphabets().printlog()
        "ree".matches_digits_alphabets().printlog()
    }

    @Test
    fun filter() {
        "123我是谁AAA&&".replace_2digits().printlog()
        "123我是谁AAA&&".replace_2alphabets().printlog()
        "123我是谁AAA&&".replace_2chinese().printlog()
        "123我是谁AAA&&".replace_2digits_alphabets_chinese().printlog()
    }
}