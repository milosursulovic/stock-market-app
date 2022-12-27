package com.example.stockmarket.di

import android.app.Application
import androidx.room.Room
import com.example.stockmarket.BuildConfig
import com.example.stockmarket.data.local.StockDatabase
import com.example.stockmarket.data.remote.StockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesStockApi(): StockApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(StockApi::class.java)

    @Singleton
    @Provides
    fun providesStockDatabase(app: Application): StockDatabase =
        Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            StockDatabase.DATABASE_NAME
        ).build()
}