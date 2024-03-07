package com.example.bankingappuipractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingappui.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NavBar(screenName = "Home", icon = Icons.Rounded.Home)
            Spacer(modifier = Modifier.height(20.dp))
//            WalletSection()
//            CardsSection()
//            Spacer(modifier = Modifier.height(16.dp))
//            FinanceSection()
//            CurrenciesSection()

            WalletSectionPractice()
            CardsSectionPractice()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSectionPractice()
            CurrenciesSectionPractice()
//            AccountScreen()
//            NotificationsScreen()
//            WalletScreen()
        }

}