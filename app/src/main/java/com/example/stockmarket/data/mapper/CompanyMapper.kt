package com.example.stockmarket.data.mapper

import com.example.stockmarket.data.local.CompanyListingEntity
import com.example.stockmarket.data.remote.dto.CompanyInfoDto
import com.example.stockmarket.domain.model.CompanyInfo
import com.example.stockmarket.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing() = CompanyListing(name, symbol, exchange)

fun CompanyListing.toCompanyListingEntity() = CompanyListingEntity(name, symbol, exchange)

fun CompanyInfoDto.toCompanyInfo() = CompanyInfo(
    symbol = symbol ?: "",
    description = description ?: "",
    name = name ?: "",
    country = country ?: "",
    industry = industry ?: ""
)