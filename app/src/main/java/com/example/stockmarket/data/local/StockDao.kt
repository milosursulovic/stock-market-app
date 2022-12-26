package com.example.stockmarket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(companyListingEntities: List<CompanyListingEntity>)

    @Query("delete from company_listings")
    suspend fun clearCompanyListings()

    @Query(
        """
            select *
            from company_listings
            where lower(name) like '%' || lower(:query) || '%' or upper(:query) == symbol
        """
    )
    suspend fun searchCompanyListing(query: String): List<CompanyListingEntity>
}