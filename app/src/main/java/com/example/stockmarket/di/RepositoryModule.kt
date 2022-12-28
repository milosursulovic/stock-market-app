package com.example.stockmarket.di

import com.example.stockmarket.data.csv.CSVParser
import com.example.stockmarket.data.csv.CompanyListingsParser
import com.example.stockmarket.data.csv.IntradayInfoParser
import com.example.stockmarket.data.repository.StockRepositoryImpl
import com.example.stockmarket.domain.model.CompanyListing
import com.example.stockmarket.domain.model.IntradayInfo
import com.example.stockmarket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsCompanyListingsParser(companyListingsParser: CompanyListingsParser): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindsIntradayInfoParser(intradayInfoParser: IntradayInfoParser): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindsStockRepository(stockRepository: StockRepositoryImpl): StockRepository
}