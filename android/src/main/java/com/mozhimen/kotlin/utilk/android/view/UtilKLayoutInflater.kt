package com.mozhimen.kotlin.utilk.android.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKLayoutInflater
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/25
 * @Version 1.0
 */
object UtilKLayoutInflater {
    @JvmStatic
    fun get(context: Context): LayoutInflater =
        UtilKContextGet.getSystemService_LAYOUT_INFLATER(context)

    @JvmStatic
    fun from_inflate(viewGroup: ViewGroup, @LayoutRes intResLayout: Int): View =
        LayoutInflater.from(viewGroup.context).inflate(intResLayout, viewGroup, false)
}