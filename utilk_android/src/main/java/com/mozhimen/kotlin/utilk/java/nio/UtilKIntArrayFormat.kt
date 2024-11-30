package com.mozhimen.kotlin.utilk.java.nio

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.IntBuffer

/**
 * @ClassName UtilKIntArray
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/11/24 23:10
 * @Version 1.0
 */
fun IntArray.intArray2intBuffer(): IntBuffer =
    UtilKIntArrayFormat.intArray2intBuffer(this)

////////////////////////////////////////////////////////////////////////

object UtilKIntArrayFormat {
    /**
     * 将int[]数组转换为OpenGLES所需的IntBuffer
     */
    @JvmStatic
    fun intArray2intBuffer(intArray: IntArray): IntBuffer {
        val intBuffer: IntBuffer
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4字节
        val byteBuffer = ByteBuffer.allocateDirect(intArray.size * 4)
        byteBuffer.order(ByteOrder.nativeOrder()) //数组排列用nativeOrder
        intBuffer = byteBuffer.asIntBuffer()
        intBuffer.put(intArray)
        intBuffer.position(0)
        return intBuffer
    }
}