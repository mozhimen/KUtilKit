package com.mozhimen.kotlin.lintk.annors

/**
 * @ClassName PermissionAnnor
 * @Description TODO
 * @Author Kolin Zhao
 * @Version 1.0
 */
@Target(AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class AManifestRequire(
    vararg val permission: String//需要持有的权限
)