package com.example.bankingappui

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bankingappui.data.BottomNavigationItem
import com.example.bankingappuipractice.Screen

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        icon = Icons.Rounded.Home,
        route = Screen.Home.route
    ),
    BottomNavigationItem(
        title = "Wallet",
        icon = Icons.Rounded.Wallet,
        route = Screen.Wallet.route
    ),
    BottomNavigationItem(
        title = "Notifications",
        icon = Icons.Rounded.Notifications,
        route = Screen.Notifications.route
    ),
    BottomNavigationItem(
        title = "Account",
        icon = Icons.Rounded.AccountCircle,
        route = Screen.Account.route
    ),
)

@Composable
fun BottomNavigationBar():NavHostController{

    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    val navController = rememberNavController()

    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == navigationSelectedItem,
                    onClick = {
                        navigationSelectedItem = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
    return navController
}