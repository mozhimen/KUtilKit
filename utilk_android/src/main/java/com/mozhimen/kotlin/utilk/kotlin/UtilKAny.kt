package com.mozhimen.kotlin.utilk.kotlin

import android.util.SparseArray
import android.util.SparseBooleanArray
import android.util.SparseIntArray
import android.util.SparseLongArray
import androidx.collection.LongSparseArray
import androidx.collection.SimpleArrayMap
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKField
import java.lang.reflect.Array


/**
 * @ClassName UtilKAny
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/14 15:41
 * @Version 1.0
 */

fun Any.getObjTypeName(): String =
    UtilKAny.getObjTypeName(this)

/////////////////////////////////////////////////////////////////////

fun Any.isObjNullOrEmpty(): Boolean =
    UtilKAny.isObjNullOrEmpty(this)

fun Any.isObjPrimitive(): Boolean =
    UtilKAny.isObjPrimitive(this)

fun Any.isObjTypeMatch(vararg matches: Class<*>): Boolean =
    UtilKAny.isObjTypeMatch(this, *matches)

/////////////////////////////////////////////////////////////////////

object UtilKAny : IUtilK {

    //获取类型名称
    @JvmStatic
    fun getObjTypeName(obj: Any): String =
        obj.javaClass.simpleName

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isObjNullOrEmpty(obj: Any?): Boolean {
        if (obj == null) return true
        if (obj.javaClass.isArray && Array.getLength(obj) == 0) {
            return true
        }
        if (obj is CharSequence && obj.toString().isEmpty()) {
            return true
        }
        if (obj is Collection<*> && obj.isEmpty()) {
            return true
        }
        if (obj is Map<*, *> && obj.isEmpty()) {
            return true
        }
        if (obj is SimpleArrayMap<*, *> && obj.isEmpty) {
            return true
        }
        if (obj is SparseArray<*> && obj.size() == 0) {
            return true
        }
        if (obj is SparseBooleanArray && obj.size() == 0) {
            return true
        }
        if (obj is SparseIntArray && obj.size() == 0) {
            return true
        }
        if (UtilKBuildVersion.isAfterV_18_43_J2()) {
            if (obj is SparseLongArray && obj.size() == 0) {
                return true
            }
        }
        if (obj is LongSparseArray<*> && obj.size() == 0) {
            return true
        }
        if (UtilKBuildVersion.isAfterV_16_41_J()) {
            if (obj is android.util.LongSparseArray<*> && obj.size() == 0) {
                return true
            }
        }
        return false
    }

    //判断数据类型是否是原始数据类型
    @JvmStatic
    fun isObjPrimitive(obj: Any): Boolean {
        //String
        if (obj.javaClass == String::class.java) return true
        try {
            //只适用于int byte short long boolean char double float
            val field = UtilKField.get(obj, "TYPE")
            val clazz = field[null] as Class<*>
            if (clazz.isPrimitive) return true
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
            e.message?.e(TAG)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
        return false
    }

    //判断类型是否匹配
    @JvmStatic
    fun isObjTypeMatch(obj: Any, vararg clazz: Class<*>): Boolean {
        try {
            return clazz.any { obj.javaClass == it || obj.javaClass.superclass == it }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }
        return false
    }
}