package com.example.fitcraft.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorChangingButton(
    defaultColor: Color = Color.Blue,
    touchedColor: Color = Color.Red,
    text: String,
    onClickListener: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = { onClickListener },
        modifier = Modifier,
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 3.dp,
            focusedElevation = 6.dp,
            hoveredElevation = 4.dp,
            disabledElevation = (-2).dp
        ),
        border = BorderStroke(
            width = (0.5).dp,
            color = MaterialTheme.colorScheme.outline
        ),

        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) touchedColor else defaultColor
        ),
        interactionSource = interactionSource,
    ) {
        Text(
            text,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}