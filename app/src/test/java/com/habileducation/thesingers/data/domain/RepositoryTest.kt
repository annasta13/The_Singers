package com.habileducation.thesingers.data.domain

import com.habileducation.thesingers.data.domain.repository.Repository
import com.habileducation.thesingers.data.remote.dto.*
import com.habileducation.thesingers.data.util.TestUtil.Companion.getResponseBody
import com.habileducation.thesingers.util.jsonParser.JsonParser
import com.habileducation.thesingers.util.jsonParser.JsonParserImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class RepositoryTest {

    private lateinit var repository: Repository
    private var jsonParser: JsonParser = JsonParserImpl()

    @Before
    fun init() {
        repository = Mockito.mock(Repository::class.java)
    }

    @Test
    fun `get artist`() = runBlocking {
        val result = getResponseBody("artis_detail.json")
        val given = jsonParser.fromJson<ArtistResult>(result, ArtistResult::class.java)!!
        val id = given.response.artistDto.id
        Mockito.`when`(repository.getArtistDetail(id)).thenReturn(flowOf(Result.success(given.asArtist(false))))

        val actual = repository.getArtistDetail(id).first().getOrNull()

        Assert.assertEquals(actual?.id, given.response.artistDto.id)
        Mockito.verify(repository).getArtistDetail(id)
        Mockito.verify(repository, Mockito.times(1)).getArtistDetail(id)
        Mockito.verifyNoMoreInteractions(repository)
    }

    @Test
    fun `get song`() = runBlocking {
        val result = getResponseBody("song_detail.json")
        val given = jsonParser.fromJson<SongResult>(result, SongResult::class.java)!!
        val id = given.response.songDetail.id
        Mockito.`when`(repository.getSongDetail(id)).thenReturn(flowOf(Result.success(given.asSong(false))))

        val actual = repository.getSongDetail(id).first().getOrNull()

        Assert.assertEquals(actual?.id, given.response.songDetail.id)
        Mockito.verify(repository).getSongDetail(id)
        Mockito.verify(repository, Mockito.times(1)).getSongDetail(id)
        Mockito.verifyNoMoreInteractions(repository)
    }

    @Test
    fun `search song`() = runBlocking {
        val result = getResponseBody("search_song.json")
        val given = jsonParser.fromJson<SearchResult>(result, SearchResult::class.java)!!
        val key = "eminem"
        Mockito.`when`(repository.searchSong(key)).thenReturn(flowOf(Result.success(given.asSongPreviewList())))

        val actual = repository.searchSong(key).first().getOrNull()

        Assert.assertTrue(actual?.isNotEmpty() == true)
        Mockito.verify(repository).searchSong(key)
        Mockito.verify(repository, Mockito.times(1)).searchSong(key)
        Mockito.verifyNoMoreInteractions(repository)
    }


}