package com.todokanai.roompractice.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todokanai.roompractice.repository.UserRepository
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.service.MyService.Companion.userListInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun getAll() = userRepository.getUsers()

    fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    suspend fun deleteAll(){
        userRepository.deleteAll()
    }

    fun mShuffle(){
        var shuffledListInfo = userListInfo.shuffled()
        Log.d("viewmodel","shuffledList: $shuffledListInfo")
        CoroutineScope(Dispatchers.IO).launch {
            deleteAll()
        }.invokeOnCompletion {
            for(index in 1..shuffledListInfo.size){
            insert(shuffledListInfo[index-1])
            }
        }



    }
}