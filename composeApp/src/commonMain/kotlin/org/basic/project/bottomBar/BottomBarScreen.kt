package org.basic.project.bottomBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            tab = HomeTabScreen,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(
                        HomeTabScreen,
                        UserTabScreen,
                        MenuTabScreen
                    )
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = it.current.options.title
                            )
                        }
                    )
                },
                bottomBar = {
                    NavigationBar {

                        val tabNavigator: TabNavigator = LocalTabNavigator.current

                        NavigationBarItem(
                            selected = tabNavigator.current.key == HomeTabScreen.key,
                            label = {
                                Text(
                                    text = HomeTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = HomeTabScreen.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                tabNavigator.current = HomeTabScreen
                            }
                        )


                        NavigationBarItem(
                            selected = tabNavigator.current.key == MenuTabScreen.key,
                            label = {
                                Text(
                                    text = MenuTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = MenuTabScreen.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                tabNavigator.current = MenuTabScreen
                            }
                        )


                        NavigationBarItem(
                            selected = tabNavigator.current.key == UserTabScreen.key,
                            label = {
                                Text(
                                    text = UserTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = UserTabScreen.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                tabNavigator.current = UserTabScreen
                            }
                        )
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }

}