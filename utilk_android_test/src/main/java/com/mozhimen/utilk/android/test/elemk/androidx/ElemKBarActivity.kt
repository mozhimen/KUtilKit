package com.mozhimen.utilk.android.test.elemk.androidx

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.bindk.bases.activity.databinding.BaseBarActivityVDB
import com.mozhimen.utilk.android.test.R
import com.mozhimen.utilk.android.test.databinding.ActivityElemkBarBinding

/**
 * @ClassName ElemKBarActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/20
 * @Version 1.0
 */
class ElemKBarActivity : BaseBarActivityVDB<ActivityElemkBarBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        setToolbarTitle("标题")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.elemk_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.elemk_back -> {
                "点击了".showToast()
            }
        }
        return true
    }
}