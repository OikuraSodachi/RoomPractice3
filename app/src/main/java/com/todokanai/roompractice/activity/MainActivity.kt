package com.todokanai.roompractice.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.todokanai.roompractice.service.MyService
import com.todokanai.roompractice.R
import com.todokanai.roompractice.observesetting.ObserveSetting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreate")

        ObserveSetting().initObserver()

        val intentService = Intent(this, MyService::class.java)
        startService(intentService)    //----- 서비스 개시

    }
}