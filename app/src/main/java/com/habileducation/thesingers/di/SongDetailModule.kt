package com.habileducation.thesingers.di

import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.useCase.songDetail.*
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
object SongDetailModule {

    @Singleton
    @Provides
    fun provideGetSongDetail(repository: Repository): GetSongDetail {
        return GetSongDetailImpl(repository)
    }

    @Singleton
    @Provides
    fun provideInsertSongFavourite(repository: Repository): InsertSongFavourite {
        return InsertSongFavouriteImpl(repository)
    }

    @Singleton
    @Provides
    fun provideDeleteSongFavourite(repository: Repository): DeleteSongFavourite {
        return DeleteSongFavouriteImpl(repository)
    }

    @Singleton
    @Provides
    fun provideSongDetailUseCase(
        getSongDetail: GetSongDetail,
        insertSongFavourite: InsertSongFavourite,
        deleteSongFavourite: DeleteSongFavourite
    ): SongDetailUseCase {
        return SongDetailUseCase(getSongDetail, insertSongFavourite, deleteSongFavourite)
    }
}