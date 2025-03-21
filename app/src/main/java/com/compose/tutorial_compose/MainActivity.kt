package com.compose.tutorial_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.compose.tutorial_compose.nevigation.BookNavigation
import com.compose.tutorial_compose.ui.theme.Tutorial_composeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tutorial_composeTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                Scaffold(
                    bottomBar = { BasicBottomAppBar() },
//                    topBar = { BasicTopAppBar() },
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                ) { innerPadding ->
                    innerPadding
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                    ) {
                        Text(text = "Hello World!",)
                        BookNavigation()
                    }
//                    Screen()
                }
//                Screen()
//                Greeting("Android")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen(modifier: Modifier = Modifier) {
    //클릭커 영역
    val (clicks, setClicks) = remember { mutableStateOf(0) }
    //약관 전체 동의 : TriStateCheckbox
    val allChecked = remember { mutableStateListOf(false, false, false) }
    val textLists = listOf("이용약관 동의", "개인정보 수집 동의", "광고 수신 동의", "위치 기반 서비스 약관 동의")
    var parentState = when {
        allChecked.all { it } -> ToggleableState.On     // 전체 다 선택 했을 때
        allChecked.none { it } -> ToggleableState.Off   // 전체 다 선택 안했을 때
        else -> ToggleableState.Indeterminate           // 일부만 선택된 경우
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp)
    ) {
        Text(
            "Total Clicks: $clicks",
            fontSize = 32.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { setClicks(clicks + 1) },
                modifier = modifier.padding(horizontal = 10.dp)
            ) {
                Text("Click Me +", fontSize = 24.sp)
            }
            Button(
                onClick = { setClicks(clicks - 1) },
                modifier = modifier.padding(horizontal = 10.dp)
            ) {
                Text("Click Me -", fontSize = 24.sp)
            }
        }
        Spacer(modifier = modifier.height(40.dp))
        //환전 영역
        val (usd, setUsd) = remember { mutableStateOf("") }
        OutlinedTextField(
            value = usd,
            onValueChange = { setUsd(it) },
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("US Dollar") }
        )
        Spacer(modifier = modifier.height(10.dp))

        if (usd.isNotEmpty()) Text("$usd USD is \n ${usd.toInt() * 1230} KRW", fontSize = 24.sp)

        //coil 라이브러리 : 웹/ 서버의 이미지를 비동기 적으로 가져옴
        AsyncImage(
//            model = "https://cdn.pixabay.com/photo/2024/09/08/20/30/architecture-9033164_1280.jpg", //coil 방식
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://cdn.pixabay.com/photo/2024/09/08/20/30/architecture-9033164_1280.jpg")
                .crossfade(2000)//정해진 시간 동안 이미지를 천천히 띄워줌
                .transformations(CircleCropTransformation()) //이미지 변형
                .build(),
            contentDescription = "이미지 임",
            error = painterResource(R.drawable.blackcow_what),//애러 떳을 때 이미지 띄워줌
            placeholder = painterResource(R.drawable.blackcow_what),//이미지 로드 전에 띄워줄 이미지
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = modifier.height(10.dp))

        //약관 전체 동의 : TriStateCheckbox
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "전체 동의", fontSize = 24.sp)
            TriStateCheckbox(//전체 동의 체크 박스
                state = parentState,
                onClick = {
                    val newState = if (parentState != ToggleableState.On) {
                        true
                    } else {
                        false
                    }
                    allChecked.forEachIndexed { index, _ ->
                        allChecked[index] = newState
                    }
                }
            )
        }
        allChecked.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "${textLists[index]}", fontSize = 24.sp
                )
                Checkbox(// 체크박스 하나하나의 값
                    checked = checked,
                    onCheckedChange = { it ->
                        allChecked[index] = it
                    }
                )
            }
        }
        Spacer(modifier = modifier.height(10.dp))

        //BadgedBox 장바구니 옆 숫자
        BadgedBox(
            badge = {
                if (clicks >= 1) {//클릭한 수량이 1 이상 일때만 나옴
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White,
                    ) {
                        Text("${clicks}")
                    }
                }
            }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "장바구니",
                modifier = modifier.size(24.dp)
            )
        }
        Spacer(modifier = modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = modifier.padding(horizontal = 10.dp)
        ) {
            Text("next page", fontSize = 24.sp)
        }
    }
}

//BottomAppBar / DropdownMenu
@Composable
fun BasicBottomAppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var isShow = remember { mutableStateOf(false) }
    if (isShow.value) {
        BasicDropdownMenu()
    }

    BottomAppBar(
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon",
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Icon",
                )
            }
        },
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        containerColor = MaterialTheme.colorScheme.surface,

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isShow.value = !isShow.value
                }
            ){
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "FloatingActionButton",
                )
            }
        }
        )
}
@Composable
fun BasicDropdownMenu(modifier: Modifier = Modifier) {
    val items = listOf("A", "B", "C", "D", "E", "F")
    var expanded by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomEnd)//화면의 오른쪽 아래에 정렬
    ) {
        DropdownMenu(
            expanded = expanded, // 처음에 닫혀 있을지
            onDismissRequest = { expanded = false } //드롭다운 밖을 누르면 닫힘

        ){
            items.forEachIndexed { index, text ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                    },
                    text = {
                        Text(text = text)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTopAppBar(modifier: Modifier = Modifier) {
    val isDetail = remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = "BasicTopAppBar")
        },
//        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan),
        actions = {
            IconButton(onClick = {
                isDetail.value = !isDetail.value
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                )
            }
        },
        navigationIcon = {
            if (isDetail.value) {
                IconButton(onClick = {
                    isDetail.value = !isDetail.value
                }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                    )
                }
            } else {
                Box {}
            }

        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Composable //초기 code
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    Tutorial_composeTheme {
        Screen()
//        Greeting("Android") //초기 code
    }
}
