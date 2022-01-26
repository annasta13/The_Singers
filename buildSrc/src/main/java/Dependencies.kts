object Versions {
    const val gradlePlugin = "7.0.0"
    const val kotlin = "1.5.30"
    const val timber = "5.0.0"
    const val hilt = "2.38.1"
    const val hiltCompose = "1.0.0-rc01"
    const val kotlinCompilerExtensionVersion = "1.1.0-alpha03"
    const val archCoreTesting = "2.1.0"
    const val testCore = "1.4.0"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.0"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.2"
    const val constraintLayoutCompose = "1.0.0-rc02"
    const val activityCompose = "1.4.0"
    const val jUnit = "4.13.2"
    const val extJunit = "1.1.3"
    const val compose = "1.0.5"
    const val materialIcon = "1.0.5"
    const val accompanist = "0.19.0"
    const val coroutineTest = "1.5.2"
    const val coilCompose = "1.3.1"
    const val coilGif = "1.4.0"
    const val composeJunit = "1.0.4"
    const val espresso = "3.4.0"
    const val truth = "1.1.3"
    const val mock = "1.12.0"
    const val robolectric = "4.6.1"
    const val mockWebServer = "5.0.0-alpha.2"
    const val retrofit = "2.9.0"
    const val okhttp = "5.0.0-alpha.2"
    const val loggingInterceptor = "5.0.0-alpha.2"
    const val serializationConverter = "0.8.0"
    const val moshi = "2.9.0"
    const val room = "2.3.0"
    const val glide = "1.4.4"
    const val pager = "0.19.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "dagger.hilt.android.plugin"
    const val android = "android"
    const val kotlinAndroid = "kotlin-android"
    const val hilt = "dagger.hilt.android.plugin"
    const val kapt = "kapt"
}

object ConfigData {
    const val hiltTestRunner = "com.habileducation.thesingers.HiltTestRunner"
    const val applicationId = "com.habileducation.thesingers"
    const val minSdk = 28
    const val compileSdk = 31
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"
}

object ClasspathDependencies {
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Hilt {
    const val compose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
    const val androidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
}

object Accompanist {
    private const val accompanist = "com.google.accompanist:accompanist"
    const val insets = "$accompanist-insets:${Versions.accompanist}"
    const val swipeRefresh = "$accompanist-swiperefresh:${Versions.accompanist}"
    const val materialPlaceholder = "$accompanist-placeholder-material:${Versions.accompanist}"
}

object Coil {
    const val compose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
    const val gif = "io.coil-kt:coil-gif:${Versions.coilGif}"
}

object AndroidDeps {
    private const val constraintLayoutName = "androidx.constraintlayout:constraintlayout"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayoutCompose =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeMaterialIcon =
        "androidx.compose.material:material-icons-extended:${Versions.materialIcon}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"


    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.composeJunit}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Junit {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
}

object Coroutine {
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
}

object Espresso {
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Test {
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val mock = "io.mockk:mockk:${Versions.mock}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val serializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverter}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"

}

object Glide {
    const val glide = "com.github.skydoves:landscapist-glide:${Versions.glide}"
}

object Room {
    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val testing = "androidx.room:room-testing:${Versions.room}"
}

object Pager {
    const val pager = "com.google.accompanist:accompanist-pager:${Versions.pager}"
    const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.pager}"
}