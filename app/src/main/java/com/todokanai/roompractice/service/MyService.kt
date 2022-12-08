package com.todokanai.roompractice.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import com.todokanai.roompractice.application.MyApplication
import com.todokanai.roompractice.repository.UserRepository
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.room.UserDatabase
import com.todokanai.roompractice.service.MyService.Companion.userListInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyService : Service() {

    companion object{
       lateinit var userListInfo : List<User>
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("service","onCreate")
    }
}