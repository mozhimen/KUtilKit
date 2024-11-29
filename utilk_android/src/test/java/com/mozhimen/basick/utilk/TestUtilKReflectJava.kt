package com.mozhimen.basick.utilk

import com.mozhimen.kotlin.utilk.java.lang.UtilKField
import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import org.junit.Test

/**
 * @ClassName TestUtilKReflect
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/6/29 0:19
 * @Version 1.0
 */
class TestUtilKReflectJava {
    @Test
    fun test() {
        val reflectTest = ReflectTest()
        UtilKField.getInt(reflectTest,"field").printlog()
    }

    class ReflectTest {
        val field = 1
    }
}