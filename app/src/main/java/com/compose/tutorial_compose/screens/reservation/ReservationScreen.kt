package com.compose.tutorial_compose.screens.reservation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReservationScreen(navController: NavController, modifier: Modifier = Modifier) {
    val storeData = listOf(
        "매장 이름: ","힐링쿡 - 용호동점",
        "영업 시간: ","09:00 - 20:00",
        "영업일: ","월, 화, 수, 목, 금, 토",
        "매장 전화번호: ","051) 621-3700",
        "매장 주소: ", "부산 남구 용호동 197"
    )

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
    ){
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp)
                .background(Color.Red)
        ) {
            Log.d("storeData", "${storeData.size}")
            for (i in 0..storeData.size-1 step 2) {
                Log.d("storeData", "${i}: ${storeData[i]}")
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                ){
                    Text(text = "${storeData[i]}")
                    Text(text = "${storeData[i+1]}")
                }
            }
        }
        Text(text = "예약 화면")
    }
}