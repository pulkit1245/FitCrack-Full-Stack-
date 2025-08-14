package com.example.fitcraft.ui.navigation

sealed class Routes(val route: String) {
    object SignIn : Routes("SignInScreen")

    object SignUpChoice : Routes("SignUpRoleChoiceScreen")

    object SignUpCustomer : Routes("SignUpCustomerScreen")
    object Home : Routes("HomeScreen")
    object BrowseTailor: Routes("BrowseTailorScreen")
    object MessagesScreen : Routes("MessagesScreen")
    object Profile : Routes("ProfileScreen")
    object FavoriteTailors : Routes("FavoriteTailorsScreen")
    object EditProfile : Routes("EditProfileScreen")
    object SignUpTailor : Routes("SignUpTailorScreen")
    object Booking : Routes("BookingScreen")
    object Splash : Routes("SplashScreen")
}