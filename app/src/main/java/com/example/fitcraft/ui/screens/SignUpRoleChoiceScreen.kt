package com.example.fitcraft.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import com.example.fitcraft.ui.components.CenterAlignedTopBar
import com.example.fitcraft.ui.components.SignUpScreenCard
import com.example.fitcraft.ui.theme.headerStyle

@ExperimentalMaterial3Api
@Composable
fun SignUpRoleChoiceScreen(
    onNavigateToSignUpCustomer: () -> Unit,
    onNavigateToSignUpTailer: () -> Unit
) {
    val screenScroll = rememberScrollState()

    Scaffold(
        topBar = {
            CenterAlignedTopBar()
        }
    ) { innerPadding ->
        innerPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(screenScroll )
                .background(color = MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Join " + stringResource(R.string.app_name),
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
                onClickListener = {onNavigateToSignUpCustomer()}
            )
            SignUpScreenCard(
                mainText = "I'm a Tailor",
                subText = "Grow your business by connecting with customers who need your expertise",
                image = R.drawable.content_cut,
                colorChangingButtonText = "Continue As Tailor",
                onClickListener = {onNavigateToSignUpTailer()}
            )
        }


    }
}












