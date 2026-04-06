package com.mozhimen.kotlin.utilk.androidx.core

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2file
import java.io.File

/**
 * @ClassName UtilKFileProvider
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/12/19
 * @Version 1.0
 */
object UtilKFileProvider {

    @JvmStatic
    fun getUriForStrFilePathName(authority: String, strFilePathName: String, context: Context): Uri? =
        if (strFilePathName.isEmpty()) null
        else getUriForFile(authority, strFilePathName.strFilePath2file(), context)

    @JvmStatic
    fun getUriForFile(authority: String, file: File, context: Context): Uri =
        FileProvider.getUriForFile(context, authority, file)
}