package com.mozhimen.kotlin.elemk.android.content.impls

import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import com.mozhimen.kotlin.elemk.commons.IA_Listener

/**
 * @ClassName ComponentCallbacksProxy
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/12
 * @Version 1.0
 */
class ComponentCallbacksProxy(configuration: Configuration) : ComponentCallbacks {
    /** 当前屏幕的方向  */
    private var _screenOrientation: Int = configuration.orientation

    /** 屏幕旋转回调  */
    private var _screenOrientationListener: ComponentCallbacksListener? = null

    /**
     * 注册监听
     */
    fun registerCallback(context: Context, listener: ComponentCallbacksListener) {
        context.applicationContext.registerComponentCallbacks(this)
        _screenOrientationListener = listener
    }

    /**
     * 取消监听
     */
    fun unregisterCallback(context: Context) {
        context.applicationContext.unregisterComponentCallbacks(this)
        _screenOrientationListener = null
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (_screenOrientation != newConfig.orientation) {
            _screenOrientation = newConfig.orientation
            _screenOrientationListener?.onScreenOrientationChange(_screenOrientation)
        }
    }

    override fun onLowMemory() {
        // default implementation ignored
    }

    /**
     * 屏幕方向监听器
     */
    interface ComponentCallbacksListener {
        /**
         * 监听屏幕旋转了
         *
         * @param newOrientation         最新的屏幕方向
         */
        fun onScreenOrientationChange(newOrientation: Int) {}
    }
}