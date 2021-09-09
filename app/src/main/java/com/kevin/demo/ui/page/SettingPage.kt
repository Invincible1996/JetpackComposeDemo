package com.kevin.demo.ui.page

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kevin.demo.ui.activity.SplashActivity
import com.kevin.demo.ui.components.CustomTopAppBar


@Composable
fun SettingPage(activity: ComponentActivity) {
    Scaffold(
        topBar = {
            CustomTopAppBar(onClickBack = {
                activity.finish()
            }, title = "Setting Page")
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Button(onClick = {
                activity.finish();
                activity.startActivity(Intent(activity, SplashActivity::class.java))
            }) {
                Text(text = "Login out")
            }
        }
    }
}