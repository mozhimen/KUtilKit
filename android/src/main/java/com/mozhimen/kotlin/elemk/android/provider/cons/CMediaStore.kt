package com.mozhimen.kotlin.elemk.android.provider.cons

import android.provider.MediaStore

/**
 * @ClassName MediaStore
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CMediaStore {
    const val ACTION_IMAGE_CAPTURE = MediaStore.ACTION_IMAGE_CAPTURE
    const val EXTRA_OUTPUT = MediaStore.EXTRA_OUTPUT

    object Type {
        const val VIDEO = "video"
        const val AUDIO = "audio"
        const val IMAGE = "image"
        const val PRIMARY = "primary"
        const val RAW = "raw"
    }

    object Images {
        object Media {
            val EXTERNAL_CONTENT_URI get() = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val DATA get() = MediaStore.Images.Media.DATA
        }

        object ImageColumns {
            val DATA get() = MediaStore.Images.ImageColumns.DATA
            val DISPLAY_NAME get() = MediaStore.Images.ImageColumns.DISPLAY_NAME
            val MIME_TYPE get() = MediaStore.Images.ImageColumns.MIME_TYPE
            val DATE_TAKEN get() = MediaStore.Images.ImageColumns.DATE_TAKEN
        }
    }

    object Video {
        object Media {
            val EXTERNAL_CONTENT_URI get() = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }
    }

    object Audio {
        object Media {
            val EXTERNAL_CONTENT_URI get() = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        }
    }

    object Files {
        object FileColumns {
            const val DATA = MediaStore.Files.FileColumns.DATA
        }
    }

    object MediaColumns {
        const val DATA = MediaStore.MediaColumns.DATA
        const val _ID = MediaStore.MediaColumns._ID
    }
}