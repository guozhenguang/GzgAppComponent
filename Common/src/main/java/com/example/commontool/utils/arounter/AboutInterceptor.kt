package com.example.commontool.utils.arounter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description     比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
 *                  拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
 */
@Interceptor(priority = 1, name = "登录拦截")
class AboutInterceptor : IInterceptor{
    override fun init(context: Context?) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次

    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        //拦截处理
    }
}