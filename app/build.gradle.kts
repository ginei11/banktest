plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version Versions.SERIALIZATION_PLUGIN
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.pagatodo.test"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    compose()
    hilt()
    unitTesting()
    implementation(project(":common:network"))
    implementation(project(":common:navigation"))

    implementation(project(":presentation:features:banks:api"))
    implementation(project(":presentation:features:banks:impl"))
    implementation(project(":presentation:features:banks:wiring"))

    implementation(project(":presentation:design-system:atoms"))

    implementation(project(":presentation:navigation:api"))
    implementation(project(":presentation:navigation:impl"))
    implementation(project(":presentation:navigation:wiring"))

    implementation(project(":domains:banks:wiring"))
}
