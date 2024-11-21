package com.mozhimen.kotlin.utilk.java.io

import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.util.UtilKGZIPOutputStream
import com.mozhimen.kotlin.utilk.java.util.UtilKZipOutputStream
import java.io.BufferedOutputStream
import java.io.OutputStream
import java.util.zip.GZIPOutputStream
import java.util.zip.ZipOutputStream

/**
 * @ClassName UtilKOutputStream
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/4 13:49
 * @Version 1.0
 */
fun OutputStream.outputStream2bufferedOutputStream(): BufferedOutputStream =
    UtilKOutputStream.outputStream2bufferedOutputStream(this)

fun OutputStream.outputStream2zipOutputStream(): ZipOutputStream =
    UtilKOutputStream.outputStream2zipOutputStream(this)

fun OutputStream.outputStream2gZipOutputStream(): GZIPOutputStream =
    UtilKOutputStream.outputStream2gZIPOutputStream(this)

/////////////////////////////////////////////////////////////////////////////

object UtilKOutputStream : IUtilK {
    @JvmStatic
    fun outputStream2bufferedOutputStream(outputStream: OutputStream): BufferedOutputStream =
        UtilKBufferedOutputStream.get(outputStream)

    @JvmStatic
    fun outputStream2zipOutputStream(outputStream: OutputStream): ZipOutputStream =
        UtilKZipOutputStream.get(outputStream)

    @JvmStatic
    fun outputStream2gZIPOutputStream(outputStream: OutputStream): GZIPOutputStream =
        UtilKGZIPOutputStream.get(outputStream)
}