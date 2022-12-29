package com.example.stockmarket.presentation

sealed class Screen(val route: String) {
    object CompanyListingScreen : Screen("company_listings_screen")
    object CompanyInfoScreen : Screen("company_info_screen")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}