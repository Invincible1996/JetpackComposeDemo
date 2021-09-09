package com.kevin.demo.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable


@Composable
fun CustomTopAppBar(onClickBack: () -> Unit?, title: String) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                onClickBack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        }
    )
}