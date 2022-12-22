buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_lang}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.di_hilt}")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}


