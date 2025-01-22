package com.mozhimen.kotlin.elemk.android.text.cons

import android.text.Spanned

/**
 * @ClassName CSpanned
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/1/21
 * @Version 1.0
 */
object CSpanned {
    const val SPAN_EXCLUSIVE_EXCLUSIVE = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE //前后都不包括
    const val SPAN_INCLUSIVE_EXCLUSIVE = Spanned.SPAN_INCLUSIVE_EXCLUSIVE //前包括后不包括
    const val SPAN_EXCLUSIVE_INCLUSIVE = Spanned.SPAN_EXCLUSIVE_INCLUSIVE //前不包括后包括
    const val SPAN_INCLUSIVE_INCLUSIVE = Spanned.SPAN_INCLUSIVE_INCLUSIVE //前后都包括
}