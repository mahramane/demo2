group = "com.example"
version = "1.0-SNAPSHOT"

allprojects {

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            // allWarningsAsErrors = true
            freeCompilerArgs = listOf(
                "-opt-in=kotlin.RequiresOptIn",
            )
        }
    }

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }


}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
}