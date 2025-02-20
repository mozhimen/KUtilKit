package com.mozhimen.kotlin.utilk.android.widget

import android.text.Editable
import android.widget.EditText
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.android.view.commons.ITextWatcher
import com.mozhimen.kotlin.elemk.android.view.cons.CEditorInfo
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.kotlin.obj2str_trim
import com.mozhimen.kotlin.utilk.kotlinx.coroutines.UtilKFlow.getStringFlow
import com.mozhimen.kotlin.utilk.kotlinx.coroutines.getEditTextChangeFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * @ClassName UtilKViewTextEdit
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 0:28
 * @Version 1.0
 */
val EditText.value: String get() = UtilKEditText.getValue(this)

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