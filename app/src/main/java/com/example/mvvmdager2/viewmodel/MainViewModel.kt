package com.example.mvvmdager2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdager2.models.Product
import com.example.mvvmdager2.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository, randomClass: RandomClass) : ViewModel() {

    val productLiveData: LiveData<List<Product>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
        randomClass.doAction()
    }
}

class RandomClass @Inject constructor(){
    fun doAction(){
        Log.d("RandomClass", "doAction: action done")
    }
}