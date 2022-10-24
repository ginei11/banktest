plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
}

android {

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    hilt()
    compose()
    implementation(project(":presentation:navigation:api"))
    implementation(project(":common:navigation"))
    implementation(project(":presentation:design-system:atoms"))
}
