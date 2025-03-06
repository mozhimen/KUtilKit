package com.mozhimen.kotlin.utilk.androidx.core

import androidx.core.graphics.Insets
import androidx.core.view.WindowInsetsCompat

/**
 * @ClassName UtilKWindowInsetsCompat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/26
 * @Version 1.0
 */
object UtilKWindowInsetsCompat {
    @JvmStatic
    fun getInsets(windowInsetsCompat: WindowInsetsCompat, @WindowInsetsCompat.Type.InsetsType typeMask: Int): Insets =
        windowInsetsCompat.getInsets(typeMask)
}