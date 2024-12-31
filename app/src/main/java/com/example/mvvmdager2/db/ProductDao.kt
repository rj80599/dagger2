package com.example.mvvmdager2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmdager2.models.Product


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(list: List<Product>)

    @Query("Select * from Product")
    suspend fun getData():List<Product>

}