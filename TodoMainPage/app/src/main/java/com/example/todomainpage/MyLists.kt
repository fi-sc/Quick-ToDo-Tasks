package com.example.todomainpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todomainpage.ui.theme.EagleLake
import com.example.todomainpage.ui.theme.LightBlue
import com.example.todomainpage.ui.theme.Pink
import com.example.todomainpage.ui.theme.Purple


@Composable
fun MyLists(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(2.dp)

    ) {
        Text(text = "My Lists", style = TextStyle(fontFamily = EagleLake), fontSize = 18.sp)

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {

            //todays tasks
            Row(
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Today's Tasks", style = TextStyle(fontFamily = EagleLake))

                //box
                val customGradientColors = listOf(LightBlue, Purple)
                GradientBox(
                    textOfButton = "Add Tasks",
                    gradientColors = customGradientColors
                )
            }

            GradientDividers()

            //upcoming tasks
            Row(
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Upcoming Tasks", style = TextStyle(fontFamily = EagleLake))

                //box
                val customGradientColors = listOf(Purple, Pink)
                GradientBox(
                    textOfButton = "Add Tasks",
                    gradientColors = customGradientColors
                )
            }

            GradientDividers()

            //Completed Tasks
            Row(
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Completed Tasks",style = TextStyle(fontFamily = EagleLake))

                //box
                val customGradientColors = listOf(Pink,LightBlue)
                GradientBox(
                    textOfButton = "View All",
                    gradientColors = customGradientColors
                )

            }
            GradientDividers()


        }
    }
}