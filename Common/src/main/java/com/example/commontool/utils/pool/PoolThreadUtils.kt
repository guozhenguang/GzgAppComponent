package com.example.commontool.utils.pool

import com.yc.ycthreadpoollib.PoolThread

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
object PoolThreadUtils {

    private const val TAG = "PoolThreadUtils"
    private var executor : PoolThread? = null

    /**
     * 初始化线程池管理器
     */
    fun initThreadPool() {
        // 创建一个独立的实例进行使用
        if (executor == null) {
            executor = PoolThread.ThreadBuilder
                .createFixed(6)
                .setPriority(Thread.MAX_PRIORITY)
                .setCallback(LogCallback())
                .build()
        }
    }

    /**
     * 获取线程池管理器对象，统一的管理器维护所有的线程池
     * @return                      executor对象
     */
    fun getExecutor(): PoolThread? {
        initThreadPool()
        return executor
    }

    fun closeExecutor() {
        if (executor != null) {
            executor!!.close()
            executor = null
        }
    }
}