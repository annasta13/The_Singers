package com.habileducation.thesingers.di

import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.domain.useCase.artistDetail.*
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
object ArtistDetailModule {

    @Singleton
    @Provides
    fun provideGetArtistDetail(repository: Repository): GetArtistDetail {
        return GetArtistDetailImpl(repository)
    }

    @Singleton
    @Provides
    fun provideInsertArtistFavourite(repository: Repository): InsertArtistFavourite {
        return InsertArtistFavouriteImpl(repository)
    }

    @Singleton
    @Provides
    fun provideDeleteArtistFavourite(repository: Repository): DeleteArtistFavourite {
        return DeleteArtistFavouriteImpl(repository)
    }


    @Singleton
    @Provides
    fun provideArtistDetailUseCase(
        getArtistDetail: GetArtistDetail,
        insertArtistFavourite: InsertArtistFavourite,
        deleteArtistFavourite: DeleteArtistFavourite
    ): ArtistDetailUseCase {
        return ArtistDetailUseCase(getArtistDetail, insertArtistFavourite, deleteArtistFavourite)
    }
}