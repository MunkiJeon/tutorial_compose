package com.compose.tutorial_compose.nevigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.tutorial_compose.screens.HomeScreen
import com.compose.tutorial_compose.screens.Practice00
import com.compose.tutorial_compose.screens.ScaffoldUI

@Composable
fun BookNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()//네비게이션을 관리 하는 컨트롤러

    //네비게이션의 컨테이너 역활을 함
    NavHost(
        navController = navController,
        startDestination = BookScreens.MainHome.name // 시작 할때 화면
    ) {
        //Nav Graph
        composable(route = BookScreens.MainHome.name)
        { HomeScreen(navController = navController, modifier = modifier) }

        composable(route = BookScreens.ScaffoldUI.name)
        { ScaffoldUI(navController = navController, modifier = modifier) }

        composable(route = BookScreens.Practice00.name)
        { Practice00(navController = navController, modifier = modifier) }

//        //받는곳
//        composable( // 홈에서 데이터 받는 로직
//            //받으려면 매게변수 수정해야 함
//            //fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, name: String?, phone: String?)
//
//            route = BookScreens.MainHome.name+"/{name},{phone}", //이름, 전화번호
//            arguments = listOf(
//                navArgument("name"){type = NavType.StringType},
//                navArgument("phone"){type = NavType.StringType},
//            ))
//        { HomeScreen(navController = navController,modifier = modifier) }

//        //주는곳
//        composable(route = BookScreens.UserInfoScreen.name)
//        { UserInfoScreen(navController = navController) }
//        주는 화면 쪽에 아래 처럼 해야함
//        Button(onClick = { navController.navigate(BookScreens.HomeScreen.name+"/$name,$phone") })
//
//        composable(route = BookScreens.ReservationScreen.name)
//        { ReservationScreen(navController = navController) }
//
//        composable(route = BookScreens.ConfirmedScreen.name)
//        {ConfirmedScreen(navController = navController)}
    }
}