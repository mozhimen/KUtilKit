package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * @ClassName UtilKMethod
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 19:21
 * @Version 1.0
 */
object UtilKMethod : IUtilK {
    @JvmStatic
    @Throws(NoSuchMethodException::class, SecurityException::class)
    fun getDeclared_throw(obj: Any, methodName: String, vararg parameterTypes: Class<*>?): Method {
        return getDeclared_throw(obj.javaClass, methodName, *parameterTypes)
    }

    @JvmStatic
    @Throws(NoSuchMethodException::class, SecurityException::class)
    fun getDeclared_throw(clazz: Class<*>, methodName: String, vararg parameterTypes: Class<*>?): Method {
        var tempClazz: Class<*>? = clazz
        while (tempClazz != null) {
            try {
                val method = tempClazz.getDeclaredMethod(methodName, *parameterTypes)
                if (!method.isAccessible) {
                    method.isAccessible = true
                }
                return method
            } catch (e: NoSuchMethodException) {
                // ignore and search next
            }
            tempClazz = tempClazz.superclass
        }
        throw NoSuchMethodException("Method " + methodName + " with parameters " + listOf(*parameterTypes) + " not found in " + clazz)
    }

    @JvmStatic
    @Throws(IllegalAccessException::class, IllegalArgumentException::class, InvocationTargetException::class)
    fun invoke_throw(method: Method, obj: Any?, vararg args: Any) {
        method.invoke(obj, *args)
    }

    @JvmStatic
    @Throws(IllegalAccessException::class, IllegalArgumentException::class, InvocationTargetException::class, NoSuchMethodException::class, SecurityException::class)
    fun getDeclared_invoke_throw(obj: Any, methodName: String, parameterTypes: Array<Class<*>?>, obj1: Any?, vararg args: Any?): Any? {
        return getDeclared_throw(obj.javaClass, methodName, *parameterTypes).invoke(obj1, *args)
    }


    @JvmStatic
    @Throws(IllegalAccessException::class, IllegalArgumentException::class, InvocationTargetException::class, NoSuchMethodException::class, SecurityException::class)
    fun getDeclared_invoke_throw(clazz: Class<*>, methodName: String, parameterTypes: Array<Class<*>?>, obj: Any?, vararg args: Any?): Any? {
        return getDeclared_throw(clazz, methodName, *parameterTypes).invoke(obj, *args)
    }
}


