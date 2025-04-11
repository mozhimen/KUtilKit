package com.mozhimen.kotlin.utilk.androidx.fragment

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKFragmentWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/16
 * @Version 1.0
 */

object UtilKFragmentWrapper : IUtilK {
//    @JvmStatic
//    fun runOnViewLifecycleState(fragment: Fragment, state: Lifecycle.State, coroutineContext: CoroutineContext = EmptyCoroutineContext, block: ISuspendExt_Listener<CoroutineScope>) {
//        UtilKLifecycleOwner.runOnLifecycleState(fragment.viewLifecycleOwner, fragment.lifecycleScope, state, coroutineContext, block)
//    }

    /////////////////////////////////////////////////////////////////////

    /**
     * 可以通过在 AndroidManifest.xml 中配置 <activity> 的 android:screenOrientation 属性，将 Activity 的方向固定，可以避免因屏幕旋转导致的重建，同时也不会回调 onConfigurationChanged。但是该属性在 多窗口系统 下会失效。
     * 通过配置 android:configChanges 可以控制在哪些系统配置改变的情况下 Activity 不重建。最常用的包括 orientation，screenSize，keyboardHidden。不过通过该方法，Activity 虽然不再重建，但是系统会回调 onConfigurationChanged，需要开发者自己处理配置的变换。
     *
     * 链接：https://www.jianshu.com/p/60f2ed95b124
     *
     *
     */
    @JvmStatic
    fun onFragmentSaveInstanceState(fragmentActivity: FragmentActivity, outState: Bundle, map: Map<String, Fragment?>) {
        map.forEach {
            if (it.value != null) {
                UtilKFragmentManager.putFragment(fragmentActivity, outState, it.key, it.value!!)
                UtilKLogWrapper.d(TAG, "onSaveInstanceState: putFragment ${it.key} ${it.value}")
            }
        }
    }

    @JvmStatic
    fun onFragmentRestoreInstanceState(fragmentActivity: FragmentActivity, outState: Bundle?, vararg fragmentKey: String): HashMap<String, Fragment?> {
        val map: HashMap<String, Fragment?> = HashMap()
        if (outState == null) return map
        fragmentKey.forEach {
            map[it] = UtilKFragmentManager.getFragment(fragmentActivity, outState, it)
        }
        return map.also { UtilKLogWrapper.d(TAG, "onRestoreInstanceState: getFragment $it") }
    }
}