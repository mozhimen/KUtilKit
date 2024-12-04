package com.mozhimen.kotlin.utilk.androidx.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.androidx.recyclerview.UtilKRecyclerViewWrapper.TAG

/**
 * @ClassName UtilKLayoutManager
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/4
 * @Version 1.0
 */
fun RecyclerView.LayoutManager.getLastVisibleItemPosition(): Int =
    UtilKLayoutManagerWrapper.getLastVisibleItemPosition(this)

fun RecyclerView.LayoutManager.getFirstVisibleItemPosition(): Int =
    UtilKLayoutManagerWrapper.getFirstVisibleItemPosition(this)

////////////////////////////////////////////////////////////////////

object UtilKLayoutManagerWrapper {
    //找到最后一个可视的Item
    @JvmStatic
    fun getLastVisibleItemPosition(layoutManager: RecyclerView.LayoutManager): Int {
        when (layoutManager) {
            //layoutManager is GridLayoutManager
            is LinearLayoutManager -> return layoutManager.findLastVisibleItemPosition()
            is StaggeredGridLayoutManager -> {
//                return layoutManager.findLastVisibleItemPositions(null)[0]
                val lastItemPoss = IntArray(layoutManager.spanCount)
                layoutManager.findLastVisibleItemPositions(lastItemPoss)
                return lastItemPoss.maxOf { it }
            }
        }
        return -1
    }

    //找到第一个可视的View
    @JvmStatic
    fun getFirstVisibleItemPosition(layoutManager: RecyclerView.LayoutManager): Int {
        when (layoutManager) {
            //layoutManager is GridLayoutManager
            is LinearLayoutManager -> return layoutManager.findFirstVisibleItemPosition().also { UtilKLogWrapper.d(TAG, "getFirstVisibleItemPosition: LinearLayoutManager $it") }
            is StaggeredGridLayoutManager -> return layoutManager.findFirstVisibleItemPositions(null)[0].also { UtilKLogWrapper.d(TAG, "getFirstVisibleItemPosition: StaggeredGridLayoutManager $it") }
        }
        UtilKLogWrapper.w(TAG, "getFirstVisibleItemPosition: layoutManager $layoutManager")
        return -1
    }
}