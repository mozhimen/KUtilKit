package com.mozhimen.kotlin.utilk

import android.view.Display
import com.mozhimen.kotlin.utilk.kotlin.getStrPackageName
import com.mozhimen.kotlin.utilk.kotlin.strPackage2clazz
import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import org.junit.Test

/**
 * @ClassName TestUtilKClazz
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/6/29 22:15
 * @Version 1.0
 */
class TestUtilKClazz {
    @Test
    fun test() {
        "android.view.Display".strPackage2clazz().name.printlog()
        Display::class.java.getStrPackageName().strPackage2clazz().getStrPackageName().printlog()
    }
}