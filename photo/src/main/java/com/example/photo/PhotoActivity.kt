package com.example.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commontool.utils.arounter.ARoutePath
import com.example.commontool.utils.arounter.ARouterUtils

@Route(path = ARoutePath.Photo.PHOTO_ACTIVITY)
class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_layout)
    }
}