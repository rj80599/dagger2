package com.example.mvvmdager2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

//
// 1. here issue is we if mainViewModel class parameter is increase then we have to modify factory class
//
//class ViewModelFactory @Inject constructor(private val repository: ProductRepository,val randomClass: RandomClass) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return MainViewModel(repository,randomClass) as T
//    }
//}

// here issue is as we know to all activities we have to create diff diff viewmodel for these viewmodel
// we have to create diff diff factory(this is the problem) to overcome this problem we used map for viewmodel
//
//class ViewModelFactory @Inject constructor(private val mainViewModel: MainViewModel) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return mainViewModel as T
//    }
//}


// this factory can be single use to all viewmodel present in the application
class ViewModelFactory @Inject constructor(
    private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}