package com.mozhimen.kotlin.utilk.kotlin.collections

/**
 * @ClassName UtilKMap
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/16
 * @Version 1.0
 */
fun <K, V> Map<K, V?>.filterNotNullValues(): Map<K, V> =
    UtilKMap.filterNotNullValues(this)

inline fun <X, Y, Z, H> Map<X, Y>.zipOnKeys(other: Map<X, Z>, f: (Y, Z) -> H): Map<X, H> =
    UtilKMap.zipOnKeys(this, other, f)

//////////////////////////////////////////////////////////////////////////////

fun <K, V> Map<K, V>.map2str(): String =
    UtilKMap.map2str(this)

///////////////////////////////////////////////////////////////////////

object UtilKMap {
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

    @JvmStatic
    fun <K, V> filterNotNullValues(map: Map<K, V?>): Map<K, V> {
        val destination = mutableMapOf<K, V>()
        for ((key, value) in map) {
            if (value != null) {
                destination[key] = value
            }
        }
        return destination
    }

    @JvmStatic
    inline fun <X, Y, Z, H> zipOnKeys(map: Map<X, Y>, other: Map<X, Z>, f: (Y, Z) -> H): Map<X, H> =
        map.keys.intersect(other.keys)
            .map { key ->
                key to f(map[key]!!, other[key]!!)
            }
            .toMap()

    @JvmStatic
    fun <K, V> mergeWith(vararg maps: Map<K, V>): HashMap<K, V> {
        val mutableMap = HashMap<K, V>()
        maps.forEach {
            mutableMap.putAll(it)
        }
        return mutableMap
    }
}

fun main() {
    val maps = listOf(
        mutableMapOf(1 to "1", 2 to "2", 3 to "3"),
        mapOf(1 to "2", 4 to "4", 5 to "5")
    )
    val merged: Map<Int, String> = maps.fold(mutableMapOf()) { acc, next -> acc += next;acc }
    println(merged)
}