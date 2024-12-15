package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.utilk.kotlin.UtilKAny
import com.mozhimen.kotlin.utilk.kotlin.isObjPrimitive
import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import org.junit.Assert
import org.junit.Test

/**
 * @ClassName UtilKDataType
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/8/30 23:57
 * @Version 1.0
 */
class TestUtilKAny {
    @Test
    fun isObjTypeMatch() {
        Assert.assertTrue(UtilKAny.isObjTypeMatch("123", String::class.java))
    }

    @Test
    fun getTypeName() {
        UtilKAny.getObjTypeName(0x000000).printlog()
    }

    @Test
    fun isObjPrimitive() {
        2.isObjPrimitive().printlog()
    }
}