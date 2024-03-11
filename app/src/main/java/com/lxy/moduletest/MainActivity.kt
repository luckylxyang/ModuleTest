package com.lxy.moduletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lxy.moduletest.databinding.ActivityMainBinding
import com.therouter.TheRouter

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TheRouter.inject(this)
        setContentView(binding.root)

        binding.tv.setOnClickListener {
//            startActivity(Intent(this, MapActivity::class.java))
            TheRouter.build("map").navigation();
        }
    }
}