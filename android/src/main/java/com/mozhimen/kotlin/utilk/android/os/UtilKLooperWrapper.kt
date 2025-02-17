package com.mozhimen.kotlin.utilk.android.os

import android.os.Looper
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.os.UtilKLooper.get_main
import com.mozhimen.kotlin.utilk.android.os.UtilKLooper.get_my

/**
 * @ClassName UtilKLooperWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/17
 * @Version 1.0
 */
object UtilKLooperWrapper {
    //是否是MainLooper
    @JvmStatic
    fun isLooperMain(): Boolean =
        get_my() == get_main()

    /**
     * 循环
     */
    @JvmStatic
    fun prepareAndLoopLooper(block: I_Listener) {
        var myLooper = get_my()
        if (myLooper == null) {
            Looper.prepare()
            myLooper = get_my()
        }
        block.invoke()
        if (myLooper != null) {
            Looper.loop()
            myLooper.quit()
        }
    }
}