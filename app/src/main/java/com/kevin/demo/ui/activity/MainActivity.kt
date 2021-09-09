package com.kevin.demo.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.kevin.demo.model.BottomBarItemModel
import com.kevin.demo.ui.page.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pagerState = remember {
                mutableStateOf(PagerState(pageCount = 4))
            }

            val items = listOf(
                BottomBarItemModel(label = "首页", icon = Icons.Rounded.Home),
                BottomBarItemModel(label = "收藏", icon = Icons.Rounded.Favorite),
                BottomBarItemModel(label = "购物车", icon = Icons.Rounded.ShoppingCart),
                BottomBarItemModel(label = "我的", icon = Icons.Rounded.AccountCircle)
            )

            Scaffold(
//                topBar = {
//                    TopAppBar(title = { Text(text = "HomePage") })
//                },
                bottomBar = {
                    BottomNavigationAlwaysShowLabelComponent(pagerState.value, items = items)
                },
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.Center,
                content = {
                    HorizontalPager(
                        state = pagerState.value,
                        dragEnabled = false
                    ) { page ->

                        when (page) {
                            0 -> DrawerAppComponent()
                            1 -> FavoritePage()
                            2 -> ShoppingCartPage()
                            3 -> UserPage(this@MainActivity)
                        }
                    }
                })
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun BottomNavigationAlwaysShowLabelComponent(
        pagerState: PagerState,
        items: List<BottomBarItemModel>
    ) {

        val selectedIndex = remember { mutableStateOf(0) }

        val scope = rememberCoroutineScope()

        BottomNavigation(
            modifier = Modifier,
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.primarySurface
        ) {
            items.forEachIndexed { index, item ->

                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = "Favorite")
                    },
                    label = {
                        Text(text = item.label)
                    },
                    selected = selectedIndex.value == index,
                    onClick = {
                        selectedIndex.value = index
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    LoginPage()
//    JetpackComposeDemoTheme {
//        Greeting("Android")
//    }
}
