package com.example.mvvmdager2.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideProductRoomDataBase(context: Context): ProductDataBase {
        return Room.databaseBuilder(context, ProductDataBase::class.java, "ProductDataBase").build()
    }
}