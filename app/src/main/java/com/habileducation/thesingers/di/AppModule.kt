package com.habileducation.thesingers.di

import android.content.Context
import androidx.room.Room
import com.habileducation.thesingers.App
import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.repository.RepositoryImpl
import com.habileducation.thesingers.data.local.AppDatabase
import com.habileducation.thesingers.data.local.sources.LocalSource
import com.habileducation.thesingers.data.local.sources.LocalSourceImpl
import com.habileducation.thesingers.data.remote.ApiService
import com.habileducation.thesingers.data.remote.sources.RemoteSource
import com.habileducation.thesingers.data.remote.sources.RemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Created by Annas Surdyanto on 24/12/21.
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): App {
        return app as App
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }


    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.databaseName)
            .build()
    }

    @Singleton
    @Provides
    fun provideLocalSource(appDatabase: AppDatabase): LocalSource {
        return LocalSourceImpl(appDatabase.artistDao(), appDatabase.songDao())
    }

    @Singleton
    @Provides
    fun provideRemoteSource(apiService: ApiService): RemoteSource {
        return RemoteSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideRepository(localSource: LocalSource, remoteSource: RemoteSource): Repository {
        return RepositoryImpl(localSource, remoteSource)
    }
}