package com.mozhimen.kotlin.utilk.androidx.activity

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode


/**
 * @ClassName UtilKComponentActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/20
 * @Version 1.0
 */
object UtilKComponentActivity {
    @JvmStatic
    fun <I, O> registerForActivityResult(
        componentActivity: ComponentActivity,
        contract: ActivityResultContract<I, O>,
        callback: ActivityResultCallback<O>
    ): ActivityResultLauncher<I> =
        componentActivity.registerForActivityResult(contract, callback)

    ////////////////////////////////////////////////////////////////////

    //启动一个 Activity 并返回结果。
    @JvmStatic
    fun registerForActivityResult_StartActivityForResult(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<ActivityResult?>
    ): ActivityResultLauncher<Intent> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_StartActivityForResult(), callback)

    @JvmStatic
    fun registerForActivityResult_StartIntentSenderForResult(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<ActivityResult?>
    ): ActivityResultLauncher<IntentSenderRequest> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_StartIntentSenderForResult(), callback)

    //请求多个权限。
    @JvmStatic
    fun registerForActivityResult_RequestMultiplePermissions(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Map<String, @JvmSuppressWildcards Boolean>?>
    ): ActivityResultLauncher<Array<String>> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_RequestMultiplePermissions(), callback)

    //请求单个权限
    @JvmStatic
    fun registerForActivityResult_RequestPermission(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Boolean?>
    ): ActivityResultLauncher<String> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_RequestPermission(), callback)

    //拍照并返回预览图（Bitmap）。
    @JvmStatic
    fun registerForActivityResult_TakePicturePreview(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Bitmap?>
    ): ActivityResultLauncher<Void?> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_TakePicturePreview(), callback)

    //用途：拍照并将图片保存到指定 URI。
    @JvmStatic
    fun registerForActivityResult_TakePicture(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Boolean?>
    ): ActivityResultLauncher<Uri> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_TakePicture(), callback)

    //用途:录制视频并返回缩略图。
    @JvmStatic
    fun registerForActivityResult_TakeVideo(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Bitmap?>
    ): ActivityResultLauncher<Uri> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_TakeVideo(), callback)

    @JvmStatic
    fun registerForActivityResult_CaptureVideo(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Boolean?>
    ): ActivityResultLauncher<Uri> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_CaptureVideo(), callback)

    //从通讯录中选择一个联系人
    @JvmStatic
    fun registerForActivityResult_PickContact(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<Void?> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_PickContact(), callback)

    //选择单个文件并返回其 URI。
    @JvmStatic
    fun registerForActivityResult_GetContent(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<String> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_GetContent(), callback)

    @JvmStatic
    fun registerForActivityResult_GetMultipleContents(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<List<@JvmSuppressWildcards Uri>?>
    ): ActivityResultLauncher<String> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_GetMultipleContents(), callback)

    //打开单个文档并返回其 URI。
    @JvmStatic
    fun registerForActivityResult_OpenDocument(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<Array<String>> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_OpenDocument(), callback)

    //打开多个文档并返回其 URI 列表。
    @JvmStatic
    fun registerForActivityResult_OpenMultipleDocuments(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<List<@JvmSuppressWildcards Uri>?>
    ): ActivityResultLauncher<Array<String>> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_OpenMultipleDocuments(), callback)

    //选择目录并返回其 URI。
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun registerForActivityResult_OpenDocumentTree(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<Uri?> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_OpenDocumentTree(), callback)

    //创建新文档并返回其 URI。
    @JvmStatic
    fun registerForActivityResult_CreateDocument(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<String> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_CreateDocument(), callback)

    @JvmStatic
    fun registerForActivityResult_PickVisualMedia(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<Uri?>
    ): ActivityResultLauncher<PickVisualMediaRequest> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_PickVisualMedia(), callback)

    @JvmStatic
    fun registerForActivityResult_PickMultipleVisualMedia(
        componentActivity: ComponentActivity,
        callback: ActivityResultCallback<List<@JvmSuppressWildcards Uri>?>
    ): ActivityResultLauncher<PickVisualMediaRequest> =
        componentActivity.registerForActivityResult(UtilKActivityResultContracts.get_PickMultipleVisualMedia(), callback)

}