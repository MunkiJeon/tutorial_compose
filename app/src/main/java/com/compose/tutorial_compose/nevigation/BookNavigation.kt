package com.compose.tutorial_compose.nevigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.tutorial_compose.screens.confirmed.ConfirmedScreen
import com.compose.tutorial_compose.screens.home.HomeScreen
import com.compose.tutorial_compose.screens.reservation.ReservationScreen

@Composable
fun BookNavigation(){
    val navController = rememberNavController()//네비게이션을 관리 하는 컨트롤러

    //네비게이션의 컨테이너 역활을 함
    NavHost(
        navController = navController,
        startDestination = BookScreens.HomeScreen.name
    ) {
        composable(route = BookScreens.HomeScreen.name) { HomeScreen(navController = navController) }
        composable(route = BookScreens.ReservationScreen.name) { ReservationScreen(navController = navController) }
        composable(route = BookScreens.ConfirmedScreen.name) {ConfirmedScreen(navController = navController)}
    }
}