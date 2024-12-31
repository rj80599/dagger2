package com.example.mvvmdager2.di

import androidx.lifecycle.ViewModel
import com.example.mvvmdager2.viewmodel.MainViewModel
import com.example.mvvmdager2.viewmodel.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
abstract class ModelsModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun getMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun getMainViewModel2(mainViewModel2: MainViewModel2): ViewModel


}