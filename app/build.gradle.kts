plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android") version "2.57" apply false
}

android {
    namespace = "com.example.fitcraft"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.fitcraft"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // ========================= Hilt (Dependency Injection) =========================
    implementation("com.google.dagger:hilt-android:2.57")
    kapt("com.google.dagger:hilt-android-compiler:2.57")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Hilt integration with Compose Navigation

// ========================= Lifecycle & ViewModel =========================
    val lifecycle_version = "2.9.2"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")       // ViewModel with Kotlin extensions
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")   // ViewModel support for Jetpack Compose

// ========================= Coroutines (Asynchronous Programming) =========================
    val coroutinesVersion = "1.10.2"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")    // Core coroutines library
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion") // Android-specific coroutine support

// ========================= Retrofit (Networking) =========================
    implementation("com.squareup.retrofit2:retrofit:3.0.0")            // Retrofit core
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")      // GSON converter for JSON parsing

// ========================= Navigation =========================
    val nav_version = "2.9.2"
    implementation("androidx.navigation:navigation-compose:$nav_version") // Navigation for Jetpack Compose
}