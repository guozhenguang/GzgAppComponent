package com.example.commontool.utils.pool

import com.example.commontool.utils.log.LogUtils
import com.yc.ycthreadpoollib.callback.ThreadCallback

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
class LogCallback: ThreadCallback {
    companion object{
        private const val TAG = "LogCallback"
    }

    override fun onError(name: String?, t: Throwable?) {
        LogUtils.e(TAG,"LogCallback------onError")
        LogUtils.e(
            TAG,
            String.format("[任务线程$name]/[回调线程${Thread.currentThread()}]--执行失败: ${t?.message}")
        )
    }

    override fun onCompleted(name: String?) {
        LogUtils.d(TAG,"LogCallback------onCompleted")
        LogUtils.d(
            TAG,
            String.format("[任务线程$name]/[回调线程${Thread.currentThread()}]--执行完毕")
        )
    }

    override fun onStart(name: String?) {
        LogUtils.d(TAG,"LogCallback------onStart")
        LogUtils.d(
            TAG,
            String.format("[任务线程$name]/[回调线程${Thread.currentThread()}]--执行开始")
        )
    }
}