package com.mozhimen.utilk.android.test.elemk.androidx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mozhimen.kotlin.elemk.androidx.lifecycle.bases.BaseViewModel
import com.mozhimen.kotlin.elemk.androidx.lifecycle.sticky.MutableLiveDataSticky
import com.mozhimen.utilk.android.test.elemk.androidx.Starter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @ClassName ElemkLifecycleViewModel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/7/25
 * @Version 1.0
 */
class ElemkLifecycleViewModel : BaseViewModel() {
    val flowState: MutableStateFlow<Int> = MutableStateFlow(Starter.getNum())
    val liveDataMutable: MutableLiveData<Int> = MutableLiveData(Starter.getNum())
    val liveDataSticky: MutableLiveDataSticky<Int> = MutableLiveDataSticky(Starter.getNum())

    fun setNum(num: Int) {
        viewModelScope.launch {
            flowState.emit(num)
            liveDataMutable.postValue(num)
            liveDataSticky.postValue(num)
        }
    }
}