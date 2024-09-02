package com.mozhimen.kotlin.utilk.bases

import com.mozhimen.kotlin.utilk.android.app.UtilKApplicationWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone


/**
 * @ClassName BaseUtilK
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 10:54
 * @Version 1.0
 */
open class BaseUtilK : IUtilK {
    protected val _context by lazy_ofNone { UtilKApplicationWrapper.instance.applicationContext }
}