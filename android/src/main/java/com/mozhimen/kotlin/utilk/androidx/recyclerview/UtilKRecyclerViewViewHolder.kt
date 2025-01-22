package com.mozhimen.kotlin.utilk.androidx.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @ClassName UtilKRecyclerViewViewHolder
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/25 23:11
 * @Version 1.0
 */
object UtilKRecyclerViewViewHolder {
    /**
     * 此方法已弃用，因为它的含义是不明确的，因为适配器更新是异步处理的。
     * 您应该使用getLayoutPosition()， getBindingAdapterPosition()或getAbsoluteAdapterPosition()，这取决于您的用例。
     */
    @JvmStatic
    fun getPosition(holder: ViewHolder): Int =
        holder.position

    /**
     * 弃用：原因当适配器嵌套其他适配器时，这种方法会造成混淆。如果你在一个适配器的环境中调用它，你可能想要调用getBindingAdapterPosition()，或者如果你想要的位置是RecyclerView看到的，你应该调用getAbsoluteAdapterPosition()。看来是为了适配新的需求，所以在getAdapterPosition的基础上扩展开了这两种方法。那么常规的展示同一种数据类型的adapter还是使用getAbsoluteAdapterPosition或者getAdapterPosition也是可以的。
     * 特性：关于getAdapterPosition，此方法始终包含更新后的适配器的位置holder。这意味着每当您单击一个item时，您都会向适配器询问它的position. 所以你会得到这个item在适配器逻辑方面的最新位置。getAdapterPosition()它会返回数据在Adapter中的位置（也许位置的变化还未来得及刷新到布局中），当使用Adapter的时候（例如调用Adapter的刷新相关方法时）可考虑使用
     */
    @JvmStatic
    fun getAdapterPosition(holder: ViewHolder):Int =
        holder.adapterPosition

    /**
     * 它返回ViewHolder在最新布局中的适配器位置，即用户看到布局的最新位置。
     * 根据代码中的解释，在Recyclerview 进行添加、移除item等操作时，position位置可能会变化，而所有的adapter的刷新并不总是及时的，只有这个方法返回的才是当前item经过一些变换后所处的真正位置。此外，点击事件用这个也没毛病哈
     */
    @JvmStatic
    fun getLayoutPosition(holder: ViewHolder):Int =
        holder.layoutPosition

    /**
     * 用于获取元素位于当前绑定Adapter的位置
     *
     * 这个方法用于获取 bindingAdapter（绑定的适配器）中 item 的位置。
     * 在 RecyclerView 存在多层嵌套 Adapter 时，getBindingAdapterPosition 返回的是 item 在其 绑定的 Adapter 中的位置。
     * 当有 Adapter 嵌套（如 ConcatAdapter 或其他复合 Adapter）时，这个方法有助于在当前 item 的 bindingAdapter 中进行操作。
     */
    @JvmStatic
    fun getBindingAdapterPosition(holder: ViewHolder):Int =
        holder.position

    /**
     * 一个是用于获取元素位于Adapter中的绝对位置
     *
     * 这个方法用于获取 在整个 RecyclerView 中的绝对位置。
     * 无论 item 位于哪个 Adapter 中，getAbsoluteAdapterPosition 总是返回 item 在整体的 RecyclerView Adapter（外层的 Adapter）中的绝对位置
     */
    @JvmStatic
    fun getAbsoluteAdapterPosition(holder: ViewHolder):Int =
        holder.position
}