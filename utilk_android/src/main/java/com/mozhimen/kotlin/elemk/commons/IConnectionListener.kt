package com.mozhimen.kotlin.elemk.commons

import com.mozhimen.kotlin.elemk.android.net.cons.ENetType


/**
 * @ClassName IConnectionListener
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
interface IConnectionListener {
    fun onDisconnect(){}
    fun onConnect(types: Set<ENetType>){}
}