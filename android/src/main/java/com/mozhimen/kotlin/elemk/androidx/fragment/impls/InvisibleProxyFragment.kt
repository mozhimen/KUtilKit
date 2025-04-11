package com.mozhimen.kotlin.elemk.androidx.fragment.impls

import android.content.Intent
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mozhimen.kotlin.elemk.android.app.cons.CActivity
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.commons.IUtilK

open class InvisibleProxyFragment_ofAndroidx : Fragment(), IUtilK {
    companion object {
        const val REQUEST_CODE_PROXY = 1001

        inline fun <reified T : InvisibleProxyFragment_ofAndroidx> startInvisibleProxyFragment(
            fragmentManager: FragmentManager,
            noinline onAction: IA_Listener<T>,
            onResult: Pair<Int, IAB_Listener<Boolean, Intent?>?>? = null,
            onPermissionResult: Pair<Int, IA_Listener<List<String>?>?>? = null
        ) {
            val existedFragment = fragmentManager.findFragmentByTag("InvisibleProxyFragment>>>>>")
            val invisibleProxyFragment: T = if (existedFragment != null) {
                existedFragment as T
            } else {
                val newFragment = T::class.java.getConstructor().newInstance()
                /**
                 * commitNowAllowingStateLoss(): 这个方法类似于 commitNow()，同样是同步执行的，将事务立即提交并立即执行。与 commitNow() 不同的是，commitNowAllowingStateLoss() 允许在 Activity 状态丢失的情况下提交事务。使用 commitNowAllowingStateLoss() 可以避免在恢复过程中抛出 IllegalStateException 异常。
                 */
                fragmentManager.beginTransaction().add(newFragment, "InvisibleProxyFragment>>>>>").commitNowAllowingStateLoss()
                newFragment
            }
            invisibleProxyFragment.start(onAction, onResult, onPermissionResult)
        }
    }

    ///////////////////////////////////////////////////////////////////////

    protected var _onResultListener: IAB_Listener<Boolean, Intent?>? = null
    protected var _onResultListenerPermission: IA_Listener<List<String>?>? = null
    protected var _requestCode = REQUEST_CODE_PROXY
    protected var _requestCodePermission = REQUEST_CODE_PROXY

    ///////////////////////////////////////////////////////////////////////

    open fun <T : InvisibleProxyFragment_ofAndroidx> start(
        onAction: (fragment: T) -> Unit,
        onResult: Pair<Int, IAB_Listener<Boolean, Intent?>?>? = null,
        onPermissionResult: Pair<Int, IA_Listener<List<String>?>?>? = null
    ) {
        onResult?.let {
            _requestCode = it.first
            _onResultListener = it.second
        }
        onPermissionResult?.let {
            _requestCodePermission = it.first
            _onResultListenerPermission = it.second
        }
        onAction.invoke(this as T)
    }

    ///////////////////////////////////////////////////////////////////////

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UtilKLogWrapper.d(TAG, "onActivityResult: requestCode $requestCode, resultCode $resultCode, data $data")
        if (resultCode == CActivity.RESULT_OK && requestCode == _requestCode) {
            _onResultListener?.invoke(true, data)
            return
        }
        _onResultListener?.invoke(false, data)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == _requestCodePermission) {
            val deniedList = ArrayList<String>()
            for ((position, result) in grantResults.withIndex()) {
                if (result != CPackageManager.PERMISSION_GRANTED)
                    deniedList.add(permissions[position])
            }
            _onResultListenerPermission?.invoke(deniedList)
            return
        }
        _onResultListenerPermission?.invoke(null)
    }
}

open class InvisibleProxyFragment_ofAndroid : android.app.Fragment(), IUtilK {
    companion object {
        const val REQUEST_CODE_PROXY = 1001

        inline fun <reified T : InvisibleProxyFragment_ofAndroid> startInvisibleProxyFragment(
            fragmentManager: android.app.FragmentManager,
            noinline onAction: IA_Listener<T>,
            onResult: Pair<Int, IAB_Listener<Boolean, Intent?>?>? = null,
            onPermissionResult: Pair<Int, IA_Listener<List<String>?>?>? = null
        ) {
            val existedFragment = fragmentManager.findFragmentByTag("InvisibleProxyFragment>>>>>")
            val invisibleProxyFragment: T = if (existedFragment != null) {
                existedFragment as T
            } else {
                val newFragment = T::class.java.getConstructor().newInstance()
                /**
                 * commitNowAllowingStateLoss(): 这个方法类似于 commitNow()，同样是同步执行的，将事务立即提交并立即执行。与 commitNow() 不同的是，commitNowAllowingStateLoss() 允许在 Activity 状态丢失的情况下提交事务。使用 commitNowAllowingStateLoss() 可以避免在恢复过程中抛出 IllegalStateException 异常。
                 */
                if (UtilKBuildVersion.isAfterV_24_7_N()) {
                    fragmentManager.beginTransaction().add(newFragment, "InvisibleProxyFragment>>>>>").commitNowAllowingStateLoss()
                } else {
                    fragmentManager.beginTransaction().add(newFragment, "InvisibleProxyFragment>>>>>").commitAllowingStateLoss()
                }
                newFragment
            }
            invisibleProxyFragment.start(onAction, onResult, onPermissionResult)
        }
    }

    ///////////////////////////////////////////////////////////////////////

    protected var _onResultListener: IAB_Listener<Boolean, Intent?>? = null
    protected var _onResultListenerPermission: IA_Listener<List<String>?>? = null
    protected var _requestCode = REQUEST_CODE_PROXY
    protected var _requestCodePermission = REQUEST_CODE_PROXY

    ///////////////////////////////////////////////////////////////////////

    open fun <T : InvisibleProxyFragment_ofAndroidx> start(
        onAction: (fragment: T) -> Unit,
        onResult: Pair<Int, IAB_Listener<Boolean, Intent?>?>? = null,
        onPermissionResult: Pair<Int, IA_Listener<List<String>?>?>? = null
    ) {
        onResult?.let {
            _requestCode = it.first
            _onResultListener = it.second
        }
        onPermissionResult?.let {
            _requestCodePermission = it.first
            _onResultListenerPermission = it.second
        }
        onAction.invoke(this as T)
    }

    ///////////////////////////////////////////////////////////////////////

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UtilKLogWrapper.d(TAG, "onActivityResult: requestCode $requestCode, resultCode $resultCode, data $data")
        if (resultCode == CActivity.RESULT_OK && requestCode == _requestCode) {
            _onResultListener?.invoke(true, data)
            return
        }
        _onResultListener?.invoke(false, data)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == _requestCodePermission) {
            val deniedList = ArrayList<String>()
            for ((position, result) in grantResults.withIndex()) {
                if (result != CPackageManager.PERMISSION_GRANTED)
                    deniedList.add(permissions[position])
            }
            _onResultListenerPermission?.invoke(deniedList)
            return
        }
        _onResultListenerPermission?.invoke(null)
    }
}