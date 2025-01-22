package com.mozhimen.kotlin.utilk.android.content

import android.content.res.TypedArray
import androidx.annotation.StyleableRes

/**
 * @ClassName UtilKTypedArray
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/6
 * @Version 1.0
 */
object UtilKTypedArray {
    //// 获取索引为 0 处的整型属性值，如果不存在或无效，返回默认值 0
    @JvmStatic
    fun getInt(typedArray: TypedArray, @StyleableRes index: Int, defValue: Int): Int {
        return typedArray.getInt(index, defValue)
    }

    //// 获取索引为 0 处的整型属性值，如果不存在或无效，返回 null
    @JvmStatic
    fun getInteger(typedArray: TypedArray, @StyleableRes index: Int, defValue: Int): Int {
        return typedArray.getInteger(index, defValue)
    }
}