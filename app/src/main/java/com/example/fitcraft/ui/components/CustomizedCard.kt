package com.example.fitcraft.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomizedCard(
    modifier: Modifier = Modifier
        .fillMaxWidth(.80f)
        .height(450.dp)
        .border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(60f, 60f, 50f, 50f)
        )
        .clip(RoundedCornerShape(60f, 60f, 50f, 50f)),
    cardColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    content: @Composable () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            disabledContainerColor = cardColor,
        ),
        modifier = modifier
    ) {
        content()
    }
}