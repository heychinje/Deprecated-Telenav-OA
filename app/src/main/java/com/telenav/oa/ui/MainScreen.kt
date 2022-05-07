package com.telenav.oa.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.telenav.oa.ui.theme.TelenavOATheme
import com.telenav.oa.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    navHostController: NavHostController,
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    NavHost(navController = navHostController, startDestination = "LoginScreen"){
        composable("LoginScreen"){ LoginScreen()}
        composable("HomeScreen"){ LoginScreen()}
    }

    Box {
        if (mainScreenViewModel.isLogin.value == true) {
            HomeScreen()
        } else {
            LoginScreen()
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    TelenavOATheme {
//        MainScreen()
    }
}

