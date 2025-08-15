package com.example.fitcraft.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitcraft.R
import com.example.fitcraft.ui.components.ColorChangingButton
import com.example.fitcraft.ui.components.passwordOutlineTextField
import com.example.fitcraft.ui.theme.headerStyle
import com.example.fitcraft.viewmodel.AuthState
import com.example.fitcraft.viewmodel.AuthViewModel


@Composable
fun SignUpTailorScreen(
    authViewModel: AuthViewModel,
    onNavigateToSignIn: () -> Unit,
    onNavigateToHome: () -> Unit,
    onBack: () -> Boolean,
) {

    val authState by authViewModel.authState.observeAsState(AuthState.Unauthenticated)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var businessName by remember { mutableStateOf("") }
    var yearsOfExperience by remember { mutableStateOf("") }
    var specialties by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val verticalScroll = rememberScrollState()
    val screenScroll = rememberScrollState()
    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            onNavigateToHome()
        }
    }
// Validate required fields and password match
    val enableSignUp = firstName.isNotBlank() &&
            lastName.isNotBlank() &&
            email.isNotBlank() &&
            phNumber.isNotBlank() &&
            businessName.isNotBlank() &&
            yearsOfExperience.isNotBlank() &&
            (yearsOfExperience.toIntOrNull() ?: 0) > 0 &&
            specialties.isNotBlank() &&
            location.isNotBlank() &&
            password.isNotBlank() && confirmPassword.isNotBlank() &&
            password.length >= 8 && password == confirmPassword

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.heightIn(80.dp),
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier.padding(0.dp),
                        style = headerStyle.merge(MaterialTheme.typography.headlineLarge),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            modifier = Modifier.size(30.dp),
                            contentDescription = "Notifications"
                        )
                    }
                },
                backgroundColor = Color.Transparent,
                contentColor = Color.Black,
                elevation = 4.dp,
            )
        },
    ) { innerPadding ->
        innerPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(screenScroll)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(.88f)
                    .height(650.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(60f, 60f, 50f, 50f)
                    )
                    .clip(RoundedCornerShape(60f, 60f, 50f, 50f)),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0x0F9D9090),
                    disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                )
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(
                            start = 10.dp, end = 10.dp, top = 16.dp,
                            bottom = if (!enableSignUp) {
                                0.dp
                            } else {
                                16.dp
                            }
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // Main Heading Text
                    Text(
                        "Create " + stringResource(R.string.app_name) + " Tailor Account",
                        modifier = Modifier.padding(top = 10.dp, bottom = 8.dp),
                        style = headerStyle.merge(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W600,
                            fontFamily = FontFamily.Default
                        )
                    )
                    //Sub Text
                    Text(
                        "Join to showcase your skills and\ngrow your business",
                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 14.5.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.Default
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(verticalScroll)
                            .padding(vertical = 16.dp, horizontal = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 3.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            //First name Input TextField
                            OutlinedTextField(
                                value = firstName,
                                onValueChange = {
                                    firstName = it
                                },
                                singleLine = true,
                                modifier = Modifier.weight(1f),
//                                .widthIn(120.dp),
                                label = { Text("First Name") },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                )
                            )
                            Spacer(Modifier.width(6.dp))
                            //Last name Input TextField
                            OutlinedTextField(
                                value = lastName,
                                onValueChange = {
                                    lastName = it
                                },
                                singleLine = true,
                                modifier = Modifier.weight(1f),
                                label = { Text("Last Name") },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text
                                )
                            )
                        }
                        //Email TextField
                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            singleLine = true,
                            modifier = Modifier,
                            label = { Text("Email") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            )
                        )
                        //Phone Number TextField
                        OutlinedTextField(
                            value = phNumber,
                            onValueChange = {
                                phNumber = it
                            },
                            singleLine = true,
                            modifier = Modifier,
                            label = { Text("Phone NO.") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone
                            )
                        )
                        //Business Name TextField
                        OutlinedTextField(
                            value = businessName,
                            onValueChange = { businessName = it },
                            label = { Text("Business Name") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                        //Location TextField
                        OutlinedTextField(
                            value = yearsOfExperience,
                            onValueChange = {
                                yearsOfExperience = it.filter { ch -> ch.isDigit() }
                            },
                            label = { Text("Years of Experience") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        //Specialties TextField
                        OutlinedTextField(
                            value = specialties,
                            onValueChange = { specialties = it },
                            label = { Text("Specialties (e.g., suits, dresses)") },
                            singleLine = false,
                            minLines = 1,
                            maxLines = 2,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                        //SetPassword  TextField
                        password = passwordOutlineTextField(password, "Set Password")
                        //Confirm Pass TextField
                        confirmPassword =
                            passwordOutlineTextField(confirmPassword, "Confirm Password")
                        //Check if all fields are filled
                        //SignUp Button
                        if (password.isNotEmpty() && confirmPassword.isNotEmpty() && password.length >= 8 && confirmPassword.length >= 8 && password != confirmPassword) {
                            Text(
                                text = "Passwords do not match",
                                color = MaterialTheme.colorScheme.error,
                            )
                        }
                        Spacer(Modifier.height(1.dp))
                        ColorChangingButton(
                            defaultColor = MaterialTheme.colorScheme.surfaceContainer,
                            touchedColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            enabled = enableSignUp,
                            text = "Sign Me Up",
                        ) {
                            authViewModel.signup(email.trim(), password.trim())
                        }
                        if (authState is AuthState.Error) {
                            Text(
                                text = (authState as AuthState.Error).message,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
            //SignIn TextButton
            TextButton(
                onClick = { onNavigateToSignIn() },
            ) {
                Text(
                    text = "Already have an Account? Sign In",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.Default
                )
            }
        }
    }

}
