package com.habileducation.thesingers.di

import android.content.Context
import androidx.room.Room
import com.habileducation.thesingers.App
import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.repository.RepositoryImpl
import com.habileducation.thesingers.data.domain.useCase.searchSong.GetSongSearched
import com.habileducation.thesingers.data.domain.useCase.searchSong.GetSongSearchedImpl
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
import javax.inject.Singleton

/**
 * Created by Annas Surdyanto on 24/12/21.
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideGetSongSearched(repository: Repository): GetSongSearched{
        return GetSongSearchedImpl(repository)
    }
}