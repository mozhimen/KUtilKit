package com.mozhimen.kotlin.utilk.java.io

import java.io.BufferedInputStream
import java.io.FileInputStream

/**
 * @ClassName UtilKFileInputStreamFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/11/10 15:09
 * @Version 1.0
 */
fun FileInputStream.fileInputStream2bufferedInputStream(): BufferedInputStream =
    UtilKFileInputStreamFormat.fileInputStream2bufferedInputStream(this)

///////////////////////////////////////////////////////////////////////////////

object UtilKFileInputStreamFormat {

    @JvmStatic
    fun fileInputStream2bufferedInputStream(fileInputStream: FileInputStream): BufferedInputStream =
        fileInputStream.inputStream2bufferedInputStream()

}