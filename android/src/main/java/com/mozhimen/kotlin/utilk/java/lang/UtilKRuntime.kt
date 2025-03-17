package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.io.IOException

/**
 * @ClassName UtilKShell
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/6/13 17:52
 * @Version 1.0
 */
/**
 * 优点：获取的是PSS，并且没有限频，可以获取到 PSS 的组成部分
 * 缺点：获取的 PSS 不包括 Graphics。Android 6 以下不能通过 Debug.MemoryInfo.getmemoryStat 接口获取组成部分的占用内存，只能通过反射方法获取。
 */
object UtilKRuntime : BaseUtilK() {


    @JvmStatic
    fun get(): Runtime =
        Runtime.getRuntime()

    @JvmStatic
    @Throws(IOException::class)
    fun exec(cmds: Array<String>): Process =
        get().exec(cmds)

    @JvmStatic
    @Throws(IOException::class)
    fun exec(command: String): Process =
        get().exec(command)

    /**
     * 返回的是当前进程的java虚拟机从操作系统申请的总内存
     */
    @JvmStatic
    fun getTotalMemory(): Long =
        get().totalMemory()

    /**
     * 返回的是当前进程的java虚拟机从操作系统申请的总内存中尚未使用的内存大小
     */
    @JvmStatic
    fun getFreeMemory(): Long =
        get().freeMemory()

    /**
     * 那么运行时内存呢？笔者认为是totalMemory()-freeMemory()。代表当前进程的java虚拟机从操作系统申请的总内存中已经消耗的内存大小。
     * 但是计算得到的值 是不包含native内存的，因为笔者发现Runtime计算得到的值 约等于PSS中的Java Heap的值，所以Runtime接口获取的运行时内存只是java层面的。（如有不对，欢迎各位看官一起指正，讨论）
     */
    @JvmStatic
    fun getRuntimeMemory(): Long =
        getTotalMemory() - getFreeMemory()
}