package com.mozhimen.kotlin.utilk.kotlinx.coroutines

import com.mozhimen.kotlin.elemk.commons.ISuspendA_Listener
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

/**
 * @ClassName UtilKFlow
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/4 17:29
 * @Version 1.0
 */
fun <T> Flow<T>.throttleFirst(thresholdMillis: Long): Flow<T> =
    UtilKFlow.throttleFirst(this, thresholdMillis)

fun <T> Flow<T>.batchTime(maxMillis: Int): Flow<List<T>> =
    UtilKFlow.batchTime(this, maxMillis)

fun <T> Flow<T>.batchTimeSize(maxSize: Int, maxMillis: Int): Flow<List<T>> =
    UtilKFlow.batchTimeSize(this, maxSize, maxMillis)

/////////////////////////////////////////////////////////////////////////////////////

suspend fun <T> Flow<T>.collectSafe(block: ISuspendA_Listener<T>) {
    UtilKFlow.collectSafe(this, block)
}

suspend fun <T> Flow<T>.collectSafe(onGenerate: ISuspendA_Listener<T>, onError: ISuspendA_Listener<Throwable>) {
    UtilKFlow.collectSafe(this, onGenerate, onError)
}

/////////////////////////////////////////////////////////////////////////////////////

object UtilKFlow {
    @JvmStatic
    fun <T> throttleFirst(
        flow: Flow<T>,
        thresholdMillis: Long,
    ): Flow<T> =
        flow {
            var lastTime = 0L // 上次发射数据的时间
            flow.collect { upstream ->
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastTime > thresholdMillis) {// 时间差超过阈值则发送数据并记录时间
                    lastTime = currentTime
                    emit(upstream)
                }
            }
        }

    @JvmStatic
    fun <T> batchTime(
        flow: Flow<T>,
        maxMillis: Int,
    ): Flow<List<T>> =
        batchTimeSize(flow, Int.MAX_VALUE, maxMillis)

    @JvmStatic
    fun <T> batchTimeSize(
        flow: Flow<T>,
        maxSize: Int,
        maxMillis: Int,
    ): Flow<List<T>> =
        flow {
            val batch = mutableListOf<T>()
            var lastEmission = System.currentTimeMillis()

            flow.collect { value ->
                batch.add(value)
                if (batch.size >= maxSize || System.currentTimeMillis() > lastEmission + maxMillis) {
                    emit(batch.toList())
                    batch.clear()
                    lastEmission = System.currentTimeMillis()
                }
            }

            if (batch.isNotEmpty())
                emit(batch)
        }

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    suspend fun <T> collectSafe(
        flow: Flow<T>,
        block: ISuspendA_Listener<T>,
    ) {
        collectSafe(flow, block, UtilKLogWrapper::e)
    }

    @JvmStatic
    suspend fun <T> collectSafe(
        flow: Flow<T>,
        onGenerate: ISuspendA_Listener<T>,
        onError: ISuspendA_Listener<Throwable>?,
    ) {
        flow
            .catch {
                UtilKLogWrapper.e(it)
            }
            .collect {
                try {
                    onGenerate.invoke(it)
                } catch (e: Throwable) {
                    onError?.invoke(e)
                }
            }
    }
}