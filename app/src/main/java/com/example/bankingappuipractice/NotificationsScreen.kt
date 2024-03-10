package com.example.bankingappuipractice

import android.annotation.SuppressLint
import android.app.Notification
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NotificationsScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NavBar(screenName = "Notifications",Icons.Rounded.Notifications)
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            items(15){
                NotificationsItem("Notification ${it+1}")
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun NotificationsItem(notification:String){
    var isVisible by rememberSaveable{
        mutableStateOf(false)
    }

    var valueDp by remember{
        mutableStateOf(10.dp)
    }

    var iconState by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Column {
        Box (
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = valueDp,
                        bottomEnd = valueDp
                    )
                )
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable {
                    isVisible = !isVisible
                    if (isVisible) {
                        iconState = Icons.Rounded.KeyboardArrowDown
                    } else {
                        iconState = Icons.Rounded.KeyboardArrowUp
                    }
                }
                .width(350.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = notification,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = if(isVisible) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
                    contentDescription = "Arrow",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
        if (isVisible){
            valueDp = 0.dp
            Spacer(modifier = Modifier
                .height(1.dp)
                .background(Color.White))
            BoxWithConstraints(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable {}
                    .width(350.dp)
                    .height(80.dp),
            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                ){
                    Text(
                        text = "Date: 07/03/2024",
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "Time: 10:22",
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "Details: Notification Details",
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                }
            }
        }
        else{
            valueDp = 10.dp
        }
    }
}
