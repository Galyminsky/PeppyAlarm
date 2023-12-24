plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "galyaminsky.peppyalarm"
    compileSdk = 34

    defaultConfig {
        applicationId = "galyaminsky.peppyalarm"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //ssp
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    //sdp
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // Lottie animation dependency
    implementation("com.airbnb.android:lottie:3.4.4")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    // Custom bottom navigation bar
    //implementation("com.github.ismaeldivita:chip-navigation-bar:1.4.0")

    // Dagger Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.48")
    annotationProcessor("com.google.dagger:hilt-compiler:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    // Room database
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    // Work manager
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("com.google.code.gson:gson:2.10")
    implementation("androidx.hilt:hilt-work:1.1.0")
    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.1.0")
}