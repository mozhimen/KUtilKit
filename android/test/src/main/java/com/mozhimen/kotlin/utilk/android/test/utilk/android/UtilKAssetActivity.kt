package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKAssetManager
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkAssetBinding
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrAsset
import com.mozhimen.permissionk.PermissionK
import com.mozhimen.permissionk.annors.APermissionCheck
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.test.BR
import com.mozhimen.kotlin.utilk.android.test.R
import com.mozhimen.kotlin.utilk.android.test.databinding.ItemUtilkFileLogBinding
import com.mozhimen.xmlk.recyclerk.quick.RecyclerKQuickAdapterVDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@APermissionCheck(CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE)
class UtilKAssetActivity : BaseActivityVDB<ActivityUtilkAssetBinding>() {
    private lateinit var _adapterKRecycler: RecyclerKQuickAdapterVDB<com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKFileActivity.UtilKFileLogBean, ItemUtilkFileLogBinding>
    private val _logs = arrayListOf(
        com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKFileActivity.UtilKFileLogBean(0, "start asset file process >>>>>")
    )

    override fun initData(savedInstanceState: Bundle?) {
        PermissionK.requestPermissions(this) {
            if (it) {
                vdb.utilkAssetRecycler.layoutManager = LinearLayoutManager(this)
                _adapterKRecycler = RecyclerKQuickAdapterVDB<com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKFileActivity.UtilKFileLogBean, ItemUtilkFileLogBinding>(
                    _logs,
                    R.layout.item_utilk_file_log,
                    BR.item_utilk_file_log
                )
                vdb.utilkAssetRecycler.adapter = _adapterKRecycler

                super.initData(savedInstanceState)
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        UtilKLogWrapper.d(TAG, "initView: assets ${UtilKAssetManager.get_ofContext(this)}")
        UtilKLogWrapper.d(TAG, "initView: assets ${UtilKAssetManager.get_ofResources(this)}")
        UtilKLogWrapper.d(TAG, "initView: assets ${UtilKAssetManager.get_ofResources(this)==UtilKAssetManager.get_ofContext(this)}")
        UtilKLogWrapper.d(TAG, "initView: assets ${UtilKAssetManager.get_ofResources(this)===UtilKAssetManager.get_ofContext(this)}")

        lifecycleScope.launch(Dispatchers.IO) {
            addLog("isFileExists deviceInfo ${UtilKStrAsset.isAssetExists("deviceInfo")}")
            val file2StrTime = System.currentTimeMillis()
            val file2StrContent = UtilKStrAsset.strAssetName2str_use_ofBufferedReader("deviceInfo")
            addLog("file2Str1 deviceInfo $file2StrContent time ${System.currentTimeMillis() - file2StrTime}")
            val txt2StrTime = System.currentTimeMillis()
            val txt2StrContent = UtilKStrAsset.strAssetName2str_use_ofStream("deviceInfo")
            addLog("file2Str2 deviceInfo $txt2StrContent time ${System.currentTimeMillis() - txt2StrTime}")
            val txt2Str2Time = System.currentTimeMillis()
            val txt2Str2Content = UtilKStrAsset.strAssetName2str_use_ofBytes("deviceInfo")
            addLog("file2Str3 deviceInfo $txt2Str2Content time ${System.currentTimeMillis() - txt2Str2Time}")
            addLog("start copy file")
            val assetCopyFileTime = System.currentTimeMillis()
            val assetCopyFile = UtilKStrAsset.strAssetName2file_use("deviceInfo", this@UtilKAssetActivity.cacheDir.absolutePath + "/utilk_asset/")
            addLog("assetCopyFile deviceInfo path ${assetCopyFile?.absolutePath} time ${System.currentTimeMillis() - assetCopyFileTime}")
        }
    }

    private suspend fun addLog(log: String) {
        withContext(Dispatchers.Main) {
            UtilKLogWrapper.d(TAG, "addLog: log $log")
            _logs.add(com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKFileActivity.UtilKFileLogBean(_logs.size, "$log..."))
            _adapterKRecycler.refreshDatas(_logs)
        }
    }
}