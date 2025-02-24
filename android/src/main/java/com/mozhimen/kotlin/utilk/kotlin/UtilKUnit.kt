package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.elemk.commons.I_AListener
import com.mozhimen.kotlin.elemk.commons.I_Listener

/**
 * @ClassName UtilKUnit
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/2/21 14:59
 * @Version 1.0
 */
fun <T> I_AListener<T>.applyTry(default: T): T =
    UtilKUnit.applyTry(this, default)

fun I_Listener.applyTry() {
    UtilKUnit.applyTry(this)
}

//////////////////////////////////////////////////////////////////////////

object UtilKUnit {
    @JvmStatic
    fun <T> applyTry(block: I_AListener<T>, default: T): T =
        try {
            block.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
            default
        }

    @JvmStatic
    fun applyTry(block: I_Listener) {
        try {
            block.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}