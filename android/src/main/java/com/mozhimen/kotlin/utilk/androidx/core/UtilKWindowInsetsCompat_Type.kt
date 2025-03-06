package com.mozhimen.kotlin.utilk.androidx.core

import androidx.core.view.WindowInsetsCompat

/**
 * @ClassName UtilKWindowInsetsCompatType
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/26
 * @Version 1.0
 */
object UtilKWindowInsetsCompat_Type {
    @JvmStatic
    fun get_systemBars(): Int =
        WindowInsetsCompat.Type.systemBars()

    @JvmStatic
    fun get_navigationBars(): Int =
        WindowInsetsCompat.Type.navigationBars()

    @JvmStatic
    fun get_statusBars(): Int =
        WindowInsetsCompat.Type.statusBars()
}