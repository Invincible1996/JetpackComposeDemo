package com.kevin.demo.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ShoppingCartPage() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "ShoppingCartPage") })
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Text(text = "ShoppingCart Page")
        }
    }
}