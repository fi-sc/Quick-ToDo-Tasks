package com.example.todomainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todomainpage.ui.theme.TodoMainPageTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoMainPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {
                        TodoMainPagePreview()

                }
            }
        }
    }




    //navigation for the add tasks
    @Composable
    fun SetupNavigation() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "viewListPage"
        ) {
            composable("viewListPage") {
                ViewListPage(navController = navController)
            }
            composable("taskAdditionPage") {
                TaskAdditionPage()
            }
        }
    }


    //for navigation
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
            composable(NavRoutes.Home.route) {
                TodoMainPage(navController = navController)
            }

            composable(NavRoutes.Lists.route) {
                MyListsPage(navController = navController)
            }

            composable(NavRoutes.Tasks.route) {
                AdditionPage(navController = navController)
            }

            composable(NavRoutes.Mood.route) {
                MoodsPage(navController = navController)
            }

            composable(NavRoutes.Settings.route) {
                SettingsPage(navController = navController)
            }

        }
    }




    @Composable
    @Preview(showBackground = true, showSystemUi = true)
    fun TodoMainPagePreview() {

            //each page that the navigation will display
            val pages = listOf(
                NavRoutes.Home,
                NavRoutes.Lists,
                NavRoutes.Tasks,
                NavRoutes.Mood,
                NavRoutes.Settings
            )
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    Column {

                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.background,
                            actions = {
                                //loops through the above list of pages
                                NavigationBar {
                                    pages.forEach { page ->
                                        NavigationBarItem(
                                            selected = true,
                                            onClick = { navController.navigate(page.route) },
                                            label = {
                                                Text(
                                                    text = page.title!!
                                                )
                                            },
                                            icon = {
                                                Icon(
                                                    imageVector = page.icon!!,
                                                    contentDescription = "${page.title} Icon",
                                                )
                                            })
                                    }
                                }

                            },
                        )
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    Navigation(navController = navController)
                }
            }
        }

}



/*
scroll page
if check button pressed == task moves to completed column
oder tasks by time
    today's tasks: today
    upcoming tasks: not today
    completed: checked
if add tasks/view all pressed == change page
 */
