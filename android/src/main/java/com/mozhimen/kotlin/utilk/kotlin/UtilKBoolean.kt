package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.I_Listener
import java.util.Locale


/**
 * @ClassName UtilKBoolean
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/17 10:36
 * @Version 1.0
 */
fun Boolean.whether(onTrue: I_Listener) {
    UtilKBoolean.whether(this, onTrue)
}

fun Boolean.whether(onTrue: I_Listener, onFalse: I_Listener) {
    UtilKBoolean.whether(this, onTrue, onFalse)
}

fun Boolean.boolean2str(locale: Locale = Locale.CHINA): String =
    UtilKBoolean.boolean2str(this, locale)

//////////////////////////////////////////////////////////////////

object UtilKBoolean {

    @JvmStatic
    fun allTrue(vararg boolean: Boolean):Boolean =
        boolean.all { it }

    @JvmStatic
    fun whether(boolean: Boolean, onTrue: I_Listener) {
        if (boolean)
            onTrue.invoke()
    }

    @JvmStatic
    fun whether(boolean: Boolean, onTrue: I_Listener, onFalse: I_Listener) {
        if (boolean)
            onTrue.invoke()
        else
            onFalse.invoke()
    }

    @JvmStatic
    fun boolean2str(bool: Boolean, locale: Locale = Locale.CHINA) =
        if (locale == Locale.CHINA)
            if (bool) "是" else "否"
        else
            (if (bool) "true" else "false")
}