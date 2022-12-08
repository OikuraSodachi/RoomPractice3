package com.todokanai.roompractice.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.todokanai.roompractice.R
import com.todokanai.roompractice.databinding.FragmentMainBinding
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.service.MyService.Companion.userListInfo
import com.todokanai.roompractice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Queue

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        Log.d("MainFragment","onCreateView")

        val insertBtn = binding.insertBtn
        val getBtn = binding.getBtn
        val logBtn = binding.logBtn
        val inputText = binding.inputTest.text

        insertBtn.setOnClickListener { viewModel.insert(User(inputText.toString().toLong(),1)) }
        getBtn.setOnClickListener { Log.d("tester", "Fragment: ${userListInfo}") }
        logBtn.setOnClickListener { viewModel.mShuffle() ; Log.d("Fragment","shuffled")}

        return binding.root
    }
}