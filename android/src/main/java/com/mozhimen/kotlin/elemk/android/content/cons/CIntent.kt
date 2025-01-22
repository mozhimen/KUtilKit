package com.mozhimen.kotlin.elemk.android.content.cons

import android.content.Intent
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName CIntent
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CIntent {
    const val ACTION_BOOT_COMPLETED = Intent.ACTION_BOOT_COMPLETED
    const val ACTION_PACKAGE_REPLACED = Intent.ACTION_PACKAGE_REPLACED
    const val ACTION_PACKAGE_ADDED = Intent.ACTION_PACKAGE_ADDED
    const val ACTION_PACKAGE_REMOVED = Intent.ACTION_PACKAGE_REMOVED
    const val ACTION_SEND = Intent.ACTION_SEND
    const val ACTION_TIMEZONE_CHANGED = Intent.ACTION_TIMEZONE_CHANGED
    const val ACTION_TIME_TICK = Intent.ACTION_TIME_TICK
    const val ACTION_TIME_CHANGED = Intent.ACTION_TIME_CHANGED
    const val ACTION_PICK = Intent.ACTION_PICK
    const val ACTION_MAIN = Intent.ACTION_MAIN
    const val ACTION_VIEW = Intent.ACTION_VIEW
    const val ACTION_GET_CONTENT = Intent.ACTION_GET_CONTENT

    @RequiresApi(CVersCode.V_21_5_L)
    const val ACTION_OPEN_DOCUMENT_TREE = Intent.ACTION_OPEN_DOCUMENT_TREE

    //////////////////////////////////////////////////////////////////////////

    const val CATEGORY_LAUNCHER = Intent.CATEGORY_LAUNCHER

    //////////////////////////////////////////////////////////////////////////

    const val EXTRA_STREAM = Intent.EXTRA_STREAM
    const val EXTRA_TEXT = Intent.EXTRA_TEXT

    //////////////////////////////////////////////////////////////////////////

    /**
     * 解析intent时打印log messages，展示创建最终的resolved list 找到的信息 。比如有如下代码 ：
     *
     * Intent intent = new Intent(“android.provider.Telephony.SMS_RECEIVED”);
     * intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
     * sendBroadcast(intent);
     */
    const val FLAG_DEBUG_LOG_RESOLUTION = Intent.FLAG_DEBUG_LOG_RESOLUTION

    //临时访问写权限 intent的接受者将被授予 INTENT 数据uri 或者 在ClipData 上的写权限
    const val FLAG_GRANT_WRITE_URI_PERMISSION = Intent.FLAG_GRANT_WRITE_URI_PERMISSION

    //临时访问读权限 intent的接受者将被授予 INTENT 数据uri 或者 在ClipData 上的读权限。
    const val FLAG_GRANT_READ_URI_PERMISSION = Intent.FLAG_GRANT_READ_URI_PERMISSION

    //区别于 FLAG_GRANT_READ_URI_PERMISSION 跟 FLAG_GRANT_WRITE_URI_PERMISSION， URI权限会持久存在即使重启，直到明确的用 revokeUriPermission(Uri, int) 撤销。 这个flag只提供可能持久授权。但是接收的应用必须调用ContentResolver的takePersistableUriPermission(Uri, int)方法实现 。
    const val FLAG_GRANT_PERSISTABLE_URI_PERMISSION = Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION

    //权限授予任何原始授权URI前缀匹配的URI
    @RequiresApi(CVersCode.V_21_5_L)
    const val FLAG_GRANT_PREFIX_URI_PERMISSION = Intent.FLAG_GRANT_PREFIX_URI_PERMISSION

    //指明Intent来自后台操作 ，不是来自用户直接互动。
    const val FLAG_FROM_BACKGROUND = Intent.FLAG_FROM_BACKGROUND

    //通常不是通过应用程序代码设置，而是通过系统如launchMode singleTask模式
    const val FLAG_ACTIVITY_BROUGHT_TO_FRONT = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT

    /**
     * 当设置此标致，并且acitivity已经启动，那么不是启动一个新的activity，所有其他顶部的activity都会关闭，这个intent将被交付到（现在顶部）老的activity 做为新的intent。如果一个task由A,B,C,D组成，如果D调用startActivity（），跳到B, 然后C,D被finish掉，B接收新的intent ，结束栈中：A,B.现在运行的B的实例或者在onNewIntent方法中接收你start的新intent，或者自己finish掉然后重启一个新的intent。如果声明启动了启动模式是“multiple”(默认)，并且你没有在这个intent中设置FLAG_ACTIVITY_SINGLE_TOP，就会finish掉然后重新创建。其他的启动模式。或者FLAG_ACTIVITY_SINGLE_TOP被设置了，intent将会传送到当前实例的onNewIntent方法中。这个启动模式也可以跟FLAG_ACTIVITY_NEW_TASK结合使用：如果用来start根activity，它将会在此task任务当前正在执行的实例bring to foreground，然后清除到跟状态。比如，当从notification manager启动一个activity。
     */
    const val FLAG_ACTIVITY_CLEAR_TOP = Intent.FLAG_ACTIVITY_CLEAR_TOP

    /**
     * 如果设置了，这个Activity将会成为新任务历史栈的开始，如果已经有一个task运行着邀请新的activity，将不会启动新的activity；当前任务栈最后状态将会被展示在屏幕上查看FLAG_ACTIVITY_MULTIPLE_TASK ，关闭这一特性。
     */
    const val FLAG_ACTIVITY_NEW_TASK = Intent.FLAG_ACTIVITY_NEW_TASK

    /**
     * 如果在通过Context.startActivity()启动activity时为Intent设置了此标识，这个标识将导致：任何与此activity相关联的task都会被清除。也就是说， 此activity将变成一个空栈中新的最底端的activity，所有的旧activity都会被finish掉，这个标识仅仅和FLAG_ACTIVITY_NEW_TASK联合起来才能使用
     */
    const val FLAG_ACTIVITY_CLEAR_TASK = Intent.FLAG_ACTIVITY_CLEAR_TASK

    //API21过期，被FLAG_ACTIVITY_NEW_DOCUMENT代替。
    const val FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET

    //如果设置，新的Activity不会在最近启动的Activity的占中保存
    const val FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS

    /**
     * 如果设置，并且这个Intent用于从一个存在的Activity启动一个新的Activity，那么，这个作为答复目标的Activity将会传到这个新的Activity中。这种方式下，新的Activity可以调用setResult(int)，并且这个结果值将发送给那个作为答复目标的Activity。
     */
    const val FLAG_ACTIVITY_FORWARD_RESULT = Intent.FLAG_ACTIVITY_FORWARD_RESULT

    //这个标记通常不由应用程序代码来设置，如果是从历史中启动这个Activity，系统就会设置这个标记(长按home键) 。
    const val FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY

    /**
     * 可以跟FLAG_ACTIVITY_MULTIPLE_TASK结合使用，当只用自己的时候相当于Manifast中android.R.attr.documentLaunchMode=”intoExisting”，当跟FLAG_ACTIVITY_MULTIPLE_TASK结合使用相当于 Manifast中android.R.attr.documentLaunchMode=”always”.
     */
    const val FLAG_ACTIVITY_MULTIPLE_TASK = Intent.FLAG_ACTIVITY_MULTIPLE_TASK

    /**
     * 默认情况FLAG_ACTIVITY_NEW_DOCUMENT创建的document当用户关闭时之前tasks的entry会被remove掉，如果想保持在历史中一遍重新launch，就要用到这个flag.当使task的activity finish掉以后，历史entry将保持在界面以便用户重新打开类似顶级应用程序的历史。
     */
    const val FLAG_ACTIVITY_NEW_DOCUMENT = Intent.FLAG_ACTIVITY_NEW_DOCUMENT

    /**
     * 如果设置，将阻止系统get next activity的过渡动画。并不意味着一直不会有动画，如果另一个activity 的变化发生没有在start activity 显示之前指定，会有过渡动画。
     */
    const val FLAG_ACTIVITY_NO_ANIMATION = Intent.FLAG_ACTIVITY_NO_ANIMATION

    /**
     * 如果设置，新的activity将不会保存在历史栈中。一旦用户离开这个activity，它就会被finish掉。也可以在manifest.xml中设置activity android:hoHistory属性设置。如果设置， OnActivityResult()方法将不会再被调用 。
     */
    const val FLAG_ACTIVITY_NO_HISTORY = Intent.FLAG_ACTIVITY_NO_HISTORY

    /**
     * onUserLeaveHint()作为activity周期的一部分，它在activity因为用户要跳转到别的activity而要退到background时使用。比如,在用户按下Home键，它将被调用。比如有电话进来（不属于用户的选择），它就不会被调用。如果设置，作为新启动的Activity进入前台时，这个标志将在Activity暂停之前阻止从最前方的Activity回调的onUserLeaveHint()。典型的，一个Activity可以依赖这个回调指明显式的用户动作引起的Activity移出后台。这个回调在Activity的生命周期中标记一个合适的点，并关闭一些Notification。 如果一个Activity通过非用户驱动的事件，如来电或闹钟，启动的，这个标志也应该传递给Context.startActivity，保证暂停的Activity不认为用户已经知晓其Notification。
     */
    const val FLAG_ACTIVITY_NO_USER_ACTION = Intent.FLAG_ACTIVITY_NO_USER_ACTION

    /**
     * 如果给Intent对象设置了这个标记，并且这个Intent对象被用于从一个既存的Activity中启动一个新的Activity，这个Activity不被看作决定是否传送新的intent到top而不是start新的，通常认为使用这个flag启动的Activity会被自己立即终止。
     */
    const val FLAG_ACTIVITY_PREVIOUS_IS_TOP = Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP

    /**
     * FLAG_ACTIVITY_RESET_TASK_IF_NEEDED:如果设置该属性，并且这个activity在一个新的task中正在被启动或者被带到一个已经存在的task的顶部，这时这个activity将会被作为这个task的首个页面加载。这将会导致拥有这个应用的affinities的task处于一个合适的状态(移动activity到这个task或者activity从中移出)，或者简单的重置这个task到它的初始状态
     */
    const val FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED

    /**
     * 如果在intent里设置交给 startActivity（）,这个flag会把已经运行过的acivity带到task历史栈的顶端。例如，一个task由A,B,C,D四个activity组成，如果D携带这个flag的intent调用startActivity()打开B，那么B就会被带到历史栈的前部，结果是:A,C,D,B.如果LAG_ACTIVITY_CLEAR_TOP 被设置，那么FLAG_ACTIVITY_REORDER_TO_FRONT将被忽略。
     */
    const val FLAG_ACTIVITY_REORDER_TO_FRONT = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT

    //如果设置了，如过Activity在栈顶将不会启动
    const val FLAG_ACTIVITY_SINGLE_TOP = Intent.FLAG_ACTIVITY_SINGLE_TOP

    /**
     * 把当前新启动的任务置于Home任务之上，也就是按back键从这个任务返回的时候会回到home，即使这个不是他们最后看见的activity，注意这个标记必须和FLAG_ACTIVITY_NEW_TASK一起使用
     */
    const val FLAG_ACTIVITY_TASK_ON_HOME = Intent.FLAG_ACTIVITY_TASK_ON_HOME

    //设置这个flag，发送广播只有动态注册才能调用，组件(xml 中定义action)不会被被launch
    const val FLAG_RECEIVER_REGISTERED_ONLY = Intent.FLAG_RECEIVER_REGISTERED_ONLY
}