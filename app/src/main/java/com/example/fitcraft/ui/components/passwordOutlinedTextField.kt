package com.example.fitcraft.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun passwordOutlineTextField(
    value: String,
    labelText: String,
): String {
    var password by rememberSaveable { mutableStateOf(value) }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        singleLine = true,
        visualTransformation = if (!passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            val icon =
                if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    icon,
                    contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                )
            }
        },
        modifier = Modifier,
        label = { Text(labelText) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
    return password
}