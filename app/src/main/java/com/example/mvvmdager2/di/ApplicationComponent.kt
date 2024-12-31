package com.example.mvvmdager2.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.mvvmdager2.ui.MainActivity
import com.example.mvvmdager2.db.RoomModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RoomModule::class, ModelsModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun getMap() : Map<Class<*>,ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}