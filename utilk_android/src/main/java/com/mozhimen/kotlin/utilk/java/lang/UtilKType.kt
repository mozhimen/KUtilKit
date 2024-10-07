package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.elemk.java.lang.bases.BaseGeneric
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @ClassName UtilKType
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 19:22
 * @Version 1.0
 */
object UtilKType :IUtilK{
    //获取当前<>里面的泛型实例
    @JvmStatic
    inline fun <reified T> getClass(index: Int = 0): Class<*>? =
        get<T>(index) as? Class<*>?

    //获取当前<>里面的泛型实例
    @JvmStatic
    inline fun <reified T> get(index: Int = 0): Type? =
        object : BaseGeneric<T>() {}::class.java
            .genericSuperclass
            .let { it as ParameterizedType }
            .actualTypeArguments.filterIsInstance<Class<*>>()
            .run {
                if (this.isNotEmpty() && index in this.indices)
                    this[index]
                else
                    null
            }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //获取继承自parentClass的泛型实例
    @JvmStatic
    fun getClass_ofParent(clazz: Class<*>, clazzDes: Class<*>/*, index: Int = 0*/): Class<*>? =
        get_ofParent(clazz, clazzDes) as? Class<*>?

    //获取继承自parentClass的泛型实例
    @JvmStatic
    fun get_ofParent(clazz: Class<*>, clazzDes: Class<*>/*, index: Int = 0*/): Type? {
        val superClazz: Class<*>? = clazz.superclass
        val genericSuperclass: Type? = clazz.genericSuperclass
        if (genericSuperclass !is ParameterizedType) {//当继承类不是参数化类型,就从父类中寻找
            return if (superClazz != null) {
                get_ofParent(superClazz, clazzDes)//当我们继承多层BaseActivity时递归查找泛型
            } else
                null
        }
        genericSuperclass.actualTypeArguments.filterIsInstance<Class<*>>()
            .run {
                if (this.isNotEmpty()) {
                    for (clz in this) {
                        if (clazzDes.isAssignableFrom(clz)){
                            UtilKLogWrapper.v(TAG, "get_ofParent: clz $clz")
                            return clz
                        }
                    }
                }
                if (superClazz != null)
                    return get_ofParent(superClazz, clazzDes)
                else
                    return null
            }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //获取父类泛型类
    @JvmStatic
    fun getClass_ofParent(clazz: Class<*>, index: Int = 0): Class<*>? =
        get_ofParent(clazz, index) as? Class<*>?

    //获取父类泛型type
    @JvmStatic
    fun get_ofParent(clazz: Class<*>, index: Int = 0): Type? {
        val superClazz = clazz.superclass
        val genericSuperclass = clazz.genericSuperclass
        if (genericSuperclass !is ParameterizedType) {//当继承类不是参数化类型,就从父类中寻找
            return if (superClazz != null) {
                get_ofParent(superClazz, index)
            } else
                null//当我们继承多层BaseActivity时递归查找泛型
        }
        genericSuperclass
            .actualTypeArguments.filterIsInstance<Class<*>>()
            .run {
                return if (this.isNotEmpty() && index in this.indices)
                    this[index]
                else if (superClazz!=null)
                    get_ofParent(superClazz,index)
                else
                    null
            }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //获取继承父类的泛型类
    @JvmStatic
    inline fun <reified T> getClass_ofParent(index: Int = 0): Class<*>? =
        get_ofParent<T>(index) as? Class<*>?

    //获取继承父类的泛型Type
    @JvmStatic
    inline fun <reified T> get_ofParent(index: Int = 0): Type? =
        get_ofParent(T::class.java, index)
}