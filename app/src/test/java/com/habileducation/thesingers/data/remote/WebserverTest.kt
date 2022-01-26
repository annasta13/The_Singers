package com.habileducation.thesingers.data.remote

import com.habileducation.thesingers.data.util.TestUtil
import com.habileducation.thesingers.data.util.TestUtil.Companion.getResponseBody
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class WebserverTest {

    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("http://localhost:8080")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Before
    @Throws(IOException::class)
    fun setUp() {
        mockWebServer.start(8080)

    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `get artist detail return success`() = runBlocking {
        val artist = TestUtil.mockedArtistEntity
        val body = getResponseBody("artis_detail.json")
        val mockedResponse = MockResponse().setBody(body)
        mockWebServer.enqueue(mockedResponse)
        val result = api.getArtistDetail(artist.id)
        assert(result.response.artistDto.names?.get(0) == artist.names)
    }

    @Test
    fun `get song detail return success`() = runBlocking {
        val song = TestUtil.mockedSongEntity
        val body = getResponseBody("song_detail.json")
        val mockedResponse = MockResponse().setBody(body)
        mockWebServer.enqueue(mockedResponse)
        val result = api.getSongDetail(song.id)
        assert(result.response.songDetail.title == song.title)
    }

    @Test
    fun `get searched song return success`() = runBlocking {
        val song = TestUtil.mockedSongEntity
        val body = getResponseBody("search_song.json")
        val mockedResponse = MockResponse().setBody(body)
        mockWebServer.enqueue(mockedResponse)
        val result = api.getSongSearched("eminem")
        assert(result.response.hits[0].songPreview.title == song.title)
    }
}