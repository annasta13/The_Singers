package com.habileducation.thesingers.data.source

import com.habileducation.thesingers.data.remote.dto.ArtistResult
import com.habileducation.thesingers.data.remote.dto.SearchResult
import com.habileducation.thesingers.data.remote.dto.SongResult
import com.habileducation.thesingers.data.remote.sources.RemoteSource
import com.habileducation.thesingers.data.util.TestUtil.Companion.getResponseBody
import com.habileducation.thesingers.util.jsonParser.JsonParser
import com.habileducation.thesingers.util.jsonParser.JsonParserImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class RemoteSourceTest {

    private lateinit var remoteSource: RemoteSource
    private var jsonParser: JsonParser = JsonParserImpl()

    @Before
    fun init() {
        remoteSource = Mockito.mock(RemoteSource::class.java)
    }

    @Test
    fun `get artist should return success`() = runBlocking {
        val result = getResponseBody("artis_detail.json")
        val given = jsonParser.fromJson<ArtistResult>(result, ArtistResult::class.java)!!
        val id = 123
        Mockito.`when`(remoteSource.getArtist(id)).thenReturn(given)

        val actual = remoteSource.getArtist(id)

        Assert.assertTrue(actual.meta.status == 200)
        Mockito.verify(remoteSource, times(1)).getArtist(id)
        Mockito.verifyNoMoreInteractions(remoteSource)
    }

    @Test
    fun `get song should return success`() = runBlocking {
        val result = getResponseBody("song_detail.json")
        val given = jsonParser.fromJson<SongResult>(result, SongResult::class.java)!!
        val id = 123
        Mockito.`when`(remoteSource.getSong(id)).thenReturn(given)

        val actual = remoteSource.getSong(id)

        Assert.assertTrue(actual.meta.status == 200)
        Mockito.verify(remoteSource, times(1)).getSong(id)
        Mockito.verifyNoMoreInteractions(remoteSource)
    }

    @Test
    fun `search song`() = runBlocking {
        val key = "eminem"
        val result = getResponseBody("search_song.json")
        val given = jsonParser.fromJson<SearchResult>(result, SearchResult::class.java)!!
        Mockito.`when`(remoteSource.searchSong(key)).thenReturn(given)
        val actual = remoteSource.searchSong(key)
        Assert.assertTrue(actual.meta.status == 200)
        Mockito.verify(remoteSource).searchSong(key)
        Mockito.verify(remoteSource, times(1)).searchSong(key)
        Mockito.verifyNoMoreInteractions(remoteSource)
    }
}