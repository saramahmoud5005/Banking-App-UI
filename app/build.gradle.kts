plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
//val keystoreProperties = java.util.Properties()
//val keystorePropertiesFile = rootProject.file("key.properties")
//if (keystorePropertiesFile.exists()) {
//    keystoreProperties.load(java.io.FileInputStream(keystorePropertiesFile))
//}
android {
    namespace = "com.example.bankingappui"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bankingappui"
        minSdk = 24
        targetSdk = 34
        if (project.properties["VERSION_CODE"] != null) {
            versionCode = project.properties["VERSION_CODE"] as Int
        } else {
            versionCode = 1
        }

        if (project.properties["VERSION_NAME"] != null) {
            versionName = project.properties["VERSION_NAME"] as String
        } else {
            versionName = "1.0.0"
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig signingConfigs.release
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    signingConfigs {
//        release {
//            keyAlias keystoreProperties['keyAlias']
//            keyPassword keystoreProperties['keyPassword']
//            storeFile keystoreProperties['storeFile'] ? file(keystoreProperties['storeFile']) : null
//            storePassword keystoreProperties['storePassword']
//        }
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-common-ktx:2.7.7")
    implementation("androidx.navigation:navigation-compose:2.7.7")

    //system ui controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0")
    //icons extended
    implementation("androidx.compose.material:material-icons-extended-android:1.6.2")
}
task("printVersionInformation"){

    println("v"+ project.properties["VERSION_CODE"]+"("+ project.properties["VERSION_NAME"]+")")
}