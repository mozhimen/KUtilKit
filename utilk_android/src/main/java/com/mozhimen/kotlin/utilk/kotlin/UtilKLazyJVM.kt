package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.I_AListener

/**
 * @ClassName UtilKLazyJVM
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/14
 * @Version 1.0
 */
object UtilKLazyJVM {
    @JvmStatic
    fun <T> lazy_ofNone(initializer: I_AListener<T>): Lazy<T> =
        lazy(UtilKLazyThreadSafetyMode.getNONE(), initializer)

    @JvmStatic
    fun <T> lazy_ofPublication(initializer: I_AListener<T>): Lazy<T> =
        lazy(UtilKLazyThreadSafetyMode.getPUBLICATION(), initializer)

    @JvmStatic
    fun <T> lazy_ofSynchronized(initializer: I_AListener<T>): Lazy<T> =
        lazy(UtilKLazyThreadSafetyMode.getSYNCHRONIZED(), initializer)
}