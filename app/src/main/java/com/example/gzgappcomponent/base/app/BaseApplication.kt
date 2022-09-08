package com.example.gzgappcomponent.base.app

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.example.librarylayer.aroute.ARouterUtils

/**
 * @author guozhenguang
 * @date 2022/9/8
 * @description
 */
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ARouterUtils.initARouter(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /**
     * 程序终止的时候执行
     */
    override fun onTerminate() {
        Log.d("Application", "onTerminate")
        super.onTerminate()
        ARouterUtils.destroy()
    }

}