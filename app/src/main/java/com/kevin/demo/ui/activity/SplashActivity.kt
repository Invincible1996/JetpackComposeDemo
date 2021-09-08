package com.kevin.demo.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.kevin.demo.ui.page.LoginPage

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApplication(this)
        }
    }
}

@Composable
fun LoginApplication(activity: ComponentActivity) {

    val navController = rememberNavController()
    LoginPage(activity = activity)
//    NavHost(navController = navController, startDestination = "login_page", builder = {
//        composable("login_page", content = { LoginPage(navController, activity) })
//        composable("home_page",
//            content = { HomePage(navController) })
//    })
}