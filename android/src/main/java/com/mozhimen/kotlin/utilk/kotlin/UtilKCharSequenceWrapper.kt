package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.IA_AListener
import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_AListener
import com.mozhimen.kotlin.elemk.commons.I_Listener

/**
 * @ClassName UtilKCharSequence
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/2 15:39
 * @Version 1.0
 */
fun CharSequence.isEquals(chars: CharSequence): Boolean =
    UtilKCharSequenceWrapper.isEquals(this, chars)

//////////////////////////////////////////////////////////////////////////////

fun <C : CharSequence> C?.ifNotNullOrEmptyOr(onIf: IA_Listener<C>) {
    UtilKCharSequenceWrapper.ifNotNullOrEmptyOr(this, onIf, null)
}

fun <C : CharSequence> C?.ifNotNullOrEmptyOr(onIf: IA_Listener<C>, onElse: I_Listener?) {
    UtilKCharSequenceWrapper.ifNotNullOrEmptyOr(this, onIf, onElse)
}

fun <C : CharSequence, D> C?.ifNotNullOrEmptyOrWithResult(onIf: IA_BListener<C, D>): D? =
    UtilKCharSequenceWrapper.ifNotNullOrEmptyOrWithResult(this, onIf, null)

fun <C : CharSequence, D> C?.ifNotNullOrEmptyOrWithResult(onIf: IA_BListener<C, D>, onElse: I_AListener<D>?): D? =
    UtilKCharSequenceWrapper.ifNotNullOrEmptyOrWithResult(this, onIf, onElse)

fun <C : CharSequence> C?.ifNullOrEmpty(default: C): C =
    UtilKCharSequenceWrapper.ifNullOrEmpty(this, default)

fun <C : CharSequence> C?.ifNullOrEmpty(onDefault: I_AListener<C>): C =
    UtilKCharSequenceWrapper.ifNullOrEmpty(this, onDefault)

//////////////////////////////////////////////////////////////////////////////

object UtilKCharSequenceWrapper {
    @JvmStatic
    fun <C : CharSequence> getNotNullOrEmpty(vararg chars: C?): C? {
        if (chars.isEmpty())
            return null
        chars.forEach { char ->
            if (!char.isNullOrEmpty()) {
                return char
            }
        }
        return null
    }

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isEquals(chars1: CharSequence, char2: CharSequence): Boolean {
        if (chars1 === char2) return true
        var length: Int
        return if (chars1.length.also { length = it } == char2.length) {
            if (chars1 is String && char2 is String) {
                chars1 == char2
            } else {
                for (i in 0 until length) {
                    if (chars1[i] != char2[i]) return false
                }
                true
            }
        } else false
    }

    //是否为空
    @JvmStatic
    fun isNullOrEmpty(chars: CharSequence?): Boolean =
        chars.isNullOrEmpty()

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun <C : CharSequence> ifNotNullOrEmptyOr(chars: C?, onIf: IA_Listener<C>, onElse: I_Listener? = null) {
        if (!chars.isNullOrEmpty())
            onIf.invoke(chars)
        else
            onElse?.invoke()
    }

    @JvmStatic
    fun <C : CharSequence, D> ifNotNullOrEmptyOrWithResult(chars: C?, onIf: IA_BListener<C, D>, onElse: I_AListener<D>? = null): D? =
        if (!chars.isNullOrEmpty())
            onIf.invoke(chars)
        else
            onElse?.invoke()

    @JvmStatic
    fun <C : CharSequence> ifNullOrEmpty(chars: C?, default: C): C =
        if (chars.isNullOrEmpty())
            default
        else
            chars

    @JvmStatic
    fun <C : CharSequence> ifNullOrEmpty(chars: C?, onNullOrEmpty: I_AListener<C>): C =
        if (chars.isNullOrEmpty())
            onNullOrEmpty()
        else
            chars
}

