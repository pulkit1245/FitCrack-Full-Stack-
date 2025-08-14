package com.example.fitcraft.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitcraft.ui.screens.SignInScreen
import com.example.fitcraft.ui.screens.SignUpCustomerScreen
import com.example.fitcraft.ui.screens.SignUpRoleChoiceScreen
import com.example.fitcraft.ui.screens.SignUpTailorScreen
import com.example.fitcraft.ui.screens.splash.SplashScreen
import com.example.fitcraft.viewmodel.AuthViewModel

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(
    authViewModel: AuthViewModel = AuthViewModel(),
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {
        // Splash Screen is the first screen to be displayed
        composable(Routes.Splash.route) {
            SplashScreen(
                onNavigateToSignIn = {
                    navController.navigate(Routes.SignIn.route) {
                        popUpTo(Routes.Splash.route) { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(Routes.Booking.route) {
                        popUpTo(Routes.Splash.route) { inclusive = true }
                    }
                },
                authState = authViewModel.authState
            )
        }
        //Sign In Screen will be Displayed After the Splash Screen
        composable(Routes.SignIn.route) {
            SignInScreen(
                authViewModel = authViewModel,
                onSignInSuccess = {
                    navController.navigate(Routes.Booking.route) {
                        popUpTo(Routes.SignIn.route) { inclusive = true }
                    }
                },
                onNavigateToSignUpChoice = {
                    navController.navigate(Routes.SignUpChoice.route) {
                        popUpTo(Routes.SignIn.route) { inclusive = false }
                    }
                }
            )
        }
        // For SignUp there will be choice for Customer or Tailor
        composable(Routes.SignUpChoice.route) {
            SignUpRoleChoiceScreen(
                onNavigateToSignUpCustomer = {
                    navController.navigate(Routes.SignUpCustomer.route) {
                        popUpTo(Routes.SignUpChoice.route) { inclusive = false }
                    }
                },
                onNavigateToSignUpTailer = {
                    navController.navigate(Routes.SignUpTailor.route) {
                        popUpTo(Routes.SignUpChoice.route) { inclusive = false }
                    }
                },
            )
        }
        // SignUp Customer Screen
        composable(Routes.SignUpCustomer.route) {
            SignUpCustomerScreen(
                authViewModel = authViewModel,
                onBack = { navController.popBackStack() },
                onNavigateToHome = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.SignUpCustomer.route) { inclusive = true }
                    }
                },
                onNavigateToSignIn = {
                    navController.navigate(Routes.SignIn.route) {
                        popUpTo(Routes.SignUpCustomer.route) { inclusive = true }
                    }
                },
            )
        }
        // SignUp Tailor Screen
        composable(Routes.SignUpTailor.route) {
            SignUpTailorScreen(
                authViewModel = authViewModel,
                onBack = { navController.popBackStack() },
                onNavigateToHome = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.SignUpTailor.route) { inclusive = true }
                    }
                },
                onNavigateToSignIn = {
                    navController.navigate(Routes.SignIn.route) {
                        popUpTo(Routes.SignUpTailor.route) { inclusive = true }
                    }
                },
            )
        }
        composable(
            route = Routes.Home.route
        ) {

        }
    }
}
