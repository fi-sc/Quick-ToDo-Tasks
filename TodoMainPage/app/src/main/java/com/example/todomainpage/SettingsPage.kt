package com.example.todomainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SettingsPage() {
    var isDarkModeEnabled by remember { mutableStateOf(false) }
    var isCalendarViewEnabled by remember { mutableStateOf(false) }
    var areSoundsEnabled by remember { mutableStateOf(false) }
    var areVibrationsEnabled by remember { mutableStateOf(false) }
    var areNotificationsEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Border3 {
            Text(
                text = "Settings",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Border3 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dark Mode:",
                    modifier = Modifier.weight(1f),
                )
                Switch(
                    checked = isDarkModeEnabled,
                    onCheckedChange = { isDarkModeEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Border3 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Calender View:",
                    modifier = Modifier.weight(1f),
                )
                Switch(
                    checked = isCalendarViewEnabled,
                    onCheckedChange = { isCalendarViewEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Border3 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sounds:",
                    modifier = Modifier.weight(1f),
                )
                Switch(
                    checked = areSoundsEnabled,
                    onCheckedChange = { areSoundsEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Border3 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Vibrations:",
                    modifier = Modifier.weight(1f),
                )
                Switch(
                    checked = areVibrationsEnabled,
                    onCheckedChange = { areVibrationsEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Border3{
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notifications:",
                    modifier = Modifier.weight(1f),
                )
                Switch(
                    checked = areNotificationsEnabled,
                    onCheckedChange = { areNotificationsEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }

        }

    }
}

@Composable
fun Border3() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(5.dp, Color.Blue)
            .padding(9.dp)
    )
}

