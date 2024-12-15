package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import com.mozhimen.kotlin.utilk.java.lang.UtilKType
import org.junit.Test

/**
 * @ClassName TestUtilKGeneric
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/22 22:48
 * @Version 1.0
 */
class TestUtilKGeneric : Person<Knife>() {
    @Test
    fun getClazzGenericType() {
        UtilKType.get<TestUtilKGeneric>()?.printlog()
        UtilKType.get_ofParent<TestUtilKGeneric>()?.printlog()
        UtilKType.getClass_ofParent<TestUtilKGeneric>()?.printlog()
    }
}

open class Tool

class Knife : Tool()

open class Person<T : Tool>