package com.example.mvvmdager2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmdager2.models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDataBase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao

}