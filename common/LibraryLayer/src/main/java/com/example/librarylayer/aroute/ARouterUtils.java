package com.example.librarylayer.aroute;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.librarylayer.BuildConfig;


public class ARouterUtils {

    /**
     * 在activity中添加
     * @param activity              activity_test
     */
    public static void injectActivity(FragmentActivity activity){
        if (activity==null){
            return;
        }
        ARouter.getInstance().inject(activity);
    }

    /**
     * 在fragment中添加
     * @param fragment              fragment
     */
    public static void injectFragment(Fragment fragment){
        if (fragment==null){
            return;
        }
        ARouter.getInstance().inject(fragment);
    }

    public static void initARouter(Application application){
        if (BuildConfig.DEBUG) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        //推荐在Application中初始化
        ARouter.init(application);
    }

    /**
     * 销毁资源
     */
    public static void destroy(){
        ARouter.getInstance().destroy();
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    public static void navigation(String string){
        if (string==null){
            return;
        }
        ARouter.getInstance()
                .build(string)
                .navigation();
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    public static void navigation(String string , String flag){
        if (string==null){
            return;
        }
        ARouter.getInstance()
                .build(string)
                .navigation();
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     */
    public static void navigationGroup(String string , String group){
        if (string==null){
            return;
        }
        ARouter.getInstance()
                .build(string , group)
                .navigation();
    }

    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     * @param callback              监听路由过程
     */
    public static void navigation(String string , Context context , NavigationCallback callback){
        if (string==null){
            return;
        }
        ARouter.getInstance()
                .build(string)
                .navigation(context,callback);
    }


    /**
     * 简单的跳转页面
     * @param uri                   uri
     */
    public static void navigation(Uri uri){
        if (uri==null){
            return;
        }
        ARouter.getInstance()
                .build(uri)
                .navigation();
    }



    /**
     * 简单的跳转页面
     * @param string                string目标界面对应的路径
     * @param bundle                bundle参数
     * @param enterAnim             进入时候动画
     * @param exitAnim              退出动画
     */
    public static void navigation(String string , Bundle bundle, int enterAnim, int exitAnim){
        if (string==null){
            return;
        }
        if (bundle==null){
            ARouter.getInstance()
                    .build(string)
                    .withTransition(enterAnim,exitAnim)
                    .navigation();
        } else {
            ARouter.getInstance()
                    .build(string)
                    .with(bundle)
                    .withTransition(enterAnim,exitAnim)
                    .navigation();
        }
    }



    /**
     * 携带参数跳转页面
     * @param path                  path目标界面对应的路径
     * @param bundle                bundle参数
     */
    public static void navigation(String path , Bundle bundle){
        if (path==null || bundle==null){
            return;
        }
        ARouter.getInstance()
                .build(path)
                .with(bundle)
                .navigation();
    }


    /**
     * 跨模块实现ForResult返回数据（activity中使用）,在fragment中使用不起作用
     * 携带参数跳转页面
     * @param path                  path目标界面对应的路径
     * @param bundle                bundle参数
     */
    public static void navigation(String path , Bundle bundle , Activity context , int code){
        if (path==null){
            return;
        }
        if (bundle==null){
            ARouter.getInstance()
                    .build(path)
                    .navigation(context,code);
        }else {
            ARouter.getInstance()
                    .build(path)
                    .with(bundle)
                    .navigation(context,code);
        }
    }


    /**
     * 使用绿色通道(跳过所有的拦截器)
     * @param path                  path目标界面对应的路径
     * @param green                 是否使用绿色通道
     */
    public static void navigation(String path , boolean green){
        if (path==null){
            return;
        }
        if (green){
            ARouter.getInstance()
                    .build(path)
                    .greenChannel()
                    .navigation();
        }else {
            ARouter.getInstance()
                    .build(path)
                    .navigation();
        }
    }

    private NavigationCallback getCallback(){
        NavigationCallback callback = new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                Log.i("NavigationCallback", "ARouterUtils"+"---跳转完了");
            }

            @Override
            public void onFound(Postcard postcard) {
                super.onFound(postcard);
                Log.i("NavigationCallback", "ARouterUtils"+"---找到了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                Log.i("NavigationCallback", "ARouterUtils"+"---被拦截了");
            }

            @Override
            public void onLost(Postcard postcard) {
                super.onLost(postcard);
                Log.i("NavigationCallback", "ARouterUtils"+"---找不到了");
                //降级处理
                //DegradeServiceImpl degradeService = new DegradeServiceImpl();
                //degradeService.onLost(Utils.getApp(),postcard);

                //无法找到路径，作替换处理
                PathReplaceServiceImpl pathReplaceService = new PathReplaceServiceImpl();
                pathReplaceService.replacePath(RouterConfig.Android.ACTIVITY_ANDROID_ACTIVITY,
                        RouterConfig.DouBan.ACTIVITY_DOU_MUSIC_ACTIVITY);
            }
        };
        return callback;
    }



}
