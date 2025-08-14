package com.example.fitcraft.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
private fun CustomOutlinedTextFieldPreview() {
    CustomOutlinedTextField(
        value = "",
        onValueChange = {},
        label = "Email"
    )
}
@Preview
@Composable
private fun CustomOutlinedTextFieldPreview2() {
    CustomOutlinedTextField(
        value = "",
        onValueChange = {},
        label = "Password",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit, // takes a String input and doesn't return anything
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    imeAction: ImeAction = ImeAction.Done,  // Action button behaviour

) {

    // State to manage password visibility
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    //Checks if the current field is the password field
    val isPassword = keyboardOptions.keyboardType == KeyboardType.Password
    val visualTransformation = if (isPassword && !passwordVisibility)
        PasswordVisualTransformation() //Hides password
    else
        VisualTransformation.None //Shows the text as it is
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        // label above the text field
        Text(
            text = label,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        // OutlineTextField forms a border around the selected field
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange, //called when any change in the text field
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction
            ),
            visualTransformation = visualTransformation,
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            ),

            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),

            // Shows icon if it's a password field
            trailingIcon = {
                if (isPassword) {
                    val icon =
                        if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val description = if (passwordVisibility) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = description,
                            tint = Color.LightGray
                        )
                    }
                }
            },

            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp,MaterialTheme.colorScheme.outline, RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.outline),
            shape = RoundedCornerShape(10.dp),

        )

    }
}

