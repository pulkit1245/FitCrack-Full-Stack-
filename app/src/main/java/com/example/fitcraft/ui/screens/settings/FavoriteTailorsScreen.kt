package com.example.fitcraft.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun FavoriteTailorsScreen() {
    val tailors = listOf(
        Tailor("Maria Rodriguez", "Custom Suits & Formal Wear", "Manhattan, NY", 4.9, 127, "$$$"),
        Tailor("James Chen", "Alterations & Repairs", "Brooklyn, NY", 4.8, 89, "$$"),
        Tailor("Sophia Williams", "Wedding & Evening Gowns", "Queens, NY", 4.9, 156, "$$$$")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorite Tailors", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(tailors) { tailor ->
                TailorCard(tailor)
            }
        }
    }
}

data class Tailor(
    val name: String,
    val service: String,
    val location: String,
    val rating: Double,
    val reviews: Int,
    val price: String
)

@Composable
fun TailorCard(tailor: Tailor) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background), // replace with actual image
                    contentDescription = "Tailor Image",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(tailor.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(tailor.service, color = Color.Gray)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = "Rating", tint = Color(0xFFFFC107), modifier = Modifier.size(16.dp))
                        Text("${tailor.rating} (${tailor.reviews})", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.Gray, modifier = Modifier.size(16.dp))
                        Text(tailor.location, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(tailor.price, fontSize = 14.sp, color = Color.Gray)
                    }
                }

                Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Red)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(70.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(1f)
                        .height(45.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Brush.horizontalGradient(
                        listOf(Color(0xFF1E3C72), Color(0xFF2A5298))
                    ).toBrushColor())
                ) {
                    Text("Book Now")
                }

                Spacer(modifier = Modifier.width(12.dp))

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(45.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Message")
                }
            }
        }
    }
}

// Extension function to convert Brush to BrushColor
@Composable
fun Brush.toBrushColor(): Color {
    return Color.Unspecified // workaround, used just to inject gradient via background in real case
}