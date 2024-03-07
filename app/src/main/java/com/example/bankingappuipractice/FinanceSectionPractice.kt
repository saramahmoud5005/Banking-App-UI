package com.example.bankingappuipractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.financeList

@Composable
fun FinanceItemPractice(index:Int){
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .width(140.dp)
            .height(140.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ){
        Column (
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(40.dp)
                    .height(40.dp)
                    .background(financeList[index].background)
            ) {
                Icon(
                    imageVector = financeList[index].icon,
                    contentDescription = financeList[index].name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(7.dp)
                )
            }
            Text(
                text = financeList[index].name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 25.dp)
            )
        }
    }
}

@Composable
fun FinanceSectionPractice(){
    Spacer(modifier = Modifier.width(10.dp))
    Column (
        modifier = Modifier.padding(start = 10.dp)
    ){
        Text(
            text = "Finance",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow{
            items(financeList.size){
                FinanceItemPractice(index = it)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }

}