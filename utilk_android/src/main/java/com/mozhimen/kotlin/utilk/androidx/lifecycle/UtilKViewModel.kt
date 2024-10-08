package com.mozhimen.kotlin.utilk.androidx.lifecycle

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mozhimen.kotlin.elemk.kotlin.cons.CSuppress
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKType

/**
 * @ClassName UtilKViewModel
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/23 0:32
 * @Version 1.0
 */
object UtilKViewModel: IUtilK {
    @JvmStatic
    @Suppress(CSuppress.UNCHECKED_CAST)
    fun <VM : ViewModel> get(owner: ViewModelStoreOwner, factory: ViewModelProvider.Factory? = null/*, index: Int = 1*/): VM =
        (UtilKType.getClass_ofParent(owner::class.java, ViewModel::class.java)?.let { clazzVM ->
            factory?.let { fac ->
                ViewModelProvider(owner, fac)[clazzVM as Class<VM>]
            } ?: run {
                ViewModelProvider(owner)[clazzVM as Class<VM>]
            }
        } ?: throw Exception("inflate vm fail!")).also { UtilKLogWrapper.d(TAG, "get: $it") }
}