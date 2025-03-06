package com.mozhimen.kotlin.utilk.android.widget

import android.text.Editable
import android.widget.EditText
import com.mozhimen.kotlin.utilk.kotlin.obj2str_trim

/**
 * @ClassName UtilKViewTextEdit
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 0:28
 * @Version 1.0
 */
fun EditText.getValue(): String =
    UtilKEditText.getValue(this)

//////////////////////////////////////////////////////////////////////////////////////////////

fun EditText.clearText() {
    UtilKEditText.clearText(this)
}

//////////////////////////////////////////////////////////////////////////////////////////////

object UtilKEditText {

    @JvmStatic
    fun getText(editText: EditText): Editable =
        editText.text

    //获取text
    @JvmStatic
    fun getValue(editText: EditText): String =
        getText(editText).obj2str_trim()

    //////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun clearText(editText: EditText) {
        editText.text.clear()
    }
}