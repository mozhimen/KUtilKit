package com.mozhimen.kotlin.elemk.mos

/**
 * @ClassName NTuple
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/17
 * @Version 1.0
 */
data class NTuple2<T1, T2>(var t1: T1, var t2: T2) {
    operator fun <T3, T4, T5> plus(other: NTuple3<T3, T4, T5>): NTuple5<T1, T2, T3, T4, T5> {
        return NTuple5(this.t1, this.t2, other.t1, other.t2, other.t3)
    }
}
data class NTuple3<T1, T2, T3>(var t1: T1, var t2: T2, var t3: T3)
data class NTuple4<T1, T2, T3, T4>(var t1: T1, var t2: T2, var t3: T3, var t4: T4){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NTuple4<*, *, *, *>

        if (t1 != other.t1) return false
        if (t2 != other.t2) return false
        if (t3 != other.t3) return false
        if (t4 != other.t4) return false

        return true
    }

    override fun hashCode(): Int {
        var result = t1?.hashCode() ?: 0
        result = 31 * result + (t2?.hashCode() ?: 0)
        result = 31 * result + (t3?.hashCode() ?: 0)
        result = 31 * result + (t4?.hashCode() ?: 0)
        return result
    }
}
data class NTuple5<T1, T2, T3, T4, T5>(var t1: T1, var t2: T2, var t3: T3, var t4: T4, var t5: T5)
