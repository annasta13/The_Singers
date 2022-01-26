package com.habileducation.thesingers.di

import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.useCase.artistFavourite.GetFavouriteArtist
import com.habileducation.thesingers.data.domain.useCase.artistFavourite.GetFavouriteArtistImpl
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
object ArtistFavouriteModule {

    @Singleton
    @Provides
    fun provideGetFavouriteArtist(repository: Repository): GetFavouriteArtist {
        return GetFavouriteArtistImpl(repository)
    }
}