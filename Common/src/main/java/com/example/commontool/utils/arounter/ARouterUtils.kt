package com.example.commontool.utils.arounter

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author guozhenguang
 * @date 2022/9/9
 * @description
 */
object ARouterUtils {

    /**
     * 在activity中添加
     * @param activity
     */
    fun injectActivity(activity: FragmentActivity?) {
        if (activity == null) {
            return
        }
        ARouter.getInstance().inject(activity)
    }

    /**
     * 在fragment中添加
     * @param fragment              fragment
     */
    fun injectFragment(fragment: Fragment?) {
        if (fragment == null) {
            return
        }
        ARouter.getInstance().inject(fragment)
    }

    /**
     * 销毁资源
     */
    fun destroy() {
        ARouter.getInstance().destroy()
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    fun navigation(string: String?) {
        if (string == null) {
            return
        }
        ARouter.getInstance()
            .build(string)
            .navigation()
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    fun navigation(string: String?, flag: String?) {
        if (string == null) {
            return
        }
        ARouter.getInstance()
            .build(string)
            .navigation()
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    fun navigationGroup(string: String?, group: String?) {
        if (string == null) {
            return
        }
        ARouter.getInstance()
            .build(string, group)
            .navigation()
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     * @param callback              监听路由过程
     */
    fun navigation(string: String?, context: Context?, callback: NavigationCallback?) {
        if (string == null) {
            return
        }
        ARouter.getInstance()
            .build(string)
            .navigation(context, callback)
    }


    /**
     * 简单的跳转页面
     * @param uri                   uri
     */
    fun navigation(uri: Uri?) {
        if (uri == null) {
            return
        }
        ARouter.getInstance()
            .build(uri)
            .navigation()
    }


    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     * @param bundle                bundle参数
     * @param enterAnim             进入时候动画
     * @param exitAnim              退出动画
     */
    fun navigation(string: String?, bundle: Bundle?, enterAnim: Int, exitAnim: Int) {
        if (string == null) {
            return
        }
        if (bundle == null) {
            ARouter.getInstance()
                .build(string)
                .withTransition(enterAnim, exitAnim)
                .navigation()
        } else {
            ARouter.getInstance()
                .build(string)
                .with(bundle)
                .withTransition(enterAnim, exitAnim)
                .navigation()
        }
    }


    /**
     * 携带参数跳转页面
     * @param path                  path目标界面对应的路径
     * @param bundle                bundle参数
     */
    fun navigation(path: String?, bundle: Bundle?) {
        if (path == null || bundle == null) {
            return
        }
        ARouter.getInstance()
            .build(path)
            .with(bundle)
            .navigation()
    }


    /**
     * 跨模块实现ForResult返回数据（activity中使用）,在fragment中使用不起作用
     * 携带参数跳转页面
     * @param path                  path目标界面对应的路径
     * @param bundle                bundle参数
     */
    fun navigation(path: String?, bundle: Bundle?, context: Activity?, code: Int) {
        if (path == null) {
            return
        }
        if (bundle == null) {
            ARouter.getInstance()
                .build(path)
                .navigation(context, code)
        } else {
            ARouter.getInstance()
                .build(path)
                .with(bundle)
                .navigation(context, code)
        }
    }


    /**
     * 使用绿色通道(跳过所有的拦截器)
     * @param path                  path目标界面对应的路径
     * @param green                 是否使用绿色通道
     */
    fun navigation(path: String?, green: Boolean) {
        if (path == null) {
            return
        }
        if (green) {
            ARouter.getInstance()
                .build(path)
                .greenChannel()
                .navigation()
        } else {
            ARouter.getInstance()
                .build(path)
                .navigation()
        }
    }
}