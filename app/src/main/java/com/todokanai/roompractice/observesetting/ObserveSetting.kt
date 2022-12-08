package com.todokanai.roompractice.observesetting

import android.util.Log
import com.todokanai.roompractice.application.MyApplication
import com.todokanai.roompractice.repository.UserRepository
import com.todokanai.roompractice.room.UserDatabase
import com.todokanai.roompractice.service.MyService

class ObserveSetting {
    private val myContext = MyApplication.appContext
    private val userDatabase = UserDatabase.getInstance(myContext)

    fun initObserver(){
        userListInfo()

    }

    private fun userListInfo(){
        UserRepository(userDatabase.userDao()).getUsers().observeForever(){
            MyService.userListInfo = it
            Log.d("observeForever","userListInfo: ${MyService.userListInfo}")
        }
    }
}