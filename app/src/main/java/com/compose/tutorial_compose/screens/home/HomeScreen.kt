package com.compose.tutorial_compose.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.compose.tutorial_compose.nevigation.BookScreens

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, name: String?, phone: String?) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "홈 화면")
        Text(text = "이름 : $name")
        Text(text = "전화번호 : $phone")
        Button(onClick = { navController.navigate(BookScreens.ReservationScreen.name) }) {
            Text(text = "예약 화면")
        }
        Button(onClick = { navController.navigate(BookScreens.ConfirmedScreen.name) }) {
            Text(text = "예약 확정 화면")
        }
    }
}