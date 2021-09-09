package com.kevin.demo.ui.page

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kevin.demo.ui.activity.MainActivity
import com.kevin.jetpack.compose.demo.R


@Composable
fun LoginPage(activity: Activity) {

    val painter = painterResource(id = R.drawable.bos)


    //  账号
    val account = remember {
        mutableStateOf("")
    }

    // 密码
    val password = remember {
        mutableStateOf("")
    }

    // 是否显示密码
    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Boston Celtics",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painter,
                contentDescription = "contentDes",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = account.value,
                onValueChange = { account.value = it },
                singleLine = true,
                label = {
                    Text(text = "account")
                })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "password") },
                singleLine = true,
                keyboardActions = KeyboardActions(onGo = {
                    println(password.value)
                }),

                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(imageVector = Icons.Filled.Visibility, "")
                    }
                },
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    println("account:${account.value} and password : ${password.value}")
//                    navController.navigate("home_page") {
//                        navController.graph.startDestinationId
//                        launchSingleTop = true
//                    }
                    val intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                    activity.finish()
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
            ) {
                Text(text = "Sign In", fontSize = 20.sp)
            }

        }

    }

}
