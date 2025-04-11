package com.mozhimen.kotlin.elemk.androidx.fragment.impls

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy
import com.mozhimen.kotlin.utilk.androidx.fragment.UtilKFragmentWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName FragmentsStoreProxy
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/4/8
 * @Version 1.0
 */
@OApiInit_ByLazy
open class FragmentsStoreProxy : IUtilK {
    protected var _fragments = HashMap<String, Fragment?>()

    ////////////////////////////////////////////////////////////////////

    /**
     *     override fun onSaveInstanceState(outState: Bundle) {
     *         UtilKFragmentWrapper.onFragmentSaveInstanceState(this, outState, _fragmentMap)
     *         super.onSaveInstanceState(outState)
     *     }
     */
    fun onSaveInstanceState(fragmentActivity: FragmentActivity, outState: Bundle) {
        UtilKFragmentWrapper.onFragmentSaveInstanceState(fragmentActivity, outState, _fragments)
    }

    /**
     *     override fun initView(savedInstanceState: Bundle?) {
     *         _fragmentMap = UtilKFragmentWrapper.onFragmentRestoreInstanceState(this, savedInstanceState, CRouterPath.ROUTE_DISCOVER, CRouterPath.ROUTE_RANKING, CRouterPath.ROUTE_PERSONAL)
     *         //...
     *     }
     */
    fun onFragmentRestoreInstanceState(fragmentActivity: FragmentActivity, savedInstanceState: Bundle?, vararg fragmentKeys: String) {
        _fragments = UtilKFragmentWrapper.onFragmentRestoreInstanceState(fragmentActivity, savedInstanceState, *fragmentKeys)
    }

    fun getFragment(fragmentKey: String): Fragment? =
        _fragments[fragmentKey]

    fun putFragment(fragmentKey: String, fragment: Fragment) {
        _fragments[fragmentKey] = fragment
    }
}