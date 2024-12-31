package com.example.mvvmdager2.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val randomClass: RandomClass) : ViewModel() {

    init {
        randomClass.doAction()
    }
}