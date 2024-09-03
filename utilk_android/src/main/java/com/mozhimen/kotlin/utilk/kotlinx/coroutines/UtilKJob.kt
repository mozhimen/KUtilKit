package com.mozhimen.kotlin.utilk.kotlinx.coroutines

import android.view.View
import kotlinx.coroutines.Job

/**
 * @ClassName UtilKJob
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun Job.applyAutoDispose(view: View): Job =
    UtilKJob.applyAutoDispose(this, view)

//////////////////////////////////////////////////////////////////
object UtilKJob {
    /**
     * avoid memory leak for View and activity when activity has finished while coroutine is still running
     */
    @JvmStatic
    fun applyAutoDispose(job: Job, view: View): Job {
        val listener = object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View) {
                job.cancel()
                v.removeOnAttachStateChangeListener(this)
            }

            override fun onViewAttachedToWindow(v: View) = Unit
        }
        view.addOnAttachStateChangeListener(listener)
        job.invokeOnCompletion {
            view.removeOnAttachStateChangeListener(listener)
        }
        return job
    }
}