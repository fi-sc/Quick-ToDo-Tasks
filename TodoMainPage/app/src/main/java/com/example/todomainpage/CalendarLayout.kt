package com.example.todomainpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.todomainpage.ui.theme.Paprika
import com.example.todomainpage.ui.theme.Purple
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.daysOfWeek
import com.example.todomainpage.ui.theme.displayText
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.yearMonth
import java.time.DayOfWeek
import java.time.LocalDate

//Reference for the app:
//Nwose, K. (2023) Calendar GitHub. 6 December 2023 [online]. Available from: https://github.com/kizitonwose/Calendar [Accessed 9 January 2024].
@Composable
fun CalendarLayout() {
    //calender
    val today = remember { LocalDate.now() }
    val currentMonth = remember(today){ today.yearMonth }
    val startMonth = remember { currentMonth.minusMonths(100) }
    val endMonth = remember { currentMonth.plusMonths(100) }
    val daysOfWeek = remember { daysOfWeek() }

    val state = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = daysOfWeek.first(),

        )
    //displays the calendar
    HorizontalCalendar(

        state = state,

        dayContent = { day ->
            Day(day = day,
                today = today)},
        monthHeader = {month ->
            val daysOfWeek = month.weekDays.first().map { it.date.dayOfWeek }
            MonthHeader(month)
            WeekDays(daysOfWeek = daysOfWeek)

        }
    )
}



//gets each day
@Composable
fun Day(day: CalendarDay, today: LocalDate) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(color = if (day.date == today) Purple  else Color.Transparent,
                shape = CircleShape),//for the current day
        contentAlignment = Alignment.Center

    ) {
        Text(text = day.date.dayOfMonth.toString(),
            color = when {
                day.date == today -> Color.White //changes current date text colour
                day.position == DayPosition.MonthDate -> Color.Black //changes previous and coming month text colour
                else -> Color.Gray
            },
            style = TextStyle(fontFamily = Paprika))
    }
}


//gets the days
@Composable
private fun WeekDays(daysOfWeek: List<DayOfWeek>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("WeekDays"),
    ) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                text = dayOfWeek.displayText(),
                fontWeight = FontWeight.Medium,
                style = TextStyle(fontFamily = Paprika)
            )
        }
    }
}

//gets the months
@Composable
private fun MonthHeader(calendarMonth: CalendarMonth) {
    Box(
        modifier = Modifier.fillMaxWidth()



    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = calendarMonth.yearMonth.displayText(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontFamily = Paprika)
        )
    }
}