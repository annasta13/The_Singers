package com.habileducation.thesingers.data.remote

import com.habileducation.thesingers.BuildConfig
import com.habileducation.thesingers.data.remote.dto.ArtistResult
import com.habileducation.thesingers.data.remote.dto.SearchResult
import com.habileducation.thesingers.data.remote.dto.SongResult
import com.habileducation.thesingers.util.Constant.apiKey
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


/**
 * Created by Annas Surdyanto on 30/04/21.
 *
 */
interface ApiService {

    @Headers(apiKey)
    @GET("artists/{id}")
    suspend fun getArtistDetail(@Path("id") id: Int): ArtistResult


    @Headers(apiKey)
    @GET("songs/{id}")
    suspend fun getSongDetail(@Path("id") id: Int): SongResult

    @Headers(apiKey)
    @GET("search")
    suspend fun getSongSearched(@Query("q")s: String): SearchResult


    /*========================================== BUILDER =========================================*/

    companion object {
        fun create(): ApiService {
            val logger =
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }

            val client = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}

