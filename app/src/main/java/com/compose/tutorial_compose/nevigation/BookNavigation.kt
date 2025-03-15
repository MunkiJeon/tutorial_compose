package com.compose.tutorial_compose.nevigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.compose.tutorial_compose.screens.confirmed.ConfirmedScreen
import com.compose.tutorial_compose.screens.home.HomeScreen
import com.compose.tutorial_compose.screens.reservation.ReservationScreen
import com.compose.tutorial_compose.userInfo.UserInfoScreen
import java.lang.reflect.Modifier

@Composable
fun BookNavigation(){
    val navController = rememberNavController()//네비게이션을 관리 하는 컨트롤러

    //네비게이션의 컨테이너 역활을 함
    NavHost(
        navController = navController,
        startDestination = BookScreens.UserInfoScreen.name
    ) {
        //Nav Graph
        composable(
            route = BookScreens.HomeScreen.name+"/{name},{phone}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("phone"){type = NavType.StringType},
            ))
        { HomeScreen(navController = navController,modifier = androidx.compose.ui.Modifier, it.arguments?.getString("name"), it.arguments?.getString("phone")) }
        composable(route = BookScreens.UserInfoScreen.name)
        { UserInfoScreen(navController = navController) }
        composable(route = BookScreens.ReservationScreen.name)
        { ReservationScreen(navController = navController) }
        composable(route = BookScreens.ConfirmedScreen.name)
        {ConfirmedScreen(navController = navController)}
    }
}