package com.mozhimen.kotlin.utilk.java.io

import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.str2bytes
import java.io.File
import java.io.FileOutputStream

/**
 * @ClassName UtilKFileOutputStream
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/2 16:54
 * @Version 1.0
 */
fun FileOutputStream.write_flashClose(str: String) {
    UtilKFileOutputStream.write_flashClose(this, str)
}

fun FileOutputStream.write_flashClose(bytes: ByteArray) {
    UtilKFileOutputStream.write_flashClose(this, bytes)
}

//////////////////////////////////////////////////////////////////////////

object UtilKFileOutputStream : IUtilK {
    @JvmStatic
    fun get(file: File, isAppend: Boolean = false): FileOutputStream =
        FileOutputStream(file, isAppend)

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun write_flashClose(fileOutputStream: FileOutputStream, str: String) {
        write_flashClose(fileOutputStream, str.str2bytes())
    }

    @JvmStatic
    fun write_flashClose(fileOutputStream: FileOutputStream, bytes: ByteArray) {
        fileOutputStream.flushClose { it.write(bytes) }
    }
}