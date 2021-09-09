package com.kevin.demo.ui.page

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kevin.demo.ui.activity.SettingActivity
import com.kevin.jetpack.compose.demo.R

@Composable
fun UserPage(activity: ComponentActivity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Cyan)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp),
                        painter = painterResource(id = R.drawable.bos), contentDescription = ""
                    )
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "细雨带风湿透黄昏的街道")
                        Text(text = "13325648899")
                    }
                }
            }
            LabelItem(leadingIcon = Icons.Filled.PinDrop, title = "我的地址", onClickItem = {})
            LabelItem(leadingIcon = Icons.Filled.Score, title = "我的积分", onClickItem = {})
            LabelItem(leadingIcon = Icons.Filled.Event, title = "我的预约", onClickItem = {})
            LabelItem(leadingIcon = Icons.Filled.Settings, title = "设置", onClickItem = {
                val intent = Intent(activity, SettingActivity::class.java)
                activity.startActivity(intent)
            })
        }
    }
}

@Composable
fun LabelItem(
    leadingIcon: ImageVector,
    title: String,
    onClickItem: () -> Unit
) {
    Column(modifier = Modifier.clickable {
        onClickItem()
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = leadingIcon, contentDescription = "")
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = title)
            }
            Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "")
        }
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    UserPage()
}