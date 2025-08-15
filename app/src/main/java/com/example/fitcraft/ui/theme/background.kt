package com.example.fitcraft.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

fun meshGradientBrush(width: Float, height: Float): List<Pair<Brush, Offset?>> = listOf(
    Brush.radialGradient(
        colors = listOf(Color(0xFF7877C6), Color.Transparent),
        center = Offset(width * 0.2f, height * 0.8f),
        radius = width * 0.4f,
        tileMode = TileMode.Clamp
    ) to null,
    Brush.radialGradient(
        colors = listOf(Color(0xFFFF77C6), Color.Transparent),
        center = Offset(width * 0.8f, height * 0.2f),
        radius = width * 0.4f,
        tileMode = TileMode.Clamp
    ) to null,
    Brush.radialGradient(
        colors = listOf(Color(0xFF78DBFF), Color.Transparent),
        center = Offset(width * 0.4f, height * 0.4f),
        radius = width * 0.3f,
        tileMode = TileMode.Clamp
    ) to null
)

@Composable
fun MeshGradientBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .drawWithCache {
                val brushes = meshGradientBrush(size.width, size.height)
                onDrawBehind {
                    // Draw base background
                    drawRect(Color(0xFFE0E7FF))
                    // Draw mesh gradients as overlays
                    for ((brush, _) in brushes) {
                        drawRect(brush = brush, size = size)
                    }
                }
            }
    ) {
        content()
    }
}
