package com.example.mvvmdager2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdager2.MainApplication
import com.example.mvvmdager2.ui.theme.MVVMDager2Theme
import com.example.mvvmdager2.viewmodel.MainViewModel
import com.example.mvvmdager2.viewmodel.ViewModelFactory
import javax.inject.Inject

// dagger2 example with mvvm pattern with remote and local dataBase connection with repository

// MainActivity <--- ViewModel <--- Repository <--- 1. Retrofit 2. RoomDB

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelProviderFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as MainApplication).componet.inject(this)

        mainViewModel =
            ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java] // here pass the viewmodel which object is required

        setContent {
            MVVMDager2Theme {
                ProductScreen(mainViewModel = mainViewModel)
            }
        }
    }
}
