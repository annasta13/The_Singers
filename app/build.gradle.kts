plugins {
    id(Dependencies.Plugins.androidApplication)
    id(Dependencies.Plugins.kotlinAndroid)
    kotlin(Dependencies.Plugins.android)
    id(Dependencies.Plugins.hilt)
    kotlin(Dependencies.Plugins.kapt)
}

android {
    compileSdk = Dependencies.ConfigData.compileSdk
    sourceSets["test"].java.srcDir("src/test/resources")
    defaultConfig {
        applicationId = Dependencies.ConfigData.applicationId
        minSdk = Dependencies.ConfigData.minSdk
        targetSdk = Dependencies.ConfigData.targetSdkVersion
        versionCode = Dependencies.ConfigData.versionCode
        versionName = Dependencies.ConfigData.versionName

        testInstrumentationRunner = Dependencies.ConfigData.hiltTestRunner

        buildConfigField("String", "BASE_URL", ApiProperties.ApiKey.baseUrl)
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
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
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-alpha03"
    }
    sourceSets {
        getByName("main") {
            resources {
                srcDirs("src/main/resources", "src/test/resources")
            }
        }
    }
}

dependencies {
    implementation(Dependencies.AndroidDeps.coreKtx)
    implementation(Dependencies.AndroidDeps.appCompat)
    implementation(Dependencies.AndroidDeps.material)

    implementation(Dependencies.AndroidDeps.composeActivity)
    implementation(Dependencies.AndroidDeps.composeMaterial)
    implementation(Dependencies.AndroidDeps.composeMaterialIcon)
    implementation(Dependencies.AndroidDeps.composeTooling)
    implementation(Dependencies.AndroidDeps.constraintLayoutCompose)
    implementation(Dependencies.AndroidDeps.composeUi)
    implementation(Dependencies.AndroidDeps.timber)

    implementation(Dependencies.Coil.compose)
    implementation(Dependencies.Coil.gif)

    implementation(Dependencies.Accompanist.insets)
    implementation(Dependencies.Accompanist.materialPlaceholder)
    implementation(Dependencies.Accompanist.swipeRefresh)

    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.compose)

    implementation(Dependencies.Retrofit.loggingInterceptor)
    implementation(Dependencies.Retrofit.moshi)
    implementation(Dependencies.Retrofit.okhttp)
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.serializationConverter)
    implementation(Dependencies.Room.room)

    implementation(Dependencies.Glide.glide)
    implementation(Dependencies.Pager.pager)
    implementation(Dependencies.Pager.pagerIndicator)

    kapt(Dependencies.Hilt.compiler)
    kapt(Dependencies.Room.compiler)
    kaptAndroidTest(Dependencies.Hilt.compiler)

    testImplementation(Dependencies.AndroidDeps.archCoreTesting)
    testImplementation(Dependencies.AndroidDeps.testCore)
    testImplementation(Dependencies.Coroutine.coroutineTest)
    testImplementation(Dependencies.Junit.junit)
    testImplementation(Dependencies.Test.mock)
    testImplementation(Dependencies.Test.truth)
    testImplementation(Dependencies.Test.mockWebServer)
    testImplementation(Dependencies.Test.robolectric)

    androidTestImplementation(Dependencies.Room.testing)
    androidTestImplementation(Dependencies.Hilt.androidTest)
    androidTestImplementation(Dependencies.AndroidDeps.composeJunit)
    androidTestImplementation(Dependencies.Coroutine.coroutineTest)
    androidTestImplementation(Dependencies.Junit.extJunit)
    androidTestImplementation(Dependencies.Espresso.espresso)
}