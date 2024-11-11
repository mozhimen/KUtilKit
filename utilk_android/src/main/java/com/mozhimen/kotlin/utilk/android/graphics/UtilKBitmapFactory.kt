package com.mozhimen.kotlin.utilk.android.graphics

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import androidx.annotation.DrawableRes
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.io.FileDescriptor
import java.io.InputStream

/**
 * @ClassName UtilKBitmapFactory
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/12/19
 * @Version 1.0
 */
object UtilKBitmapFactory : IUtilK {
    @JvmStatic
    fun decodeFileDescriptor(fd: FileDescriptor, outPadding: Rect? = null, opts: BitmapFactory.Options? = null): Bitmap =
        BitmapFactory.decodeFileDescriptor(fd, outPadding, opts)

    @JvmStatic
    fun decodeStream(inputStream: InputStream): Bitmap =
        BitmapFactory.decodeStream(inputStream)

    @JvmStatic
    fun decodeStream(inputStream: InputStream?, outPadding: Rect?, opts: BitmapFactory.Options?): Bitmap? =
        BitmapFactory.decodeStream(inputStream, outPadding, opts)

    @JvmStatic
    fun decodeFile(strFilePathName: String): Bitmap =
        BitmapFactory.decodeFile(strFilePathName)

    @JvmStatic
    fun decodeFile(strFilePathName: String, opts: BitmapFactory.Options): Bitmap =
        BitmapFactory.decodeFile(strFilePathName, opts)

    @JvmStatic
    fun decodeResource(res: Resources, @DrawableRes intResDrawable: Int): Bitmap =
        BitmapFactory.decodeResource(res, intResDrawable).also { UtilKLogWrapper.d(TAG, "decodeResource: intResDrawable $intResDrawable") }

    @JvmStatic
    fun decodeResource(res: Resources, @DrawableRes intResDrawable: Int, opts: BitmapFactory.Options): Bitmap =
        BitmapFactory.decodeResource(res, intResDrawable, opts)

    @JvmStatic
    fun decodeByteArray(data: ByteArray, offset: Int, length: Int): Bitmap =
        BitmapFactory.decodeByteArray(data, offset, length)
}