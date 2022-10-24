plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    implementation(project(":presentation:features:banks:api"))

    implementation(project(":common:navigation"))
    implementation(project(":presentation:design-system:atoms"))
    implementation(project(":presentation:design-system:organism"))
    implementation(project(":domains:banks:api"))
    instrumentationTesting()
    unitTesting()
    compose()
    hilt(withHiltNavigation = true)
}
