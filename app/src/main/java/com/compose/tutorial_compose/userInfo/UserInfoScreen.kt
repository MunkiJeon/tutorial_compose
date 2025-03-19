package com.compose.tutorial_compose.userInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose.tutorial_compose.nevigation.BookScreens

@Composable
fun  UserInfoScreen(navController: NavController, modifier: Modifier = Modifier) {
    val (name, setName) = remember { mutableStateOf("") }
    val (phone, setPhone) = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "유저 정보 화면 \n 기본 정보를 입력후 [홈 으로] 버튼을 눌러 주세요.")
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { setName(it) },
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text("이름") }
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { setPhone(it) },
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("전화번호") }
        )
        Spacer(modifier = modifier.height(10.dp))
        if (name.isNotEmpty()&&phone.isNotEmpty()){
            Button(onClick = { navController.navigate(BookScreens.HomeScreen.name+"/$name,$phone") }) {
                Text(text = "홈으로")
            }
        }

    }
}

