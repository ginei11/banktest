plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
}

dependencies {
    hilt()
    implementation(project(":presentation:features:banks:api"))
    implementation(project(":presentation:features:banks:impl"))
    implementation(project(":common:navigation"))

}
