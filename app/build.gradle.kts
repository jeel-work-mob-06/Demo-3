plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.demo3"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.demo3"
        minSdk = 23
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.glide)

    implementation("androidx.activity:activity:1.11.0")

    // Responsive UI
    //implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation(libs.sdp)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}