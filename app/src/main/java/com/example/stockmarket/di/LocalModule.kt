package com.example.stockmarket.di

import android.app.Application
import androidx.room.Room
import com.example.stockmarket.data.local.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun providesStockDatabase(app: Application): StockDatabase =
        Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            StockDatabase.DATABASE_NAME
        ).build()
}