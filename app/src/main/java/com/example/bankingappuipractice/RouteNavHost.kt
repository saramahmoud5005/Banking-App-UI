package com.example.bankingappuipractice

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun RootNavHost(paddingValues : PaddingValues,navController: NavHostController){
//    val navController = navController

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ){
        composable(Screen.Home.route){
            HomeScreen()
        }
        composable(Screen.Wallet.route){
            WalletScreen()
        }
        composable(Screen.Notifications.route){
            NotificationsScreen()
        }
        composable(Screen.Account.route){
            AccountScreen()
        }
    }
}