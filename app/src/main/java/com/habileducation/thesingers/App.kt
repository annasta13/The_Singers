package com.habileducation.thesingers

import android.app.Application
import com.habileducation.thesingers.BuildConfig.DEBUG
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Annas Surdyanto on 10/12/21.
 *
 */
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}