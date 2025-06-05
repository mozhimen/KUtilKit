package com.mozhimen.kotlin.utilk.android.test.elemk.androidx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mozhimen.kotlin.elemk.androidx.lifecycle.bases.BaseViewModel
import com.mozhimen.kotlin.elemk.androidx.lifecycle.impls.sticky.MutableLiveDataSticky
import com.mozhimen.kotlin.utilk.android.test.elemk.androidx.Starter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @ClassName ElemkLifecycleViewModel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/7/25
 * @Version 1.0
 */
class ElemkLifecycleViewModel2 : BaseViewModel() {
    val flowState: MutableStateFlow<Int> = MutableStateFlow(com.mozhimen.kotlin.utilk.android.test.elemk.androidx.Starter.getNum())
    val liveDataMutable: MutableLiveData<Int> = MutableLiveData(com.mozhimen.kotlin.utilk.android.test.elemk.androidx.Starter.getNum())
    val liveDataSticky: MutableLiveDataSticky<Int> = MutableLiveDataSticky(com.mozhimen.kotlin.utilk.android.test.elemk.androidx.Starter.getNum())

    fun setNum(num: Int) {
        viewModelScope.launch {
            flowState.emit(num)
            liveDataMutable.postValue(num)
            liveDataSticky.postValue(num)
        }
    }
}