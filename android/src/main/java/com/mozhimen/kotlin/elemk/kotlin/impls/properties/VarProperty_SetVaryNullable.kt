package com.mozhimen.kotlin.elemk.kotlin.impls.properties

import com.mozhimen.kotlin.elemk.commons.IAA_BListener

/**
 * true 则赋值, 否则不赋值
 */
open class VarProperty_SetVaryNullable<T>(default: T, onSetField: IAA_BListener<T, Boolean>) :
    VarProperty_Set<T>(default, true, false, onSetField)