package com.mozhimen.kotlin.utilk.android.widget

import android.text.Editable
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import com.mozhimen.kotlin.elemk.android.view.commons.ITextWatcher
import com.mozhimen.kotlin.elemk.android.view.cons.CEditorInfo
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.view.UtilKMotionEventWrapper
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
 * @ClassName UtilKEditTextWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/20
 * @Version 1.0
 */
fun EditText.applyOnEditorActionListener_ofSearch(block: I_Listener) {
    UtilKEditTextWrapper.applyOnEditorActionListener_ofSearch(this, block)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.applyDebounceTextChangeListener(
    scope: CoroutineScope,
    searchBlock: suspend CoroutineScope.(String) -> List<String>,
    resBlock: IAB_Listener<EditText, List<String>>,
    thresholdMillis: Long = 500,
) {
    UtilKEditTextWrapper.applyDebounceTextChangeListener(this, scope, searchBlock, resBlock, thresholdMillis)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.applySuspendDebounceTextChangeListener(
    scope: CoroutineScope,
    searchBlock: suspend CoroutineScope.(String) -> List<String>,
    resBlock: suspend CoroutineScope.(EditText, List<String>) -> Unit,
    thresholdMillis: Long = 500,
) {
    UtilKEditTextWrapper.applySuspendDebounceTextChangeListener(this, scope, searchBlock, resBlock, thresholdMillis)
}

fun EditText.addTextChangedObserver(onTextChanged: IA_Listener<String>/*(newText: String) -> Unit*/) {
    UtilKEditTextWrapper.addTextChangedObserver(this, onTextChanged)
}

//////////////////////////////////////////////////////////////////////////////////////////////

object UtilKEditTextWrapper {

    @JvmStatic
    fun applyOnEditorActionListener_ofSearch(editText: EditText, block: I_Listener) {
        editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == CEditorInfo.IME_ACTION_SEARCH) {
                block.invoke()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    @JvmStatic
    fun applyDebounceTextChangeListener(
        editText: EditText,
        scope: CoroutineScope,
        searchBlock: suspend CoroutineScope.(String) -> List<String>,
        resBlock: IAB_Listener<EditText, List<String>>,
        thresholdMillis: Long = 500,
    ) {
        editText.getEditTextChangeFlow().filter { it.isNotEmpty() }.debounce(thresholdMillis).flatMapLatest { getStringFlow(it.toString(), scope, searchBlock) }.flowOn(Dispatchers.IO).onEach {
            resBlock(editText, it)
        }.launchIn(scope)
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    @JvmStatic
    fun applySuspendDebounceTextChangeListener(
        editText: EditText,
        scope: CoroutineScope,
        searchBlock: suspend CoroutineScope.(String) -> List<String>,
        resBlock: suspend CoroutineScope.(EditText, List<String>) -> Unit,
        thresholdMillis: Long = 500,
    ) {
        editText.getEditTextChangeFlow().filter { it.isNotEmpty() }.debounce(thresholdMillis).flatMapLatest { getStringFlow(it.toString(), scope, searchBlock) }.flowOn(Dispatchers.IO).onEach {
            scope.resBlock(editText, it)
        }.launchIn(scope)
    }

    //变化观察
    @JvmStatic
    fun addTextChangedObserver(editText: EditText, onTextChanged: IA_Listener<String>/*(newTextStr: String) -> Unit*/) {
        editText.addTextChangedListener(object : ITextWatcher {
            override fun afterTextChanged(s: Editable?) {
                onTextChanged(s.toString())
            }
        })
    }
}