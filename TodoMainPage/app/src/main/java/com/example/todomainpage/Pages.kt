package com.example.todomainpage

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

//for the navigation page

@Composable
fun TodoMainPage(navController: NavHostController) {
    MainPageLayout()
}


@Composable
fun MyListsPage(navController: NavHostController){
   MyLists()
}


@Composable
fun AdditionPage(navController: NavHostController){
    TaskAdditionPage()
}

@Composable
fun MoodsPage(navController: NavHostController){
    MoodsPreview()
}

@Composable
fun SettingsPage(navController: NavHostController){
    SettingsPage()
}