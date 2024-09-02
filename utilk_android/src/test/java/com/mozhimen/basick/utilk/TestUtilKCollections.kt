package com.mozhimen.basick.utilk

import com.mozhimen.kotlin.utilk.kotlin.collections.getIndexFirst
import com.mozhimen.kotlin.utilk.kotlin.collections.joinT2list
import com.mozhimen.kotlin.utilk.kotlin.printlog
import org.junit.Test


/**
 * @ClassName TestUtilKCollections
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/2/7 17:14
 * @Version 1.0
 */
class TestUtilKCollections {

    @Test
    fun rotate() {
        var index = 0
        var current = 0f
        var temp = current
        while (index >= 8) {
            current += 45
            if (current == 360f) current = 0f
            temp += current + when {
                (temp - current) <= -180f -> 360f
                (temp - current) >= 180f -> -360f
                else -> 0f
            }
            temp.printlog()
            index++
        }
    }

    @Test
    fun min() {
        val list = mutableListOf<Float>()
        genList(list)
        list.printlog()
    }

    fun genList(list: MutableList<Float>) {
        list.add(0f)
        list.add(1f)
    }

    @Test
    fun joinElement() {

        val elements = listOf(
            User("赵", 11),
            User("钱", 11),
            User("孙", 12),
            User("赵", 13),
        )
        elements.joinT2list { it.name }.printlog()
        elements.joinT2list { it.age }.printlog()
    }

    @Test
    fun getIndexFirst() {

        val elements = listOf(
            User("赵", 11),
            User("钱", 11),
            User("孙", 12),
            User("赵", 13),
        )
        elements.getIndexFirst { it.name == "赵" }.printlog()
        elements.getIndexFirst { it.name == "孙" }.printlog()
        elements.getIndexFirst { it.age == 10 }.printlog()
    }

    data class User(
        val name: String,
        val age: Int
    )
}