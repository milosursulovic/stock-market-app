package com.example.stockmarket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CompanyListingEntity::class], version = 1, exportSchema = false)
abstract class StockDatabase : RoomDatabase() {
    abstract val dao: StockDao

    companion object {
        const val DATABASE_NAME = "stocks_db"
    }
}