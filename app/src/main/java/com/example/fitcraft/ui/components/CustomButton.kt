package com.example.fitcraft.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fitcraft.ui.theme.buttonTextStyle


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(5.dp),
    buttonText: String,
    borderColor: Color = Color.Black,
    borderWidth: Dp = 1.dp,
    buttonColor: Color = Color(0xFF311B92),
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier,
        color = Color.Transparent,
    )
    {
        Button(
            onClick = onClick,
            modifier = modifier
                .background(Color.Transparent),
            shape = shape,
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 3.dp,
                focusedElevation = 6.dp,
                hoveredElevation = 4.dp,
                disabledElevation = (-2).dp
            ),
            border = BorderStroke(
                width = borderWidth,
                color = borderColor
            ),
        ) {
            Row {
                Text(text = buttonText , color = Color.White, style = MaterialTheme.typography.titleLarge.merge(
                    buttonTextStyle))
            }
        }
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    Column(Modifier.fillMaxSize()) {
        CustomButton(
            modifier = Modifier,
            buttonText = "Test Button",
            buttonColor = Color(0xFF4A148C),
        ) { }
        CustomButton(
            buttonText = "Book Now",
        ) { }
    }
}