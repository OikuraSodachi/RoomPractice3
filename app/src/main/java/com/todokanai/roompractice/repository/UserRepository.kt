package com.todokanai.roompractice.repository

import android.util.Log
import androidx.lifecycle.asLiveData
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.room.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsers() = userDao.getAll().asLiveData()

    suspend fun insert(user : User){
        userDao.insert(user)
       Log.d("repository","inserted")
    }

    suspend fun delete(user : User){
        userDao.delete(user)
    }

    suspend fun deleteAll(){
        userDao.deleteAll()
    }


}