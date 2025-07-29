package com.example.fitcraft.ui.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun EditProfileScreen() {
    val fullName = remember { mutableStateOf("John Doe") }
    val email = remember { mutableStateOf("john.doe@example.com") }
    val phone = remember { mutableStateOf("+1 (555) 123-4567") }
    val location = remember { mutableStateOf("New York, NY") }
    val bio = remember { mutableStateOf("Fashion enthusiast with a passion for custom tailoring and quality craftsmanship.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Edit Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0A0F2C)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFE6E9F0), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "JD",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color(0xFF0A0F2C)
                    )
                )
            }

            IconButton(
                onClick = { /* handle photo change */ },
                modifier = Modifier
                    .offset(x = (-4).dp, y = 4.dp)
                    .background(Color(0xFF0A0F2C), shape = CircleShape)
                    .size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Change Photo",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { /* photo change */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFCBD5E1)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF0A0F2C))
        ) {
            Text("Change Photo", fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        ProfileTextField(label = "Full Name", value = fullName.value, onValueChange = { fullName.value = it })
        ProfileTextField(label = "Email", value = email.value, onValueChange = { email.value = it })
        ProfileTextField(label = "Phone Number", value = phone.value, onValueChange = { phone.value = it })
        ProfileTextField(label = "Location", value = location.value, onValueChange = { location.value = it })

        ProfileTextField(
            label = "Bio",
            value = bio.value,
            onValueChange = { bio.value = it },
            singleLine = false,
            minLines = 3
        )

        Spacer(modifier = Modifier.height(24.dp))

        GradientButton(
            text = "Save Changes",
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            // Handle Save
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ProfileTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    Text(
        text = label,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF0A0F2C),
        modifier = Modifier.padding(vertical = 6.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        minLines = minLines,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFCBD5E1),
            unfocusedBorderColor = Color(0xFFCBD5E1),
            focusedTextColor = Color(0xFF0A0F2C),
            unfocusedTextColor = Color(0xFF0A0F2C)
        )
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF0E1B4D), Color(0xFF1C2E5A))
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}