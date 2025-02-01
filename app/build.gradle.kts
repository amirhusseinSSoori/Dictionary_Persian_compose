plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-parcelize'
    id 'dagger.hilt.android.plugin'
    id 'kotlin-kapt'

}

android {
    compileSdk 34
    namespace "com.amirhusseinsoori.persian_dictionary"

    defaultConfig {
        applicationId "com.amirhusseinsoori.persian_dictionary"
        minSdk 23
        targetSdk 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = '17'
    }
    buildFeatures {
        compose true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }



    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }

}

dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.7.0'
    implementation 'com.google.android.material:material:1.12.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.activity:activity-compose:1.9.3'
    implementation "androidx.constraintlayout:constraintlayout-compose:1.1.0"
    testImplementation 'junit:junit:'
    androidTestImplementation 'androidx.test.ext:junit:1.2.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.6.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"


    def coroutines_version = "1.6.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")


    def lifecycle_version = "2.4.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"


    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"
    kapt "androidx.hilt:hilt-compiler:1.0.0"


    def room_version = "2.6.1"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation("androidx.room:room-ktx:$room_version")
    implementation "androidx.room:room-paging:2.4.2"

    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'


    def paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime-ktx:$paging_version")
    implementation "androidx.paging:paging-compose:1.0.0-alpha14"


    def accompanist_version = "0.20.2"
    implementation "com.google.accompanist:accompanist-insets:$accompanist_version"
    implementation "com.google.accompanist:accompanist-systemuicontroller:$accompanist_version"
    implementation "com.google.accompanist:accompanist-flowlayout:$accompanist_version"
    implementation "com.google.accompanist:accompanist-navigation-animation:0.23.0"


    implementation("io.coil-kt:coil-compose:1.4.0")

    implementation 'com.google.code.gson:gson:2.11.0'
    implementation "com.airbnb.android:lottie-compose:5.1.1"

    implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3"
}


configurations.all {
    resolutionStrategy {
        force 'org.xerial:sqlite-jdbc:3.34.0'
    }
}
