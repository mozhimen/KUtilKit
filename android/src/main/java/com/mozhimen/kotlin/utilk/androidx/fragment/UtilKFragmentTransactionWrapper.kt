package com.mozhimen.kotlin.utilk.androidx.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle

/**
 * @ClassName UtilKFragmentTransactionWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/4/9
 * @Version 1.0
 */
//fun Fragment.runOnViewLifecycleState(state: Lifecycle.State, coroutineContext: CoroutineContext = EmptyCoroutineContext, block: ISuspendExt_Listener<CoroutineScope>) {
//    UtilKFragmentWrapper.runOnViewLifecycleState(this, state, coroutineContext, block)
//}

fun FragmentActivity.addAndHideFragments(currentFragment: Fragment, currentTag: String, lastFragment: Fragment?, lastTag: String?, @IdRes containerViewId: Int) {
    UtilKFragmentTransactionWrapper.addAndHideFragments(this, currentFragment, currentTag, lastFragment, lastTag, containerViewId)
}

fun FragmentActivity.showAndHideFragments(currentFragment: Fragment, currentTag: String, lastFragment: Fragment?, lastTag: String?, @IdRes containerViewId: Int) {
    UtilKFragmentTransactionWrapper.showAndHideFragments(this, currentFragment, currentTag, lastFragment, lastTag, containerViewId)
}

fun FragmentActivity.hideAllFragments(){
    UtilKFragmentTransactionWrapper.hideAllFragments(this)
}

////////////////////////////////////////////////////////////////////

object UtilKFragmentTransactionWrapper {
    /**
     *         //设置容器
     *         var nextFragment: Fragment? = findFragmentByTag(navigateKDes.id)
     *         if (null == nextFragment) {
     *             nextFragment = _fragmentMap[navigateKDes.id] ?: run {
     *                 navigateKDes.onInvokeFragment.invoke().also { _fragmentMap[navigateKDes.id] = it }
     *             }
     *             addHideFragments(nextFragment, navigateKDes.id, lastFragment, _navigateKDes?.id, R.id.main_fragment_container)
     *         } else {
     *             showHideFragments(nextFragment, navigateKDes.id, lastFragment, _navigateKDes?.id, R.id.main_fragment_container)
     *         }
     *         _navigateKDes = navigateKDes
     */
    @JvmStatic
    fun addAndHideFragments(fragmentActivity: FragmentActivity, currentFragment: Fragment, currentTag: String, lastFragment: Fragment?, lastTag: String?, @IdRes containerViewId: Int) {
        val fragmentTransaction = UtilKFragmentTransaction.get(fragmentActivity)
        if (fragmentActivity.findFragmentByTag(currentTag) == null && !currentFragment.isAdded) {
            fragmentTransaction.add(containerViewId, currentFragment, currentTag)
            fragmentTransaction.setMaxLifecycle(currentFragment, Lifecycle.State.RESUMED)
        } else {
            fragmentTransaction.show(currentFragment)
            fragmentTransaction.setMaxLifecycle(currentFragment, Lifecycle.State.RESUMED)
        }
        if (lastFragment != null && lastTag != null && fragmentActivity.findFragmentByTag(lastTag) != null && lastFragment.isAdded) {
            fragmentTransaction.hide(lastFragment)
            fragmentTransaction.setMaxLifecycle(lastFragment, Lifecycle.State.STARTED)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    @JvmStatic
    fun showAndHideFragments(fragmentActivity: FragmentActivity, currentFragment: Fragment, currentTag: String, lastFragment: Fragment?, lastTag: String?, @IdRes containerViewId: Int) {
        val fragmentTransaction = UtilKFragmentTransaction.get(fragmentActivity)
        if (fragmentActivity.findFragmentByTag(currentTag) != null && currentFragment.isAdded) {
            fragmentTransaction.show(currentFragment)
            fragmentTransaction.setMaxLifecycle(currentFragment, Lifecycle.State.RESUMED)
        } else {
            fragmentTransaction.add(containerViewId, currentFragment, currentTag)
            fragmentTransaction.setMaxLifecycle(currentFragment, Lifecycle.State.RESUMED)
        }
        if (lastFragment != null && lastTag != null && fragmentActivity.findFragmentByTag(lastTag) != null && lastFragment.isAdded) {
            fragmentTransaction.hide(lastFragment)
            fragmentTransaction.setMaxLifecycle(lastFragment, Lifecycle.State.STARTED)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    @JvmStatic
    fun hideAllFragments(fragmentActivity: FragmentActivity) {
        val fragmentTransaction = UtilKFragmentTransaction.get(fragmentActivity)
        UtilKFragmentManager.getFragments(fragmentActivity).forEach { f ->
            fragmentTransaction.hide(f)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}