val ktor_version: String by project
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.navigation.safeargs.kotlin)
    kotlin("plugin.serialization") version "2.0.21"

}

android {
    namespace = "edu.iesam.dam2024"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.iesam.dam2024"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.gson.serializer)
    implementation(libs.glide)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.nav.ui)
    implementation(libs.nav.fragment)
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation(libs.kotlinx.serialization.json) // Para la serialización JSON
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")

    api(libs.nav.fragment.ktx)
    //testing
    testImplementation(libs.junit)
    //android testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}