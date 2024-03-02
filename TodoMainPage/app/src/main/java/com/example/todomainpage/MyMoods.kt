package com.example.todomainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun MoodsPreview() {


        Text(text = "MY MOOD", fontSize = 20.sp)
        Column (modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(28.dp)){


            Row {
                Text(text = "\uD83E\uDD14",)
                Text(text = "\uD83D\uDE31",)
                Text(text = "\uD83D\uDE06",)
            }
            Row {
                Text(text = "\uD83D\uDE0A",)
                Text(text = "\uD83D\uDE1E" ,)
                Text(text = "\uD83D\uDE0E",)
            }
            Row {
                Text(text = "\uD83D\uDE2D",)
                Text(text = "\u2764",)
                Text(text = "\uD83E\uDD2F",)
            }
        }
    }




