package com.example.commontool.base.app

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.bumptech.glide.Glide
import com.example.commontool.base.config.AppConfig
import com.example.commontool.utils.arounter.ARouterUtils
import com.example.commontool.utils.log.LogUtils
import com.example.commontool.utils.pool.PoolThreadUtils

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
open class BaseApplication: Application() {

    companion object{
        private const val TAG = "BaseApplication"
    }

    override fun onCreate() {
        super.onCreate()
        AppConfig.initConfig(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /**
     * 程序终止的时候执行
     */
    override fun onTerminate() {
        LogUtils.d(TAG, "onTerminate")
        super.onTerminate()
        PoolThreadUtils.closeExecutor()
        ARouterUtils.destroy()
    }

    /**
     * 低内存的时候执行
     */
    override fun onLowMemory() {
        LogUtils.d(TAG, "onLowMemory")
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    /**
     * HOME键退出应用程序
     * 程序在内存清理的时候执行
     */
    override fun onTrimMemory(level: Int) {
        LogUtils.d(TAG, "onTrimMemory")
        super.onTrimMemory(level)
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory()
        }
        Glide.get(this).trimMemory(level)
    }

}