package com.example.fitcraft.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import com.example.fitcraft.ui.theme.headerStyle



@ExperimentalMaterial3Api
@Composable
@Preview
public fun CenterAlignedTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.app_logo),
                    contentDescription = "App Logo",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(55.dp)
                        .scale(2.0f),
                )
                Spacer(Modifier.width(9.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.Black,
                    style = headerStyle.merge(fontSize = 36.sp)
                )
            }
        },
    )
}