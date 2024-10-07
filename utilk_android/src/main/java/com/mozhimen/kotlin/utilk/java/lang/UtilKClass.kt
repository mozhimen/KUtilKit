package com.mozhimen.kotlin.utilk.java.lang

import java.lang.reflect.ParameterizedType

/**
 * @ClassName UtilKClass
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 18:28
 * @Version 1.0
 */
object UtilKClass {
    /**
     * create a new instance of [T] with [params]
     */
    @JvmStatic
    inline fun <reified T> newInstance(vararg params: Any): T =
        T::class.java
            .getDeclaredConstructor(*params.map { it::class.java }.toTypedArray())
            .also { it.isAccessible = true }
            .newInstance(*params)

    @JvmStatic
    fun isInstanceOf(obj: Any, genericClass: Class<*>): Boolean {
        val type = obj.javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val rawType = type.rawType
            return rawType == genericClass
        }
        return false
    }
}