plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// Подпись только если CI выдал ключ через окружение — локальная сборка не ломается.
val keystorePath: String? = System.getenv("KEYSTORE_PATH")

android {
    namespace = "com.example.hellostore"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.hellostore"
        minSdk = 26
        targetSdk = 36

        // Поднимайте на каждый релиз: конвейер отклонит повтор versionCode.
        versionCode = 4
        versionName = "1.3.0"
    }

    signingConfigs {
        if (!keystorePath.isNullOrBlank()) {
            create("release") {
                storeFile = file(keystorePath)
                storePassword = System.getenv("KEYSTORE_PASSWORD")
                keyAlias = System.getenv("KEY_ALIAS")
                keyPassword = System.getenv("KEY_PASSWORD")
                enableV1Signing = true
                enableV2Signing = true
                enableV3Signing = true
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.findByName("release")
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
