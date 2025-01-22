package com.mozhimen.kotlin.elemk.kotlin.properties

import com.mozhimen.kotlin.elemk.commons.IAA_BListener

/**
 * true 则赋值, 否则不赋值
 */
open class VarProperty_SetVaryNonnull<T>(default: T, onSetField: IAA_BListener<T, Boolean>) :
    VarProperty_Set<T>(default, true, true, onSetField)