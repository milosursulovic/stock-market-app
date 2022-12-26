package com.example.stockmarket.data.mapper

import com.example.stockmarket.data.local.CompanyListingEntity
import com.example.stockmarket.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing() = CompanyListing(name, symbol, exchange)

fun CompanyListing.toCompanyListingEntity() = CompanyListingEntity(name, symbol, exchange)