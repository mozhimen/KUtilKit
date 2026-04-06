package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import java.io.InputStream

/**
 * @ClassName UtilKAssetManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/25 16:06
 * @Version 1.0
 */
object UtilKAssetManager {
    @JvmStatic
    fun get_ofContext(context: Context): AssetManager =
        UtilKContext.getAssets(context)

    @JvmStatic
    fun get_ofResources(context: Context): AssetManager =
        UtilKResources.getAssets_ofApp(context)//===get_ofContext

    /////////////////////////////////////////////////////////////

    @JvmStatic
    fun openFd(strAssetName: String, context: Context): AssetFileDescriptor =
        get_ofContext(context).openFd(strAssetName)

    @JvmStatic
    fun open(strAssetName: String, context: Context): InputStream =
        get_ofContext(context).open(strAssetName)

    @JvmStatic
    fun list(strAssetName: String, context: Context): Array<String>? =
        get_ofContext(context).list(strAssetName)
}