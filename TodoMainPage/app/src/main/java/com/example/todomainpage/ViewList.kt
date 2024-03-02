package com.example.todomainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todomainpage.ui.theme.TodoMainPageTheme
import com.example.todomainpage.ui.theme.Paprika


class Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Ensure that the NavController is created or retrieved based on your navigation setup
            val navController = rememberNavController()

            TodoMainPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the composable function with the NavController
                    ViewListPage(navController = navController)
                }
            }
        }
    }
}

@Composable
fun ViewListPage(navController: NavController) {
    var tasks by remember { mutableStateOf(listOf("Task", "Task", "Task")) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Border {
            Text(
                text = "View List",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                textAlign = TextAlign.Center
            )
        }

        // Space
        Spacer(modifier = Modifier.height(16.dp))

        // Task List
        LazyColumn {
            items(tasks) { task ->
                Border2 {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* Handle task click if needed */ },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = false, // Update with your actual logic
                            onCheckedChange = { /* Handle checkbox state change if needed */ },
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        Text(
                            text = task,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // Space
        Spacer(modifier = Modifier.height(16.dp))

        // Button Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Add Task Button
            Button(
                onClick = {
                    navController.navigate("taskAdditionPage")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 6.dp)
            ) {
                Text("Add Task", style = TextStyle(fontFamily = Paprika))
            }

            // Delete All Button
            Button(
                onClick = {
                    // Handle the logic to delete all tasks
                    // Update with your actual logic
                    tasks = emptyList()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp), // Adjust padding if needed
            ) {
                Text("Delete All", style = TextStyle(fontFamily = Paprika))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewListPreview() {
    TodoMainPageTheme {
        val navController = rememberNavController()
        ViewListPage(navController = navController)
    }
}
