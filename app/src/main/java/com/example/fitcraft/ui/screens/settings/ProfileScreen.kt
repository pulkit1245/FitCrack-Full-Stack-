package com.example.fitcraft.ui.screens.settings

import android.R.attr.onClick
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import org.w3c.dom.Text

@Composable
@Preview(showBackground = true)
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            "Profile", fontSize = 35.sp,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xff273453)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF3A4A73)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "JD", color = Color.White, fontWeight = FontWeight.Bold,
                            fontSize = 38.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "John Doe",
                            color = Color.White,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            "john.doe@example.com",
                            color = Color.LightGray,
                            fontSize = 17.sp,
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            "Member since Nov 2023", color = Color.Gray,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TwoTextInaRowBox(12.toString(), "Bookings")
                    TwoTextInaRowBox(5.toString(), "Favourites")
                    TwoTextInaRowBox(4.8.toString(), "Rating")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            ProfileItemButton(Icons.Outlined.Edit, "Edit Profile")
            Spacer(modifier = Modifier.height(15.dp))
            ProfileItemButton(Icons.Outlined.FavoriteBorder, "Favorite Tailors")
            Spacer(modifier = Modifier.height(15.dp))
            ProfileItemButton(Icons.Outlined.ShoppingCart, "Payment Method")
            Spacer(modifier = Modifier.height(15.dp))
            ProfileItemButton(Icons.Outlined.Star, "My Reviews")
            Spacer(modifier = Modifier.height(15.dp))
            ProfileItemButton(Icons.Outlined.Settings, "Settings")
            Spacer(modifier = Modifier.height(15.dp))
            ProfileItemButton(Icons.Outlined.Info, "Help & Support")
            Spacer(modifier = Modifier.weight(1f))
            SignOutButton {  }
        }
    }
}


@Composable
//@Preview
fun ProfileItemButton(icon: ImageVector, title: String, badge: String? = null) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .border(2.dp, Color(0xffe5e7eb), RoundedCornerShape(15.dp)),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Black
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.size(23.dp)
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(title, fontSize = 17.sp)
        }
    }
}

@Composable
fun TwoTextInaRowBox(first: String, second: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(first, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(second, fontSize = 16.sp, color = Color.LightGray)
    }
}
@Composable
fun SignOutButton(
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = if (isPressed) Color(0xFFD32F2F) else Color.Transparent
    val contentColor = if (isPressed) Color.White else Color(0xFFD32F2F)
    val borderColor = Color(0xFFD32F2F)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, borderColor),
        interactionSource = interactionSource,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
            contentDescription = "Sign Out",
            modifier = Modifier.size(23.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Sign Out",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
        )
    }
}