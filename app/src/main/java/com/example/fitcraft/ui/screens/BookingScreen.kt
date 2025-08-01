package com.example.fitcraft.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitcraft.ui.components.BottomNavigationBar
import com.example.fitcraft.ui.components.CustomButton
import com.example.fitcraft.ui.components.TopAppBar
import com.example.fitcraft.ui.theme.buttonColor

@Preview
@Composable
fun BookingScreen() {
    Scaffold(
        topBar = { TopAppBar("My Booking") },
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomNavigationBar() },
        content = { innerPadding -> // Apply the inner padding to the content 0.dp
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                BookingScreenContent()
            }
        })
}

@Preview
@Composable
fun BookingScreenContent() {
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp)
            .verticalScroll(verticalScroll)
    ) {
        CustomButton(
            buttonColor = buttonColor,
            modifier = Modifier
                .fillMaxWidth(1f),
            shape = RoundedCornerShape(10.dp),
            borderWidth = (2.5).dp,
            borderColor = Color.Black,
            buttonText = "Book New Appointment",
        ) { }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomButton(
                buttonColor = buttonColor,
                modifier = Modifier
                    .weight(1f)
                    .scale(0.90f),
                shape = RoundedCornerShape(8.dp),
                borderWidth = 1.5.dp,
                borderColor = MaterialTheme.colorScheme.outline,
                buttonText = "Upcoming",
            ) { }
            CustomButton(
                modifier = Modifier
                    .weight(1f)
                    .scale(0.90f),
                buttonText = "Pending",
                shape = RoundedCornerShape(8.dp),
                borderWidth = 1.5.dp,
                borderColor = MaterialTheme.colorScheme.outline,
            ) { }
            CustomButton(
                modifier = Modifier
                    .weight(1f)
                    .scale(0.90f),
                shape = RoundedCornerShape(8.dp),
                borderWidth = 1.5.dp,
                borderColor = MaterialTheme.colorScheme.outline,
                buttonText = "Completed",
            ) { }
        }
    }
}


