package com.example.fitcraft.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import com.example.fitcraft.ui.components.CenterAlignedTopBar
import com.example.fitcraft.ui.components.CustomButton
import com.example.fitcraft.ui.components.CustomOutlinedTextField
import com.example.fitcraft.ui.components.CustomizedCard
import com.example.fitcraft.ui.theme.MeshGradientBackground
import com.example.fitcraft.viewmodel.AuthState
import com.example.fitcraft.viewmodel.AuthViewModel


@ExperimentalMaterial3Api
@Composable
fun SignInScreen(
    authViewModel: AuthViewModel,
    onSignInSuccess: () -> Unit,
    onNavigateToSignUpChoice: () -> Unit,
) {
    val authState by authViewModel.authState.observeAsState(AuthState.Unauthenticated)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val screenScroll = rememberScrollState()

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            onSignInSuccess()
        }
    }
    Scaffold(
        topBar = { CenterAlignedTopBar() },

        ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll( screenScroll)
                .background(Color.Transparent)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomizedCard(
                cardColor = MaterialTheme.colorScheme.surfaceContainer
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 26.dp),
                ) {
                    Text(
                        "Welcome Back",
                        style = MaterialTheme.typography.headlineLarge.merge(
                            fontSize = 29.sp,
                            fontWeight = FontWeight.W600
                        )
                    )
                    Text(
                        "Sign in to your " + stringResource(R.string.app_name) + " account",
                        style = MaterialTheme.typography.bodyMedium.merge(fontWeight = FontWeight.W500)
                    )
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 4.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomOutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = "Email",
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            )
                        )
                        CustomOutlinedTextField(
                            value = password,
                            label = "Password",
                            onValueChange = { password = it },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            imeAction = ImeAction.Done
                        )
                        if (authState is AuthState.Error) {
                            Spacer(Modifier.padding(2.dp))
                            Text(
                                text = (authState as AuthState.Error).message,
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(top = 12.dp)
                            )
                            Spacer(Modifier.padding(2.dp))
                        }
                        CustomButton(
                            buttonText = "Log in",
                            modifier = Modifier,
                            shape = RoundedCornerShape(6.dp),
                            borderColor = MaterialTheme.colorScheme.outline,
                            borderWidth = 1.dp,
                            enabled = authState !is AuthState.Loading,
                            buttonColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        ) {
                            authViewModel.login(email.trim(), password)
                        }
                    }

                }
            }
            Row(
                Modifier.padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "New User -> ",
                    Modifier.padding(top = 1.dp),
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge.merge(),
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.tertiary
                )
                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    onClick = { onNavigateToSignUpChoice() }
                ) {
                    Text(
                        "Create an Account",
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyLarge.merge(
                            shadow = Shadow(
                                color = MaterialTheme.colorScheme.tertiary,
                                offset = Offset(1.2f, 1.5f),
                            )
                        ),
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        }
    }
}
