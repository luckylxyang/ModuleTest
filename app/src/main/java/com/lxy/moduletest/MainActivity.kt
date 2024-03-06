package com.lxy.moduletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.therouter.TheRouter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TheRouter.inject(this)
        setContentView(R.layout.activity_main)
    }
}