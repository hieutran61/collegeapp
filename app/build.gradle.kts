plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.fpt.collegeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fpt.collegeapp"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(platform("com.google.firebase:firebase-bom:32.4.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation ("de.hdodenhof:circleimageview:3.0.1")
    implementation ("androidx.navigation:navigation-fragment:2.7.5")
    implementation ("androidx.navigation:navigation-ui:2.7.5")
    implementation ("com.github.smarteist:autoimageslider:1.2.0")
    implementation ("com.github.bumptech.glide:glide:4.10.0")
    implementation ("com.github.chrisbanes:PhotoView:2.3.0")

    implementation("com.github.barteksc:android-pdf-viewer:2.8.2")

}