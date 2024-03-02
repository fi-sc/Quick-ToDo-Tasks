package com.example.todomainpage

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavRoutes(
    val route:String,
    val title: String? = null,
    val icon: ImageVector? = null){

    object Home : NavRoutes("Home","Home", Icons.Outlined.Home)
    object Lists : NavRoutes("Search","Lists", Icons.Outlined.Search)
    object Tasks : NavRoutes("CheckCircle","Tasks", Icons.Outlined.CheckCircle)
    object Mood : NavRoutes("Face","Mood", Icons.Outlined.Face)
    object Settings : NavRoutes("Settings","Settings", Icons.Outlined.Settings)

}
