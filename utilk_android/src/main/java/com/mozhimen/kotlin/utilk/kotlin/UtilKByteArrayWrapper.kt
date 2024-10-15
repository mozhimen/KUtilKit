package com.mozhimen.kotlin.utilk.kotlin

/**
 * @ClassName UtilKByteArrayDeal
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/1 16:11
 * @Version 1.0
 */
fun ByteArray.indexOf(bytes: ByteArray): Int =
    UtilKByteArrayWrapper.indexOf(this, bytes)

///////////////////////////////////////////////////////////////////////////

object UtilKByteArrayWrapper {
    @JvmStatic
    fun isAll0(bytes: ByteArray): Boolean =
        bytes.firstOrNull { it != 0x0.toByte() } == null

//    /** Return the index at which the array was found or -1. */
//    @JvmStatic
//    fun indexOf(bytesOri: ByteArray, bytesDes: ByteArray): Int {
//        if (bytesDes.isEmpty())
//            return 0
//        outer@ for (i in 0 until bytesOri.size - bytesDes.size + 1) {
//            for (j in bytesDes.indices) {
//                if (bytesOri[i + j] != bytesDes[j]) {
//                    continue@outer
//                }
//            }
//            return i
//        }
//        return -1
//    }

    @JvmStatic
    fun indexOf(outerArray: ByteArray, smallerArray: ByteArray): Int {
        for (i in 0 until outerArray.size - smallerArray.size + 1) {
            var found = true
            for (j in smallerArray.indices) {
                if (outerArray[i + j] != smallerArray[j]) {
                    found = false
                    break
                }
            }
            if (found) return i
        }
        return -1
    }

    /**
     * 合并Bytes
     */
    @JvmStatic
    fun joinBytes_of2(bytes1: ByteArray, bytes2: ByteArray): ByteArray {
        val bytes = ByteArray(bytes1.size + bytes2.size)
        System.arraycopy(bytes1, 0, bytes, 0, bytes1.size)
        System.arraycopy(bytes2, 0, bytes, bytes1.size, bytes2.size)
        return bytes
    }

    /**
     * 合并Bytes
     */
    @JvmStatic
    fun joinBytes_of5(bytes1: ByteArray, bytes2: ByteArray, bytes3: ByteArray, bytes4: ByteArray, bytes5: ByteArray): ByteArray {
        val bytes = bytes1.copyOf(bytes1.size + bytes2.size + bytes3.size + bytes4.size + bytes5.size)
        System.arraycopy(bytes2, 0, bytes, bytes1.size, bytes2.size)
        System.arraycopy(bytes3, 0, bytes, bytes1.size + bytes2.size, bytes3.size)
        System.arraycopy(bytes4, 0, bytes, bytes1.size + bytes2.size + bytes3.size, bytes4.size)
        System.arraycopy(bytes5, 0, bytes, bytes1.size + bytes2.size + bytes3.size + bytes4.size, bytes5.size)
        return bytes
    }

    /**
     * 截取Bytes
     */
    /**
     * 截取byte数组   不改变原数组
     * @param b 原数组
     * @param off 偏差值（索引）
     * @param length 长度
     * @return 截取后的数组
     */
    @JvmStatic
    fun subBytes(bytes: ByteArray, offset: Int, length: Int): ByteArray {
        val newBytes = ByteArray(length)
        System.arraycopy(bytes, offset, newBytes, 0, length)
        return newBytes
    }
}