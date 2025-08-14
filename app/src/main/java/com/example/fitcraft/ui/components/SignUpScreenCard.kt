package com.example.fitcraft.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.ui.theme.headerStyle

@Composable
fun SignUpScreenCard(
    mainText: String = "mainText is not set",
    subText: String = "subText is not set",
    image: Any = Icons.Default.AccountCircle,
    colorChangingButtonText: String = "colorChangingButtonText is not set",
    onClickListener: () -> Unit = {},
) {
    CustomizedCard(
        modifier = Modifier
            .fillMaxWidth(0.84f)
            .height(300.dp)
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(60f, 60f, 50f, 50f)
            )
            .clip(RoundedCornerShape(60f, 60f, 50f, 50f))
            .clickable(
                onClick = { onClickListener() },
                onClickLabel = "Sign Up for Customer",
            ),
        cardColor = MaterialTheme.colorScheme.surfaceContainer
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp),
        ) {
            if (image is ImageVector) {
                Icon(
                    imageVector = image,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp),
                    contentDescription = "Sign Up",
                )
            } else if (image is Int) {
                Icon(
                    painter = painterResource(id = image),
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp),
                    contentDescription = "Sign Up",
                )
            }
            Text(
                text = mainText,
                style = headerStyle.merge(fontSize = 24.sp, fontFamily = FontFamily.Default),
                modifier = Modifier
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = subText,
                style = MaterialTheme.typography.bodyMedium.merge(
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                ),
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.padding(10.dp))

            ColorChangingButton(
                defaultColor = MaterialTheme.colorScheme.surfaceContainer,
                touchedColor = MaterialTheme.colorScheme.onSecondaryContainer,
                text = colorChangingButtonText,
            )
            { onClickListener() }
        }
    }
}