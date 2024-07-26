plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.klint)
    alias(libs.plugins.ksp)
    alias(libs.plugins.navigation.safeagrs)
}

android {
    namespace = "com.app.thestore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.thestore"
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
                "proguard-rules.pro",
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

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.adapter.delegate)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.glide)
    implementation(libs.material)
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.room.ksp.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.startup.runtime)

    testImplementation(libs.junit)
    testImplementation(libs.iomockk)
    testImplementation(libs.google.truth)
    testImplementation(libs.koltin.coroutines)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
