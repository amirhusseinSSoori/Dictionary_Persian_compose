plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
}

android {
    compileSdk = 35
    namespace = "com.amirhusseinsoori.persian_dictionary"

    defaultConfig {
        applicationId = "com.amirhusseinsoori.persian_dictionary"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = ("17")
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packagingOptions {
        resources {
            excludes += listOf("/META-INF/AL2.0", "/META-INF/LGPL2.1")
        }
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.com.google.android.material.material2)
    testImplementation("junit:junit:")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.constraintlayout.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)


    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android6)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.core6)


    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)


    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)


    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler) // Note that annotationProcessor is not used in KTS
    kapt(libs.androidx.room.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)

    implementation(libs.androidx.hilt.navigation.compose)


    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)


    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.flowlayout)


    implementation(libs.coil.compose)

    implementation(libs.gson)
    implementation(libs.lottie.compose)

    implementation(libs.kotlinx.serialization.json)
}



configurations.all {
    resolutionStrategy {
        force("org.xerial:sqlite-jdbc:3.34.0")
    }
}
