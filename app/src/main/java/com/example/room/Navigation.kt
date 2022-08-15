package com.example.room

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.room.Screens.AddScreen.AddScreen
import com.example.room.Screens.HomeScreen.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HOME_SCREEN)
    {
        composable(Screen.HOME_SCREEN){ HomeScreen(navController)}
        composable(Screen.ADD_SCREEN){ AddScreen(navController)}
    }
}