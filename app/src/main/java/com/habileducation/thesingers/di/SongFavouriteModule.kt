package com.habileducation.thesingers.di

import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.useCase.songFavourite.GetFavouriteSong
import com.habileducation.thesingers.data.domain.useCase.songFavourite.GetFavouriteSongImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Annas Surdyanto on 24/12/21.
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object SongFavouriteModule {

    @Singleton
    @Provides
    fun provideGetFavouriteSong(repository: Repository): GetFavouriteSong {
        return GetFavouriteSongImpl(repository)
    }
}