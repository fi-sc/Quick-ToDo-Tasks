package com.example.todomainpage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todomainpage.ui.theme.EagleLake
import com.example.todomainpage.ui.theme.LightBlue
import com.example.todomainpage.ui.theme.Paprika
import com.example.todomainpage.ui.theme.Pink
import com.example.todomainpage.ui.theme.Purple
import com.example.todomainpage.ui.theme.White


@Composable
fun MainPageLayout() {
    val tasks = listOf(
        "Walk the dog",
        "Attend the meeting",
        "Do laundry",
    )



    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "My To Do List", style = TextStyle(fontFamily = EagleLake), fontSize = 18.sp)

        //for the calendar
        Row(modifier = Modifier
            .padding(30.dp)
            .border(
                width = 2.dp,
                brush = Brush.horizontalGradient(colors = listOf(Pink, LightBlue, Purple)),
                shape = RoundedCornerShape(percent = 0)
            )) {

           CalendarLayout()


        }

        //Today's Tasks
        Column(

            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Today's Tasks",style = TextStyle(fontFamily = EagleLake))

                //box
                val customGradientColors = listOf(LightBlue,Purple)
                GradientBox(
                    textOfButton = "Add Tasks",
                    gradientColors = customGradientColors
                )
            }



            //list of today's task
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(tasks) { task ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Icon(Icons.Filled.Star, "Star")
                        val checkedState = remember { mutableStateOf(false) }

                        Column {
                            //the if statement strikes through the task if the checkbox is ticked
                            Text(text = "$task", style = if (checkedState.value) {
                                TextStyle(
                                    fontFamily = Paprika,
                                    textDecoration = TextDecoration.LineThrough
                                )
                            } else{TextStyle(fontFamily = Paprika)
                            })
                        }
                        //checkbox

                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Purple,
                                uncheckedColor = Purple,
                                checkmarkColor = White
                            )
                        )
                    }
                    //dividers
                    GradientDividers()
                }
            }
        }


        //Upcoming Tasks
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Upcoming Tasks",style = TextStyle(fontFamily = EagleLake))

            //box
            val customGradientColors = listOf(Purple,Pink)
            GradientBox(
                textOfButton = "Add Tasks",
                gradientColors = customGradientColors
            )


        }


        //Completed Tasks
        Row(
            modifier = Modifier.fillMaxWidth(),
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


    }

}


//dividers created using Box for the gradient effect
@Composable
fun GradientDividers()
{
    Box(
    modifier = Modifier
        .fillMaxWidth()
        .height(height = 1.dp)
        .background
            (
            brush = Brush.horizontalGradient(listOf(Pink, LightBlue, Purple)),
            shape = RoundedCornerShape(size = 0.dp)
        )
    )
}


//gradient box for tasks
@Composable
fun GradientBox(
    textOfButton: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    gradientColors: List<Color>
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = gradientColors
                )
            )
            .height(30.dp)
            .width(100.dp),
        contentAlignment = Alignment.Center
    )
        {

            Text(
                text = textOfButton,
                fontSize = 9.sp,
                color = Color.White,
                style = TextStyle(fontFamily = Paprika)
            )
        }

}





