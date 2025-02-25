package com.mozhimen.kotlin.elemk.android.text.cons

import android.text.InputType

/**
 * @ClassName CInputType
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/2/24 22:00
 * @Version 1.0
 */
object CInputType {
    const val TYPE_CLASS_TEXT = InputType.TYPE_CLASS_TEXT//文本类型
    const val TYPE_CLASS_NUMBER = InputType.TYPE_CLASS_NUMBER//数字类型
    const val TYPE_CLASS_PHONE = InputType.TYPE_CLASS_PHONE//电话号码类型
    const val TYPE_TEXT_FLAG_CAP_WORDS = InputType.TYPE_TEXT_FLAG_CAP_WORDS//每个单词首字母大写
    const val TYPE_TEXT_FLAG_CAP_SENTENCES = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES//每句话首字母大写
    const val TYPE_TEXT_FLAG_CAP_CHARACTERS = InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS//所有字母大写
    const val TYPE_TEXT_FLAG_MULTI_LINE = InputType.TYPE_TEXT_FLAG_MULTI_LINE//多行文本
    const val TYPE_TEXT_FLAG_NO_SUGGESTIONS = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS//TYPE_TEXT_FLAG_NO_SUGGESTIONS
}