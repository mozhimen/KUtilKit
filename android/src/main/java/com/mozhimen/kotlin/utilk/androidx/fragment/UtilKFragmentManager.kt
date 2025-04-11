package com.mozhimen.kotlin.utilk.androidx.fragment

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKFragmentManager
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/22 22:19
 * @Version 1.0
 */
fun FragmentActivity.findFragmentById(@IdRes intResId: Int): Fragment? =
    UtilKFragmentManager.findFragmentById(this, intResId)

fun FragmentActivity.findFragmentByTag(tag: String): Fragment? =
    UtilKFragmentManager.findFragmentByTag(this, tag)

/////////////////////////////////////////////////////////////////////

object UtilKFragmentManager : IUtilK {
    @JvmStatic
    fun get_support(fragmentActivity: FragmentActivity): FragmentManager =
        UtilKFragmentActivity.getSupportFragmentManager(fragmentActivity)

    @JvmStatic
    fun get_child(fragment: Fragment): FragmentManager =
        UtilKFragment.getChildFragmentManager(fragment)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun findFragmentByTag(fragmentActivity: FragmentActivity, tag: String): Fragment? =
        get_support(fragmentActivity).findFragmentByTag(tag)

    @JvmStatic
    fun findFragmentByTag(fragment: Fragment, tag: String): Fragment? =
        get_child(fragment).findFragmentByTag(tag)

    @JvmStatic
    fun findFragmentById(fragmentActivity: FragmentActivity, @IdRes intResId: Int): Fragment? =
        get_support(fragmentActivity).findFragmentById(intResId)

    @JvmStatic
    fun findFragmentById(fragment: Fragment, @IdRes intResId: Int): Fragment? =
        get_child(fragment).findFragmentById(intResId)

    @JvmStatic
    fun beginTransaction(fragmentActivity: FragmentActivity): FragmentTransaction =
        get_support(fragmentActivity).beginTransaction()

    @JvmStatic
    fun beginTransaction(fragment: Fragment): FragmentTransaction =
        get_child(fragment).beginTransaction()

    @JvmStatic
    fun putFragment(fragmentActivity: FragmentActivity, bundle: Bundle, key: String, fragment: Fragment) {
        get_support(fragmentActivity).putFragment(bundle, key, fragment)
    }

    @JvmStatic
    fun putFragment(fragment: Fragment, bundle: Bundle, key: String, fragment1: Fragment) {
        get_child(fragment).putFragment(bundle, key, fragment1)
    }

    @JvmStatic
    fun getFragment(fragmentActivity: FragmentActivity, bundle: Bundle, key: String): Fragment? =
        get_support(fragmentActivity).getFragment(bundle, key)

    @JvmStatic
    fun getFragment(fragment: Fragment, bundle: Bundle, key: String): Fragment? =
        get_child(fragment).getFragment(bundle, key)

    @JvmStatic
    fun getFragments(fragmentActivity: FragmentActivity): List<Fragment> =
        get_support(fragmentActivity).fragments

    @JvmStatic
    fun getFragments(fragment: Fragment): List<Fragment> =
        get_child(fragment).fragments
}