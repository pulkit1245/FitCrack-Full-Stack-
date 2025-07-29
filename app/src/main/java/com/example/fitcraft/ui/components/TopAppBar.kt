package com.example.fitcraft.ui.components

//noinspection UsingMaterialAndMaterial3Libraries

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitcraft.ui.theme.headerStyle

@Composable
fun TopAppBar(
    title: String,
) {
    TopAppBar(
        modifier = Modifier.heightIn(80.dp),
        title = {
            Text(
                text = title,
                modifier = Modifier.padding(0.dp),
                style = headerStyle.merge(MaterialTheme.typography.headlineLarge),
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
                IconButton(onClick = { /* Notification Settings I think but
                                        no use if possible we can remove this */ }) {
                    Icon(
                        Icons.Default.Notifications,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Notifications"
                    )
                }
                IconButton(onClick = { /* Sign in Screen */ }) {
                    Icon(
                        Icons.Default.AccountBox,
                        modifier = Modifier.size(30.dp),
                        contentDescription = "Notifications"
                    )
                }
            },
        backgroundColor =
            Color.Transparent,
        /*MaterialTheme.colorScheme.background*/ // Example: Customize background color
        contentColor = Color.Black,   // Example: Customize content color (title, icons)
        elevation = 4.dp,              // Example: Customize elevation
    )
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar("My Booking")
}