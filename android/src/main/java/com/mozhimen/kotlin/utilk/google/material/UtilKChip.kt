package com.mozhimen.kotlin.utilk.google.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.chip.Chip


/**
 * @ClassName UtilKChip
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/1/31 12:13
 * @Version 1.0
 */
fun Chip.getRowIndexKey(): Int =
    UtilKChip.getRowIndexKey(this)

/////////////////////////////////////////////////////////////////////////////////

object UtilKChip {
    @JvmStatic
    fun get(layoutInflater: LayoutInflater, @LayoutRes layoutResId: Int, root: ViewGroup, id: Int, text: String): Chip {
        val chip = layoutInflater.inflate(layoutResId, root, false) as Chip
        chip.id = id
        chip.text = text
        return chip
    }

    /** Gets the row index of the child, primarily for accessibility.    */
    @JvmStatic
    fun getRowIndexKey(chip: Chip): Int =
        chip.getTag(com.google.android.material.R.id.row_index_key) as? Int ?: -1
}