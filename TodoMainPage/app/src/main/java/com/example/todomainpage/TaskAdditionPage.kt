package com.example.todomainpage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todomainpage.ui.theme.EagleLake
import com.example.todomainpage.ui.theme.Paprika
import java.util.Date
import java.util.Locale

@Composable
fun Border(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Magenta,
                        Color.Cyan,

                        )
                ),
                shape = RoundedCornerShape(size = 5.dp)
            )
    ) {
        content()
    }
}

@Composable
fun Border1(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .border(5.dp, Color(0xFF5790E9), shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        content()
    }
}

@Composable
fun Border2(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .border(5.dp, Color(0xFF925CF1), shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        content()
    }
}

@Composable
fun Border3(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .border(5.dp, Color(0xFFF904FF), shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        content()
    }
}




@Composable
fun TaskAdditionPage() {
    var taskName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var isDatePickerVisible by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }
    var isTimePickerVisible by remember { mutableStateOf(false) }
    var isReminderEnabled by remember { mutableStateOf(false) }
    var selectedPriority by remember { mutableStateOf("Select Priority") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Border {
            Text(
                text = "Add Task",
                style = TextStyle(fontFamily = EagleLake),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Space
        //Spacer(modifier = Modifier.height(20.dp))

        // Name of Task
        Border1 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Name of Task:",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = EagleLake)
                )
                TaskNameTextField(
                    value = taskName,
                    onValueChange = { taskName = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        // Space
       // Spacer(modifier = Modifier.height(16.dp))

        // Description
        Border2 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Description:",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = EagleLake)
                )
                DescriptionTextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        // Space
      //  Spacer(modifier = Modifier.height(16.dp))

        // Date
        Border1 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Date: $selectedDate",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = Paprika)
                )
                Button(onClick = { isDatePickerVisible = true }) {
                    Text(text = "Select Date", style = TextStyle(fontFamily = Paprika))

                }
            }
        }
        if (isDatePickerVisible) {
            MyDatePickerDialog(
                onDateSelected = { selectedDate = it },
                onDismiss = { isDatePickerVisible = false }
            )
        }

        // Space
       // Spacer(modifier = Modifier.height(16.dp))

        // Time
        Border2 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Time: $selectedTime",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = EagleLake)
                )
                Button(onClick = { isTimePickerVisible = true }) {
                    Text(text = "Select Time", style = TextStyle(fontFamily = Paprika))
                }
            }
        }
        if (isTimePickerVisible) {
            MyTimePickerDialog(
                onTimeSelected = { selectedTime = it },
                onDismiss = { isTimePickerVisible = false })
        }

        // Space
        //Spacer(modifier = Modifier.height(16.dp))

        // Reminder
        Border3 {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Reminder:",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = EagleLake)
                )
                Switch(
                    checked = isReminderEnabled,
                    onCheckedChange = { isReminderEnabled = it },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        // Space
       // Spacer(modifier = Modifier.height(16.dp))

        // Priority
        Border1 {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                PriorityDropdown(
                    priorities = listOf("Low", "Medium", "High"),
                    selectedPriority = selectedPriority,
                    onPrioritySelected = { selectedPriority = it }
                )
            }
        }

        // Add Task Button
        Button(
            onClick = {
                println("Task Name: $taskName")
                println("Description: $description")
                println("Date: $selectedDate")
                println("Time: $selectedTime")
                println("Reminder $isReminderEnabled")
                println("Selected Priority: $selectedPriority")

                // Navigate to the ViewListPage after adding a task
                //navController.navigate("viewListPage")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Add Task", style = TextStyle(fontFamily = Paprika))
        }
    }
}

@Composable
fun TaskInputField(label: String) {
    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}

@Composable
fun TaskNameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
    )
}

@Composable
fun DescriptionTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(onDateSelected: (String) -> Unit, onDismiss: () -> Unit) {
    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return super.isSelectableDate(utcTimeMillis)
            }
        })

    var displaySelectedDate by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                selectedDate = datePickerState.selectedDateMillis?.let {
                    convertMillisToDate(it)
                } ?: ""
                displaySelectedDate = true
                onDateSelected(selectedDate)
                onDismiss()
            }) {
                Text(text = "Ok", style = TextStyle(fontFamily = Paprika))
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Cancel", style = TextStyle(fontFamily = Paprika))
            }
        }) {
        if (displaySelectedDate) {
            Text(
                text = "Selected Date: $selectedDate",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        DatePicker(state = datePickerState)
    }
}

private fun convertMillisToDate(millis: Long): String {
    val formatter = java.text.SimpleDateFormat("dd-MM-yyyy", Locale.UK)
    return formatter.format(Date(millis))
}

@Composable
fun MyTimePickerDialog(onTimeSelected: (String) -> Unit, onDismiss: () -> Unit) {
    var selectedHours by remember { mutableStateOf(0) }
    var selectedMinutes by remember { mutableStateOf(0) }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text("Select Time", fontWeight = FontWeight.Bold)
        },
        text = {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Displayed Time
                Text(
                    text = String.format("%02d:%02d", selectedHours, selectedMinutes),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .padding(bottom = 8.dp)
                )

                // Hours Slider
                Box(modifier = Modifier.padding(bottom = 4.dp)) {
                    NumberPicker(
                        value = selectedHours,
                        onValueChange = { selectedHours = it },
                        label = "",
                        range = 0..23
                    )
                }

                // Minutes Slider
                Box(modifier = Modifier.padding(bottom = 8.dp)) {
                    NumberPicker(
                        value = selectedMinutes,
                        onValueChange = { selectedMinutes = it },
                        label = "Minutes",
                        range = 0..59
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val formattedTime = String.format("%02d:%02d", selectedHours, selectedMinutes)
                    onTimeSelected(formattedTime)
                    onDismiss()
                }
            ) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = "Cancel")
            }
        }
    )
}


@Composable
fun TimePicker(
    selectedTime: Date?,
    onTimeSelected: (Date) -> Unit
) {
    var hours by remember { mutableStateOf(0) }
    var minutes by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        // Hours Picker
        NumberPicker(
            value = hours,
            onValueChange = {
                hours = it
            },
            label = "Hours",
            range = 0..23
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Minutes Picker
        NumberPicker(
            value = minutes,
            onValueChange = {
                minutes = it
            },
            label = "Minutes",
            range = 0..59
        )
    }
}


@Composable
fun NumberPicker(
    value: Int,
    onValueChange: (Int) -> Unit,
    label: String,
    range: IntRange
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            valueRange = range.first.toFloat()..range.last.toFloat(),
            steps = range.count() - 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Text(
            text = value.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun PriorityDropdown(
    priorities: List<String>,
    selectedPriority: String,
    onPrioritySelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Priority:",
            modifier = Modifier.weight(1f),
            style = TextStyle(fontFamily = EagleLake)
        )

        Row(
            modifier = Modifier
                .weight(1f)
                .clickable { expanded = true },
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedPriority,
                modifier = Modifier.weight(1f),
                style = TextStyle(fontFamily = EagleLake)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { expanded = true }
            )
        }
    }

    if (expanded) {
        LazyColumn {
            items(priorities) { priority ->
                PriorityDropdownItem(
                    priority = priority,
                    onPrioritySelected = {
                        onPrioritySelected(it)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun PriorityDropdownItem(
    priority: String,
    onPrioritySelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onPrioritySelected(priority) }
    ) {
        Text(
            text = priority,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

enum class Priority {}
