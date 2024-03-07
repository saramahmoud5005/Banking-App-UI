package com.example.bankingappuipractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.R
import com.example.bankingappui.cards
import com.example.bankingappui.ui.theme.PurpleEnd
import com.example.bankingappui.ui.theme.PurpleStart

@Composable
fun CardItemPractice(index:Int){

    var image = painterResource(id = R.drawable.ic_mastercard)
    if(cards[index].cardType=="VISA"){
        image = painterResource(id = R.drawable.ic_visa)
    }

    Spacer(modifier = Modifier.width(10.dp))
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(cards[index].color)
            .clickable {}
    ){
        Column(
            modifier = Modifier
                .width(250.dp)
                .height(170.dp)
                .padding(20.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "Image",
                modifier = Modifier.width(60.dp).height(50.dp)
                    .padding(bottom = 10.dp)
            )
            Text(
                text = cards[index].cardName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "$ ${cards[index].balance}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = cards[index].cardNumber,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardsSectionPractice(){
    LazyRow{
        items(cards.size){
            CardItemPractice(index = it)
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}
