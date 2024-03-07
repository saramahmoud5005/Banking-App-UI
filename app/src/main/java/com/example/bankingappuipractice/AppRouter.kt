package com.example.bankingappuipractice

private object Routes{
    const val HOME = "home"
    const val WALLET = "wallet"
    const val NOTIFICATIONS = "notifications"
    const val ACCOUNT = "account"
}

sealed class Screen(val route:String){
    object Home: Screen(Routes.HOME)
    object Wallet: Screen(Routes.WALLET)
    object Notifications: Screen(Routes.NOTIFICATIONS)
    object Account: Screen(Routes.ACCOUNT)
}