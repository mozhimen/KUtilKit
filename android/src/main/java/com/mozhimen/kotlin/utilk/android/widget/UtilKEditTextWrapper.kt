package com.mozhimen.kotlin.utilk.android.widget

import android.text.Editable
import android.widget.EditText
import com.mozhimen.kotlin.elemk.android.view.commons.ITextWatcher
import com.mozhimen.kotlin.elemk.android.view.cons.CEditorInfo
import com.mozhimen.kotlin.elemk.commons.IABCD_Listener
import com.mozhimen.kotlin.elemk.commons.IABC_Listener
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.ISuspendExtAB_Listener
import com.mozhimen.kotlin.elemk.commons.ISuspendExtA_BListener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.kotlin.UtilKStringFormat.str2strsFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
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
fun EditText.getOnTextChangedFlow(): Flow<CharSequence> =
    UtilKEditTextWrapper.getOnTextChangedFlow(this)

//////////////////////////////////////////////////////////////////////////////////////////////

fun EditText.applyOnEditorActionListener_IME_ACTION_SEARCH(
    block: I_Listener,
) {
    UtilKEditTextWrapper.applyOnEditorActionListener_IME_ACTION_SEARCH(this, block)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.applyDebounceTextChangeListener(
    scope: CoroutineScope,
    searchBlock: ISuspendExtA_BListener<CoroutineScope, String, List<String>>,
    resBlock: IAB_Listener<EditText, List<String>>,
    thresholdMillis: Long = 500,
) {
    UtilKEditTextWrapper.applyDebounceTextChangeListener(this, scope, searchBlock, resBlock, thresholdMillis)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.applySuspendDebounceTextChangeListener(
    scope: CoroutineScope,
    searchBlock: ISuspendExtA_BListener<CoroutineScope, String, List<String>>,
    resBlock: ISuspendExtAB_Listener<CoroutineScope, EditText, List<String>>,
    thresholdMillis: Long = 500,
) {
    UtilKEditTextWrapper.applySuspendDebounceTextChangeListener(this, scope, searchBlock, resBlock, thresholdMillis)
}

fun EditText.addAfterTextChangedObserver(
    onTextChanged: IA_Listener<Editable?>,
) {
    UtilKEditTextWrapper.addAfterTextChangedObserver(this, onTextChanged)
}

fun EditText.addOnTextChangedObserver(
    onTextChanged: IABCD_Listener<CharSequence?, Int, Int, Int>,
) {
    UtilKEditTextWrapper.addOnTextChangedObserver(this, onTextChanged)
}

//////////////////////////////////////////////////////////////////////////////////////////////

object UtilKEditTextWrapper {

    @JvmStatic
    fun getOnTextChangedFlow(editText: EditText): Flow<CharSequence> =
        callbackFlow {
            val textWatcher = object : ITextWatcher {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {// 在文本变化后向流发射数据
                    s?.let { this@callbackFlow.trySend(it).isSuccess }
                }
            }
            editText.addTextChangedListener(textWatcher) // 设置输入框监听器
            awaitClose { editText.removeTextChangedListener(textWatcher) } // 阻塞以保证流一直运行
        }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyOnEditorActionListener_IME_ACTION_SEARCH(
        editText: EditText, block: I_Listener,
    ) {
        editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == CEditorInfo.IME_ACTION_SEARCH) {
                block.invoke()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @ExperimentalCoroutinesApi
    @FlowPreview
    @JvmStatic
    fun applyDebounceTextChangeListener(
        editText: EditText,
        scope: CoroutineScope,
        searchBlock: ISuspendExtA_BListener<CoroutineScope, String, List<String>>,
        resBlock: IAB_Listener<EditText, List<String>>,
        thresholdMillis: Long = 500,
    ) {
        getOnTextChangedFlow(editText).filter { it.isNotEmpty() }.debounce(thresholdMillis).flatMapLatest { str2strsFlow(it.toString(), scope, searchBlock) }.flowOn(Dispatchers.IO).onEach {
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
        getOnTextChangedFlow(editText).filter { it.isNotEmpty() }.debounce(thresholdMillis).flatMapLatest { str2strsFlow(it.toString(), scope, searchBlock) }.flowOn(Dispatchers.IO).onEach {
            scope.resBlock(editText, it)
        }.launchIn(scope)
    }

    //变化观察
    @JvmStatic
    fun addAfterTextChangedObserver(
        editText: EditText,
        onTextChanged: IA_Listener<Editable?>,
    ) {
        editText.addTextChangedListener(object : ITextWatcher {
            override fun afterTextChanged(s: Editable?) {
                onTextChanged(s)
            }
        })
    }

    //变化观察
    @JvmStatic
    fun addOnTextChangedObserver(
        editText: EditText,
        onTextChanged: IABCD_Listener<CharSequence?, Int, Int, Int>,
    ) {
        editText.addTextChangedListener(object : ITextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged(s, start, before, count)
            }
        })
    }
}