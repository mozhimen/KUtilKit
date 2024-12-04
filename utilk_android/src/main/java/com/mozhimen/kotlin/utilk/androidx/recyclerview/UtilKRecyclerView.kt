package com.mozhimen.kotlin.utilk.androidx.recyclerview

import android.icu.text.Transliterator.Position
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKViewRecycler
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 0:30
 * @Version 1.0
 */
object UtilKRecyclerView : IUtilK {
    @JvmStatic
    fun getChildAt(recyclerView: RecyclerView, index: Int): View? =
        recyclerView.getChildAt(index)

    ///////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun canScrollVertically(recyclerView: RecyclerView, direction: Int): Boolean =
        recyclerView.canScrollVertically(direction)

    ///////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun scrollToPosition(recyclerView: RecyclerView, position: Int) {
        recyclerView.scrollToPosition(position)
    }
}