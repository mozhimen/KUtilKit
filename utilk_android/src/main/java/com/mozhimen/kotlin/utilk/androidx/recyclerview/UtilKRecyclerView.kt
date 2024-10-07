package com.mozhimen.kotlin.utilk.androidx.recyclerview

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
fun RecyclerView.getItemCount(): Int =
    UtilKRecyclerView.getItemCount(this)

fun RecyclerView.getSpanCount(): Int =
    UtilKRecyclerView.getSpanCount(this)

fun RecyclerView.getLastVisibleItemPosition(): Int =
    UtilKRecyclerView.getLastVisibleItemPosition(this)

fun RecyclerView.getFirstVisibleItemPosition(): Int =
    UtilKRecyclerView.getFirstVisibleItemPosition(this)

fun LayoutManager.getLastVisibleItemPosition(): Int =
    UtilKRecyclerView.getLastVisibleItemPosition(this)

fun LayoutManager.getFirstVisibleItemPosition(): Int =
    UtilKRecyclerView.getFirstVisibleItemPosition(this)

///////////////////////////////////////////////////////////////////////////////////

fun RecyclerView.requireLayoutManager_ofLinear(): LinearLayoutManager? =
    UtilKRecyclerView.requireLayoutManager_ofLinear(this)

fun RecyclerView.requireLayoutManager_ofGrid(): GridLayoutManager? =
    UtilKRecyclerView.requireLayoutManager_ofGrid(this)

fun RecyclerView.isScrollVertical(): Boolean =
    UtilKRecyclerView.isScrollVertical(this)

///////////////////////////////////////////////////////////////////////////////////

object UtilKRecyclerView : IUtilK {

    @JvmStatic
    fun getChildAt(recyclerView: RecyclerView, index: Int): View? =
        recyclerView.getChildAt(index)

    /**
     * 获取 spanCount
     * 注：此方法只针对设置 LayoutManager 为 GridLayoutManager 的 RecyclerView 生效
     */
    @JvmStatic
    fun getSpanCount(recyclerView: RecyclerView): Int =
        requireLayoutManager_ofGrid(recyclerView)?.spanCount ?: 0

    //获取item数
    @JvmStatic
    fun getItemCount(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.itemCount ?: 0

    //找到最后一个可视的Item
    @JvmStatic
    fun getLastVisibleItemPosition(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.let { getLastVisibleItemPosition(it) } ?: -1

    //找到最后一个可视的Item
    @JvmStatic
    fun getLastVisibleItemPosition(layoutManager: LayoutManager): Int {
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
    fun getFirstVisibleItemPosition(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.let { getFirstVisibleItemPosition(it) } ?: -1

    //找到第一个可视的View
    @JvmStatic
    fun getFirstVisibleItemPosition(layoutManager: LayoutManager): Int {
        when (layoutManager) {
            //layoutManager is GridLayoutManager
            is LinearLayoutManager -> return layoutManager.findFirstVisibleItemPosition().also { UtilKLogWrapper.d(TAG, "getFirstVisibleItemPosition: LinearLayoutManager $it") }
            is StaggeredGridLayoutManager -> return layoutManager.findFirstVisibleItemPositions(null)[0].also { UtilKLogWrapper.d(TAG, "getFirstVisibleItemPosition: StaggeredGridLayoutManager $it") }
        }
        UtilKLogWrapper.w(TAG, "getFirstVisibleItemPosition: layoutManager $layoutManager")
        return -1
    }

    /**
     * 获取目标状态按钮
     */
//    open fun getProgressButtonByAppFileParams(appFileParams: AppFileParams): DownloadProgressButton? {
//        val recyclerView = getRecyclerView()
//        recyclerView ?: return null
//        val linearLayoutManager =
//            recyclerView.layoutManager as NiuLinearLayoutManager
//        //拿到开始显示的位置和最后显示的位置
//        val findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
//        if (findFirstVisibleItemPosition < 0) {
//            return null
//        }
//        val findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()
//        if (findLastVisibleItemPosition < 0) {
//            return null
//        }
//        (recyclerView.adapter as? AppBaseInfoPagedListAdapter<*>)?.let { adapter ->
//            if (adapter.itemCount <= 0) {
//                return null
//            }
//            for (position in findFirstVisibleItemPosition..findLastVisibleItemPosition) {
//                adapter.getItem(position)?.let { appBaseInfo ->
//                    if (appBaseInfo.id == appFileParams.appId && appBaseInfo.packageName == appFileParams.packName) {
//                        linearLayoutManager.findViewByPosition(position)
//                            ?.let { findViewByPosition ->
//                                return findViewByPosition.findViewById(R.id.common_app_base_info_status)
//                            }
//                    }
//                }
//            }
//        }
//        return null
//    }

    ///////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun canScrollVertically(recyclerView: RecyclerView, direction: Int): Boolean =
        recyclerView.canScrollVertically(direction)

    @JvmStatic
    fun isScrollVertical(recyclerView: RecyclerView): Boolean =
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> layoutManager.orientation == LinearLayoutManager.VERTICAL
            else -> true
        }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun requireLayoutManager_ofLinear(recyclerView: RecyclerView): LinearLayoutManager? {
        val layoutManager = recyclerView.layoutManager ?: return null
        if (layoutManager !is LinearLayoutManager)
            throw IllegalStateException("Make sure you are using the LinearLayoutManager")
        return layoutManager
    }

    /**
     * 检查 RecyclerView 设置的 GridLayoutManager
     */
    @JvmStatic

    fun requireLayoutManager_ofGrid(recyclerView: RecyclerView): GridLayoutManager? {
        val layoutManager = recyclerView.layoutManager ?: return null
        if (layoutManager !is GridLayoutManager) {
            throw IllegalStateException("Make sure you are using the GridLayoutManager")
        }
        return layoutManager
    }


}