package com.example.fitcraft.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import com.example.fitcraft.ui.components.SignUpScreenCard
import com.example.fitcraft.ui.theme.headerStyle

@ExperimentalMaterial3Api
@Preview
@Composable
fun SignUpChoiceScreen() {
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = "App Logo",
                            modifier = Modifier
                                .size(50.dp)
                                .scale(1.5f)
                                .fillMaxHeight(),
                        )
                        Text(
                            text = stringResource(id = R.string.app_name),
                            color = Color.Black,
                            style = headerStyle.merge(fontSize = 36.sp)
                        )
                    }
                },
            )
        }
    ) { innerpadding ->
        innerpadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Join "+stringResource(R.string.app_name),
                style = headerStyle.merge(fontSize = 27.sp, fontFamily = FontFamily.Default),
                modifier = Modifier
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = "Choose how you'd like to get started",
                style = MaterialTheme.typography.bodyMedium.merge(
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                ),
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.padding(8.dp))

            SignUpScreenCard(
                mainText = "I'm a Customer",
                subText = "Find skilled tailors for custom clothing, alterations, and repairs",
                image = R.drawable.group_2,
                colorChangingButtonText = "Continue As Customer",
                onClickListener = {}
            )
            SignUpScreenCard(
                mainText = "I'm a Tailor",
                subText = "Grow your business by connecting with customers who need your expertise",
                image = R.drawable.content_cut,
                colorChangingButtonText = "Continue As Tailor",
                onClickListener = {}
            )
        }


    }
}









