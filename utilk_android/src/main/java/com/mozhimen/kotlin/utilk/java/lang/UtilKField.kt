package com.mozhimen.kotlin.utilk.java.lang

import java.lang.reflect.Field

/**
 * @ClassName UtilKField
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 19:20
 * @Version 1.0
 */
object UtilKField {
    @Throws(NoSuchFieldException::class)
    fun get(obj: Any, fieldName: String): Field {
        return get(obj.javaClass, fieldName)
    }

    //仅能获取类本身的属性成员（包括私有、共有、保护）
    @Throws(NoSuchFieldException::class)
    fun get(clazz: Class<*>, fieldName: String): Field {
        var tempClazz: Class<*>? = clazz
        while (tempClazz != null) {
            try {
                val field = tempClazz.getDeclaredField(fieldName)
                if (!field.isAccessible) field.isAccessible = true
                return field
            } catch (e: NoSuchFieldException) {
                // ignore and search next
            }
            tempClazz = tempClazz.superclass
        }
        throw NoSuchFieldException("Field $fieldName not found in $clazz")
    }


    //////////////////////////////////////////////////////////////////////////
    @Throws(NoSuchFieldException::class, IllegalAccessException::class)
    fun getInt(obj: Any, fieldName: String): Int {
        return get(obj, fieldName).getInt(obj)
    }


    //////////////////////////////////////////////////////////////////////////
    //获取类及其基类所有的field
    fun getAll(obj: Any): List<Field> {
        return getAll(obj.javaClass)
    }

    //获取类及其基类所有的field
    fun getAll(clazz: Class<*>): List<Field> {
        val fields = ArrayList(listOf(*clazz.declaredFields))
        var superClass = clazz.superclass
        while (superClass != null) {
            val superFields = superClass.declaredFields
            fields.addAll(listOf(*superFields))
            superClass = superClass.superclass
        }
        return fields
    }
}