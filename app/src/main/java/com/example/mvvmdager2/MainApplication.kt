package com.example.mvvmdager2

import android.app.Application
import com.example.mvvmdager2.di.ApplicationComponent
import com.example.mvvmdager2.di.DaggerApplicationComponent

class MainApplication: Application() {

    lateinit var componet : ApplicationComponent
    override fun onCreate() {
        super.onCreate()

//        componet = DaggerApplicationComponent.builder().build()
        componet = DaggerApplicationComponent.factory().create(this)
    }
}