package com.mozhimen.kotlin.utilk.androidx.core

import androidx.core.graphics.Insets
import androidx.core.view.WindowInsetsCompat

/**
 * @ClassName UtilKWindowInsetsCompatWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/4
 * @Version 1.0
 */
object UtilKWindowInsetsCompatWrapper {
    @JvmStatic
    fun getInsets_systemBars(windowInsetsCompat: WindowInsetsCompat): Insets =
        UtilKWindowInsetsCompat.getInsets(windowInsetsCompat, UtilKWindowInsetsCompat_Type.get_systemBars())
}