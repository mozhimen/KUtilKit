package com.mozhimen.kotlin.utilk.kotlin.collections

import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.util.stream.Collectors

/**
 * @ClassName UtilKCollections
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/11
 * @Version 1.0
 */
fun <T> MutableCollection<T>.removeBy(predicate: IA_BListener<T, Boolean>): Boolean =
    UtilKCollections.removeBy(this, predicate)

inline fun <T, K> Iterable<T>.associateByNotNull(keySelector: (T) -> K?): Map<K, T> =
    UtilKCollections.associateByNotNull(this, keySelector)

fun <T> Iterable<T>.containsBy(predicate: IA_BListener<T, Boolean>): Boolean =
    UtilKCollections.containsBy(this, predicate)

fun <T> Iterable<T>.getIndexFirst(predicate: IA_BListener<T, Boolean>): Int? =
    UtilKCollections.getIndexFirst(this, predicate)

fun <T> Iterable<T>.indexOf(predicate: (T) -> Boolean): List<Int> =
    UtilKCollections.indexOf(this, predicate)

fun <T, I> Iterable<T>.joinT2list(predicate: IA_BListener<T, I>): List<I> =
    UtilKCollections.joinT2list(this, predicate)

fun <T, I> Iterable<T>.joinT2listIgnoreRepeat(predicate: IA_BListener<T, I>): List<I> =
    UtilKCollections.joinT2listIgnoreRepeat(this, predicate)

fun <T, I> Iterable<T>.joinT2listIgnoreNull(predicate: IA_BListener<T?, I>): List<I> =
    UtilKCollections.joinT2listIgnoreNull(this, predicate)

///////////////////////////////////////////////////////////////////////

fun <T> List<T>.ifNotEmpty(block: IA_Listener<List<T>>) {
    UtilKCollections.ifNotEmpty(this, block)
}

fun <T> List<T>.ifNotEmptyOr(onNotEmpty: IA_Listener<List<T>>, onEmpty: I_Listener) {
    UtilKCollections.ifNotEmptyOr(this, onNotEmpty, onEmpty)
}

fun <T> List<T>.list2str(): String =
    UtilKCollections.list2str(this)

///////////////////////////////////////////////////////////////////////

inline fun <T> List<T>.forEachReversedByIndex(action: (T) -> Unit) {
    UtilKCollections.forEachReversedByIndex(this, action)
}

fun List<String>.filterNotEmpty(): List<String> =
    UtilKCollections.filterNotEmpty(this)

///////////////////////////////////////////////////////////////////////

object UtilKCollections : IUtilK {
    @JvmStatic
    fun filterNotEmpty(strs: List<String>): List<String> =
        strs.filterNot { it.isEmpty() }

    @JvmStatic
    fun listsEqual(list1: List<*>, list2: List<*>): Boolean {
        if (list1.size != list2.size)
            return false
        val pairList = list1.zip(list2)
        return pairList.all { (elt1, elt2) ->
            elt1 == elt2
        }.also { UtilKLogWrapper.d(TAG, "listsEqual: $it") }
    }

    inline fun <T> forEachReversedByIndex(list: List<T>, action: (T) -> Unit) {
        val initialSize = list.size
        for (i in list.lastIndex downTo 0) {
            if (list.size != initialSize) throw ConcurrentModificationException()
            action(list.get(i))
        }
    }

    @JvmStatic
    fun <T> removeBy(collection: MutableCollection<T>, predicate: IA_BListener<T, Boolean>): Boolean {
        if (UtilKBuildVersion.isAfterV_24_7_N()) {
            return collection.removeIf(predicate)
        } else {
            var removed = false
            val iterator = collection.iterator()
            while (iterator.hasNext()) {
                val obj = iterator.next()
                if (predicate.invoke(obj)) {
                    iterator.remove()
                    removed = true
                    break
                }
            }
            return removed
        }
    }

    @JvmStatic
    inline fun <T, K> associateByNotNull(iterator: Iterable<T>, keySelector: (T) -> K?): Map<K, T> {
        return iterator.map { keySelector(it) to it }
            .filter { (key, _) -> key != null }
            .associate { (key, value) -> key!! to value }
    }

    //判断符合条件的元素是否在Collection中
    @JvmStatic
    fun <T> containsBy(iterable: Iterable<T>, predicate: IA_BListener<T, Boolean>): Boolean =
        getIndexFirst(iterable, predicate) != null

    //获取符合条件的元素在该Collection的位置
    @JvmStatic
    fun <T> getIndexFirst(iterable: Iterable<T>, predicate: IA_BListener<T, Boolean>): Int? {
        val index = iterable.indexOf(iterable.find(predicate))
        return if (index == -1) null else index
    }

    @JvmStatic
    fun <T> indexOf(iterable: Iterable<T>, predicate: (T) -> Boolean): List<Int> {
        val indexes = mutableListOf<Int>()
        for ((index, item) in iterable.withIndex()) {
            if (predicate(item))
                indexes.add(index)//return index
        }
        return indexes
    }

    //将一个Collection的Item中的某个Element组合起来成一个新Collection
    @JvmStatic
    fun <T, I> joinT2list(iterable: Iterable<T>, predicate: IA_BListener<T, I>): List<I> =
        joinT2list(iterable, ArrayList(), predicate)

    //将一个Collection的Item中的某个Element组合起来成一个新Collection
    @JvmStatic
    fun <T, I, C : MutableCollection<in I>> joinT2list(iterable: Iterable<T>, newCollection: C, predicate: IA_BListener<T, I>): C {
        for (element in iterable) {
            if (!newCollection.contains(predicate(element)))
                newCollection.add(predicate(element))
        }
        return newCollection
    }

    //将一个Collection的Item中的某个Element组合起来成一个新Collection(忽略重复的)
    @JvmStatic
    fun <T, I> joinT2listIgnoreRepeat(iterable: Iterable<T>, predicate: IA_BListener<T, I>): List<I> =
        joinT2listIgnoreRepeat(iterable, ArrayList(), predicate)

    //将一个Collection的Item中的某个Element组合起来成一个新Collection(忽略重复的)
    @JvmStatic
    fun <T, I, C : MutableCollection<in I>> joinT2listIgnoreRepeat(iterable: Iterable<T>, newCollection: C, predicate: IA_BListener<T, I>): C {
        for (element in iterable)
            newCollection.add(predicate(element))
        return newCollection
    }

    //将一个Collection的Item中的某个Element组合起来成一个新Collection(忽略Null的)
    @JvmStatic
    fun <T, I> joinT2listIgnoreNull(iterable: Iterable<T?>, predicate: IA_BListener<T?, I>): List<I> =
        joinT2listIgnoreNull(iterable, ArrayList(), predicate)

    //将一个Collection的Item中的某个Element组合起来成一个新Collection(忽略Null的)
    @JvmStatic
    fun <T, I, C : MutableCollection<in I>> joinT2listIgnoreNull(iterable: Iterable<T?>, newCollection: C, predicate: IA_BListener<T?, I>): C {
        for (element in iterable)
            newCollection.add(predicate(element))
        return newCollection
    }

    ///////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun <T> ifNotEmpty(list: List<T>, block: IA_Listener<List<T>>) {
        if (list.isNotEmpty())
            block.invoke(list)
    }

    @JvmStatic
    fun <T> ifNotEmptyOr(list: List<T>, onNotEmpty: IA_Listener<List<T>>, onEmpty: I_Listener) {
        if (list.isNotEmpty())
            onNotEmpty.invoke(list)
        else
            onEmpty.invoke()
    }

    @JvmStatic
    @JvmOverloads
    fun <T> list2str(list: List<T>, defaultValue: String = "", splitChar: String = ","): String =
        if (UtilKBuildVersion.isAfterV_24_7_N()) {
            list.stream().map { elem: T? -> elem?.toString() ?: "" }.collect(Collectors.joining(splitChar)).ifEmpty { defaultValue }
        } else {
            val stringBuilder = StringBuilder()
            for (obj in list)
                stringBuilder.append(obj?.toString() ?: "").append(splitChar)
            if (stringBuilder.isNotEmpty())
                stringBuilder.deleteAt(stringBuilder.length - 1).toString()
            else defaultValue
        }

    ///////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun <K, V> map2str(map: Map<K, V>, defaultValue: String = "", splitChar: String = ",", splitCharKV: String = ":"): String {
        if (map.isEmpty()) return defaultValue
        val stringBuilder = StringBuilder()
        val iterator: Iterator<*> = map.entries.iterator()
        while (iterator.hasNext()) {
            val (key, value) = iterator.next() as Map.Entry<*, *>
            stringBuilder.append("$key $splitCharKV $value").append(splitChar)
            stringBuilder.append("\n")
        }
        if (stringBuilder.isNotEmpty())
            stringBuilder.deleteAt(stringBuilder.length - 1).toString()
        return stringBuilder.toString()
    }
}