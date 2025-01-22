package com.mozhimen.kotlin.utilk.java.util

import android.os.Environment
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.utilk.java.io.file2fileInputStream
import java.io.File
import java.io.FileInputStream
import java.util.Properties

/**
 * @ClassName UtilKProperties
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/18
 * @Version 1.0
 */
object UtilKProperties {
    @JvmStatic
    fun get(): Properties =
        Properties()

    @JvmStatic
    fun get(fileInputStream: FileInputStream): Properties? =
        get().apply { load(fileInputStream) }

    @JvmStatic
    fun getProperty(fileInputStream: FileInputStream, key: String, defaultValue: String): String? =
        get(fileInputStream)?.getProperty(key, defaultValue)

    @JvmStatic
    fun getProperty(fileInputStream: FileInputStream, key: String): String? =
        get(fileInputStream)?.getProperty(key)

    @JvmStatic
    fun getProperty_ofBuildProp(key: String): String? {
        return getProperty(File(Environment.getRootDirectory(), CStrPackage.build_prop).file2fileInputStream()?:return null, key)
    }

    @JvmStatic
    fun getProperty_ofBuildProp(key: String, defaultValue: String): String? {
        return getProperty(File(Environment.getRootDirectory(), CStrPackage.build_prop).file2fileInputStream()?:return null, key, defaultValue)
    }
}