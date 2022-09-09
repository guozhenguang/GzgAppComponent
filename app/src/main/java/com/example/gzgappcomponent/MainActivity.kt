package com.example.gzgappcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commontool.utils.arounter.ARoutePath

@Route(path = ARoutePath.App.APP_ACTIVITY)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener {
            ARouter.getInstance().build(ARoutePath.Photo.PHOTO_ACTIVITY).navigation()
        }
    }
}