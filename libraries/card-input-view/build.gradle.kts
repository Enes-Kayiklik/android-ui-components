plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.androidMaven)
}

group = Configs.group
version = ComponentVersions.cardInputViewVersion

android {
    compileSdkVersion(Configs.compileSdkVersion)
    buildToolsVersion(Configs.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName<com.android.build.gradle.internal.dsl.BuildType>("release") {
            isMinifyEnabled = false
            setProguardFiles(
                mutableListOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    dataBinding.isEnabled = true
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(Dependencies.kotlinJDK)

    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.androidXMaterial)
    implementation(Dependencies.glide)
}
