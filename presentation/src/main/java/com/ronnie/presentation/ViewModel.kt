package com.ronnie.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var number : Int by mutableStateOf(0)
        private set

    fun addNumber(){
        number++
    }
}