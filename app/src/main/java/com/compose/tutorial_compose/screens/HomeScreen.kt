package com.compose.tutorial_compose.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.compose.tutorial_compose.R
import com.compose.tutorial_compose.nevigation.BookScreens

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth() // 화면 가로 최대치 까지 차지
                .align(Alignment.CenterHorizontally), // 내부 컨텐츠 가로 중앙 정렬
            content = {
                Button(onClick = { navController.navigate(BookScreens.ScaffoldUI.name) }) {
                    Text(text = "Scaffold")
                }
                Button(onClick = { navController.navigate(BookScreens.Practice00.name) }) {
                    Text(text = "Practice00")
                }
            }
        )
    }
}