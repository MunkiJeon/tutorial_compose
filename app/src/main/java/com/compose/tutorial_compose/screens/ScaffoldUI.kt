package com.compose.tutorial_compose.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.tutorial_compose.nevigation.BookScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldUI(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    /*
    Android Compose의 Scaffold은 앱의 기본 레이아웃 구조를 제공하는 컴포넌트입니다.
    Scaffold는 Material Design 가이드라인을 따르며,
    앱의 상단 앱바, 하단 탐색 막대, 콘텐츠 영역 등을 설정할 수 있습니다.
    */
    Scaffold(
        /*
        - TopAppBar 상단 앱바
        앱의 제목, 액션 버튼, 메뉴 등을 표시할 수 있는 영역입니다.
        TopAppBar를 사용하여 앱바의 콘텐츠와 동작을 정의할 수 있습니다.
        - BottomAppBar 하단 앱바
        일반적으로 탐색 메뉴나 액션 버튼을 표시하는 데 사용됩니다.
        BottomAppBar를 사용하여 콘텐츠와 동작을 정의할 수 있습니다.
        - FloatingActionButton 플로팅 버튼
        일반적으로 앱에서 가장 중요한 작업을 표시하기 위해 사용됩니다.
        FloatingActionButton을 사용하여 모양과 동작을 정의할 수 있습니다.
        - Content 콘텐츠 영역
        앱의 주요 내용을 표시하는 영역입니다. Content를 사용하여 콘텐츠 영역을 정의할 수 있으며, 보통은 Column이나 Row와 같은 다른 컴포넌트를 사용하여 구성합니다.
        */
        topBar = { // TopBar
            TopAppBar(
                title = { Text(text = "TopAppBar") },
//                backgroundColor = Color.Blue, // 사장된 듯...
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(BookScreens.MainHome.name)
                    }) {//뒤로가기 버튼
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack",
                            tint = Color.White,
                            modifier = modifier.padding(start = 8.dp),
                        )
                    }
                },
                actions = {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            )
        },
        content = { // Content
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Text(text = "Scaffold!")
                Button(onClick = { navController.navigate(BookScreens.MainHome.name) }) {
                    Text(text = "Go Home")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,   // Floating Button
        // floating버튼의 위치를 지정할 수 있습니다. 가능한 위치는 Center와 End입니다.
//        isFloatingActionButtonDocked = false, //?? 왜 안 되는지 몰겠음
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Text(text = "Btn")
            }
        },
        bottomBar = {
            BottomAppBar(
//                backgroundColor = Color.Blue // 사장된 듯...
                containerColor = Color.White,
                contentColor = Color.Black,
                tonalElevation = 10.dp,
                content = {
                    IconButton(onClick = {Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()}) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                    }
                    IconButton(onClick = {Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()}) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                },
            )
        }
    )
}