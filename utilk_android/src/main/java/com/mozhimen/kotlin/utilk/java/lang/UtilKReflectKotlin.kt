package com.mozhimen.kotlin.utilk.java.lang

/**
 * @ClassName UtilKReflectKotlin
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
object UtilKReflectKotlin {
    /**
     * create a new instance of [T] with [params]
     */
    @JvmStatic
    inline fun <reified T> newInstance(vararg params: Any): T =
        T::class.java.getDeclaredConstructor(*params.map { it::class.java }.toTypedArray()).also { it.isAccessible = true }.newInstance(*params)
}