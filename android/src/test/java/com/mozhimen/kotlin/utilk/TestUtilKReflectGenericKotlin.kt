package com.mozhimen.kotlin.utilk

/**
 * @ClassName TestUtilKReflectGenericKotlin
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/22 23:56
 * @Version 1.0
 */
class TestUtilKReflectGenericKotlin {

//    open class BaseReflect{
//        companion object{
//            @JvmStatic
//            fun printXXX():String{
//                return "xxx"
//            }
//        }
//    }
//
//    open class BaseReflectDisturb{
//        companion object{
//            @JvmStatic
//            fun printYYY():String{
//                return "yyy"
//            }
//        }
//    }
//    open class BaseClass<T:BaseReflect>
//
//    open class BaseClassA: BaseClass<BaseReflect>(){
//        @Test
//        open fun getParentGenericTypeClazz(){
//            UtilKReflectGenericKotlin.getParentGenericType_ofClazz(this::class.java)?.run {
//                (getDeclaredMethod("printXXX").invoke(null) as String).printlog()
//            }?:"null".printlog()
//        }
//    }
//
//    open class BaseClassB<T1:BaseReflectDisturb>: BaseClassA(){
//        @Test
//        override fun getParentGenericTypeClazz(){
//            UtilKReflectGenericKotlin.getParentGenericType_ofClazz(this::class.java)?.run {
//                (getDeclaredMethod("printXXX").invoke(null) as String).printlog()
//            }?:"null".printlog()
//        }
//
//        private val _disturb:T1? = null
//        fun getDisturb():T1? = _disturb
//    }
//
//    open class BaseClassC: BaseClassB<BaseReflectDisturb>() {
//        @Test
//        override fun getParentGenericTypeClazz(){
//            UtilKReflectGenericKotlin.getParentGenericType_ofClazz(this::class.java,BaseReflect::class.java)?.run {
//                (getDeclaredMethod("printXXX").invoke(null) as String).printlog()
//            }?:"null".printlog()
//        }
//    }
}