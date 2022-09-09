package com.example.commontool.base.config

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commontool.BuildConfig
import com.example.commontool.utils.log.LogUtils
import com.example.commontool.utils.pool.PoolThreadUtils

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
object AppConfig {

    fun initConfig(application: Application){
        initLog(true)
        initThreadPool()
        initARouter(application)
    }

    private fun initARouter(application: Application) {
        if (BuildConfig.IS_DEBUG) {
            //打印日志
            ARouter.openLog()
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        //推荐在Application中初始化
        ARouter.init(application)
    }

    private fun initLog(printLog: Boolean){
        LogUtils.isPrintLog = printLog
    }

    private fun initThreadPool(){
        PoolThreadUtils.initThreadPool()
    }


}