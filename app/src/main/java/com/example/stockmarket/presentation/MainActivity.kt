package com.example.stockmarket.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.stockmarket.presentation.company_info.CompanyInfoScreen
import com.example.stockmarket.presentation.company_listings.CompanyListingsScreen
import com.example.stockmarket.presentation.ui.theme.StockMarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMarketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CompanyListingScreen.route
                    ) {
                        composable(route = Screen.CompanyListingScreen.route) {
                            CompanyListingsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CompanyInfoScreen.route + "/{symbol}",
                            arguments = listOf(
                                navArgument("symbol") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            CompanyInfoScreen()
                        }
                    }
                }
            }
        }
    }
}