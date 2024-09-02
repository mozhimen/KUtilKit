package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.io.PrintWriter
import java.io.StringWriter

/**
 * @ClassName UtilKThrowable
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/27 0:19
 * @Version 1.0
 */
fun Throwable.throwable2printWriter(printWriter: PrintWriter) {
    UtilKThrowableFormat.throwable2printWriter(this, printWriter)
}

fun Throwable.throwable2str(): String =
    UtilKThrowableFormat.throwable2str(this)

object UtilKThrowableFormat : IUtilK {
    @JvmStatic
    fun throwable2printWriter(e: Throwable, printWriter: PrintWriter) {
        printWriter.use {
            e.printStackTrace(it)
            var cause = e.cause
            while (cause != null) {
                cause.printStackTrace(it)
                cause = cause.cause
            }
        }
    }

    @JvmStatic
    fun throwable2str(throwable: Throwable): String {
        val stringWriter = StringWriter()
        val printWriter = PrintWriter(stringWriter)
        try {
            throwable.printStackTrace(printWriter)
            var cause = throwable.cause
            while (cause != null) {
                cause.printStackTrace(printWriter)
                cause = cause.cause
            }
            return stringWriter.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        } finally {
            printWriter.flush()
            printWriter.close()
            stringWriter.flush()
            stringWriter.close()
        }
        return ""
    }
}