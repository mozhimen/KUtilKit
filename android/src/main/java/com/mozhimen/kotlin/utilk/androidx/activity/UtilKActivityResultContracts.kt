package com.mozhimen.kotlin.utilk.androidx.activity

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName UtilKActivityResultContracts
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/27
 * @Version 1.0
 */
object UtilKActivityResultContracts {
    /**
     * 用途：启动一个 Activity 并返回结果。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
     *     if (result.resultCode == Activity.RESULT_OK) {
     *         val data = result.data?.getStringExtra("key")
     *         // 处理返回的数据
     *     }
     * }
     * launcher.launch(Intent(this, TargetActivity::class.java))
     * 说明：这是最常用的 Contract，适用于通用的 Activity 跳转和数据返回场景
     */
    @JvmStatic
    fun get_StartActivityForResult(): ActivityResultContract<Intent, ActivityResult> =
        ActivityResultContracts.StartActivityForResult()

    @JvmStatic
    fun get_StartIntentSenderForResult(): ActivityResultContracts.StartIntentSenderForResult =
        ActivityResultContracts.StartIntentSenderForResult()

    /**
     * 用途：请求多个权限。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
     *     permissions.entries.forEach { (permission, isGranted) ->
     *         if (isGranted) {
     *             // 权限已授予
     *         } else {
     *             // 权限被拒绝
     *         }
     *     }
     * }
     * launcher.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS))
     * 说明：适用于同时请求多个权限的场景
     */
    @JvmStatic
    fun get_RequestMultiplePermissions(): ActivityResultContracts.RequestMultiplePermissions =
        ActivityResultContracts.RequestMultiplePermissions()

    /**
     * 用途：请求单个权限。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
     *     if (isGranted) {
     *         // 权限已授予
     *     } else {
     *         // 权限被拒绝
     *     }
     * }
     * launcher.launch(Manifest.permission.CAMERA)
     * 说明：适用于请求单个运行时权限的场景
     */
    @JvmStatic
    fun get_RequestPermission(): ActivityResultContracts.RequestPermission =
        ActivityResultContracts.RequestPermission()

    /**
     * 用途：拍照并返回预览图（Bitmap）。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
     *     if (bitmap != null) {
     *         // 处理返回的 Bitmap
     *     }
     * }
     * launcher.launch(null)
     * 说明：适用于拍照后直接获取预览图的场景
     */
    @JvmStatic
    fun get_TakePicturePreview(): ActivityResultContracts.TakePicturePreview =
        ActivityResultContracts.TakePicturePreview()

    /**
     * 用途：拍照并将图片保存到指定 URI。
     * 示例：
     * val file = File(externalCacheDir, "photo.jpg")
     * val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", file)
     * val launcher = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
     *     if (isSuccess) {
     *         // 图片保存成功
     *     }
     * }
     * launcher.launch(uri)
     * 说明：适用于拍照后保存图片的场景17。
     */
    @JvmStatic
    fun get_TakePicture(): ActivityResultContracts.TakePicture =
        ActivityResultContracts.TakePicture()

    /**
     * 用途:录制视频并返回缩略图。
     * 示例：
     * val file = File(externalCacheDir, "video.mp4")
     * val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", file)
     * val launcher = registerForActivityResult(ActivityResultContracts.TakeVideo()) { bitmap ->
     *     if (bitmap != null) {
     *         // 处理返回的视频缩略图
     *     }
     * }
     * launcher.launch(uri)
     * 说明：适用于录制视频并获取缩略图的场景
     */
    @JvmStatic
    fun get_TakeVideo(): ActivityResultContracts.TakeVideo =
        ActivityResultContracts.TakeVideo()

    @JvmStatic
    fun get_CaptureVideo(): ActivityResultContracts.CaptureVideo =
        ActivityResultContracts.CaptureVideo()

    /**
     * 用途：从通讯录中选择一个联系人。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.PickContact()) { uri ->
     *     if (uri != null) {
     *         val cursor = contentResolver.query(uri, null, null, null, null)
     *         cursor?.use {
     *             if (it.moveToFirst()) {
     *                 val name = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
     *                 // 处理联系人信息
     *             }
     *         }
     *     }
     * }
     * launcher.launch(null)
     * 说明：适用于从通讯录中选择联系人的场景
     */
    @JvmStatic
    fun get_PickContact(): ActivityResultContracts.PickContact =
        ActivityResultContracts.PickContact()

    /**
     * 用途：选择单个文件并返回其 URI。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
     *     if (uri != null) {
     *         // 处理选择的文件
     *     }
     * }
     * launcher.launch("image/ *")
     * 说明：适用于选择单个文件的场景
     */
    @JvmStatic
    fun get_GetContent(): ActivityResultContracts.GetContent =
        ActivityResultContracts.GetContent()

    @JvmStatic
    fun get_GetMultipleContents(): ActivityResultContracts.GetMultipleContents =
        ActivityResultContracts.GetMultipleContents()

    /**
     * 用途：打开单个文档并返回其 URI。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
     *     if (uri != null) {
     *         // 处理打开的文档
     *     }
     * }
     * launcher.launch(arrayOf("application/pdf"))
     * 说明：适用于打开单个文档的场景
     */
    @JvmStatic
    fun get_OpenDocument(): ActivityResultContracts.OpenDocument =
        ActivityResultContracts.OpenDocument()

    /**
     * 用途：打开多个文档并返回其 URI 列表。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.OpenMultipleDocuments()) { uris ->
     *     uris.forEach { uri ->
     *         // 处理每个文档
     *     }
     * }
     * launcher.launch(arrayOf("image/ *"))
     * 说明：适用于选择多个文件的场景
     */
    @JvmStatic
    fun get_OpenMultipleDocuments(): ActivityResultContracts.OpenMultipleDocuments =
        ActivityResultContracts.OpenMultipleDocuments()

    /**
     * 用途：选择目录并返回其 URI。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->
     *     if (uri != null) {
     *         // 处理选择的目录
     *     }
     * }
     * launcher.launch(null)
     * 说明：适用于选择目录的场景
     */
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_OpenDocumentTree(): ActivityResultContracts.OpenDocumentTree =
        ActivityResultContracts.OpenDocumentTree()

    /**
     * 用途：创建新文档并返回其 URI。
     * 示例：
     * val launcher = registerForActivityResult(ActivityResultContracts.CreateDocument()) { uri ->
     *     if (uri != null) {
     *         // 处理创建的文档
     *     }
     * }
     * launcher.launch("new_file.txt")
     * 说明：适用于创建新文档的场景
     */
    @JvmStatic
    fun get_CreateDocument(): ActivityResultContracts.CreateDocument =
        ActivityResultContracts.CreateDocument()

    /**
     * PickVisualMedia 是 Android 14（API 34）引入的一个新的 ActivityResultContract，用于从设备中选择图片或视频。它是 GetContent 和 OpenDocument 的升级版，专门用于处理视觉媒体（图片和视频）的选择，并且支持更灵活的 MIME 类型过滤。
     * 1. 用途
     * 从设备中选择图片或视频。
     * 支持过滤特定的 MIME 类型（例如只选择图片或只选择视频）。
     * 提供更直观的 API 来处理视觉媒体的选择。
     * 2.2 注册 ActivityResultLauncher
     * 在 Activity 或 Fragment 中注册 PickVisualMedia 的 ActivityResultLauncher。
     *
     * val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
     *     if (uri != null) {
     *         // 处理选择的图片或视频
     *         val inputStream = contentResolver.openInputStream(uri)
     *         // 进一步处理输入流
     *     } else {
     *         // 用户取消了选择
     *     }
     * }
     * 2.3 启动媒体选择器
     * 使用 launch 方法启动媒体选择器，并指定 MIME 类型过滤条件。
     *
     * // 选择图片
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
     *
     * // 选择视频
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly))
     *
     * // 选择图片或视频
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
     *
     * 3. 参数说明
     * 3.1 PickVisualMediaRequest
     * 用于指定选择的媒体类型。
     * 支持以下选项：
     * ImageOnly：仅选择图片。
     * VideoOnly：仅选择视频。
     * ImageAndVideo：选择图片或视频。
     *
     * 3.2 返回值
     * 返回一个 Uri，表示用户选择的媒体文件。
     * 如果用户取消了选择，返回 null。
     *
     * 4. 示例代码
     * 4.1 选择图片
     * kotlin
     * 复制
     * val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
     *     if (uri != null) {
     *         // 显示选择的图片
     *         val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri))
     *         imageView.setImageBitmap(bitmap)
     *     } else {
     *         Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show()
     *     }
     * }
     *
     * // 启动图片选择器
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
     * 4.2 选择视频
     * val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
     *     if (uri != null) {
     *         // 播放选择的视频
     *         videoView.setVideoURI(uri)
     *         videoView.start()
     *     } else {
     *         Toast.makeText(this, "No video selected", Toast.LENGTH_SHORT).show()
     *     }
     * }
     *
     * // 启动视频选择器
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly))
     * 4.3 选择图片或视频
     * val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
     *     if (uri != null) {
     *         val mimeType = contentResolver.getType(uri)
     *         if (mimeType?.startsWith("image/") == true) {
     *             // 处理图片
     *             val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri))
     *             imageView.setImageBitmap(bitmap)
     *         } else if (mimeType?.startsWith("video/") == true) {
     *             // 处理视频
     *             videoView.setVideoURI(uri)
     *             videoView.start()
     *         }
     *     } else {
     *         Toast.makeText(this, "No media selected", Toast.LENGTH_SHORT).show()
     *     }
     * }
     *
     * // 启动媒体选择器
     * pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
     */
    @JvmStatic
    fun get_PickVisualMedia(): ActivityResultContracts.PickVisualMedia =
        ActivityResultContracts.PickVisualMedia()

    @JvmStatic
    fun get_PickMultipleVisualMedia(): ActivityResultContracts.PickMultipleVisualMedia =
        ActivityResultContracts.PickMultipleVisualMedia()
}