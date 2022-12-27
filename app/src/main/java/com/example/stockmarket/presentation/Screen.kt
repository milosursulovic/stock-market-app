package com.example.stockmarket.presentation

sealed class Screen(val route: String) {
    object CompanyListingScreen : Screen("company_listings_screen")
    object CompanyInfoScreen : Screen("company_info_screen")
}