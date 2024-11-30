package com.mozhimen.kotlin.utilk.java.nio

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer

/**
 * @ClassName UtilKFloatBufferFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/11/24 23:15
 * @Version 1.0
 */
fun FloatArray.floatArray2floatBuffer(): FloatBuffer =
    UtilKFloatBufferFormat.floatArray2floatBuffer(this)

/////////////////////////////////////////////////////////////////////

object UtilKFloatBufferFormat {
    /**
     * 将float[]数组转换为OpenGLES所需的FloatBuffer
     */
    @JvmStatic
    fun floatArray2floatBuffer(floatArray: FloatArray): FloatBuffer {
        val floatBuffer: FloatBuffer
        //初始化ByteBuffer，长度为arr数组的长度*4，因为一个float占4字节
        val byteBuffer = ByteBuffer.allocateDirect(floatArray.size * 4)
        byteBuffer.order(ByteOrder.nativeOrder())
        floatBuffer = byteBuffer.asFloatBuffer()
        floatBuffer.put(floatArray)
        floatBuffer.position(0)
        return floatBuffer
    }
}