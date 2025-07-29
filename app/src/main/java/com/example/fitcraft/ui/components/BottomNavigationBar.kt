package com.example.fitcraft.ui.components

import android.R.attr.label
import android.R.attr.onClick
import android.R.attr.text
import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.fitcraft.R

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(
        route = "home",
        label = "Home",
        icon = Icons.Default.Home,
        contentDescription = "Go to Home"
    )
    // Add more destinations if needed
}
@Composable
@Preview
fun BottomNavigationBar(){
    val navController = rememberNavController()
    val startDestination = "home"
    val items = listOf(
        NavigationItem("home", Icons.Outlined.Home, "Home"),
        NavigationItem("search", Icons.Outlined.Search, "Search"),
        NavigationItem("messages", Icons.Outlined.MailOutline, "Messages"),
        NavigationItem("bookings", Icons.Outlined.DateRange, "Bookings"),
        NavigationItem("profile", Icons.Outlined.Person, "Profile")
    )
    var selectedRoute by rememberSaveable { mutableStateOf(startDestination) }
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color.Black,
                tonalElevation = 10.dp
            ) {

                items.forEach { item ->
                    NavigationBarItem(
                        selected = selectedRoute == item.route,
                        onClick = { selectedRoute = item.route },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = {
                            if (selectedRoute == item.route) {
                                Text(text = item.label, fontSize = 11.sp)
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Black,
                            indicatorColor = Color.LightGray
                        ),
                        alwaysShowLabel = false
                    )
                }
            }
        }
    ){contentPadding ->
        Modifier.padding(contentPadding)
    }
}

@Composable
fun NavigationBarItem(imageVector: ImageVector, label: String,onclick: ()-> Unit){
    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Black
        ),
        onClick = {onclick()}
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = label,
            )
            Text(
                text = label
            )
        }
    }
}
data class NavigationItem(val route: String, val icon: ImageVector, val label: String)
