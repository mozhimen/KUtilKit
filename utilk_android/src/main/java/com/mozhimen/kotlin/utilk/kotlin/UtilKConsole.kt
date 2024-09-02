package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKConsole
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/8/31 11:19
 * @Version 1.0
 */
fun <T> T.print() {
    UtilKConsole.print(this)
}

fun <T> T.println() {
    UtilKConsole.println(this)
}

fun <T> T.printlog() {
    UtilKConsole.printlog(this)
}

fun <T> T.printlog(tag: String) {
    UtilKConsole.printlog(tag, this)
}

fun String.printlog_ofEach() {
    UtilKConsole.printlog_ofEach(this)
}

///////////////////////////////////////////////////////////////////////////////

object UtilKConsole : IUtilK {
    @JvmStatic
    fun <T> print(msg: T) {
        kotlin.io.print(msg)
    }

    @JvmStatic
    fun <T> println(msg: T) {
        kotlin.io.println(msg)
    }

    @JvmStatic
    fun <T> printlog(msg: T) {
        printlog(TAG, msg)
    }

    @JvmStatic
    fun <T> printlog(tag: String, msg: T) {
        println("$tag: $msg")
    }

    @JvmStatic
    fun <T> printlog_ofEach(vararg msg: T) {
        for (char in msg)
            printlog(TAG, char)
    }
}