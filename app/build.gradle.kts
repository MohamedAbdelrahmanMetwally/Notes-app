plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.notesapp"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.notesapp"
        minSdk = 24
        targetSdk = 35
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
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
dependencies {
    // Lifecycle ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime:2.8.4")
    implementation(libs.fragment)
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.8.4")
    // Navigation Component
    implementation("androidx.navigation:navigation-fragment:2.8.1")
    implementation("androidx.navigation:navigation-ui:2.8.1")
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}