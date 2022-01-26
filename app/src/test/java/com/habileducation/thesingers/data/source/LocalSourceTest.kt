package com.habileducation.thesingers.data.source

import com.habileducation.thesingers.data.local.sources.LocalSource
import com.habileducation.thesingers.data.util.TestUtil
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
class LocalSourceTest {

    private lateinit var localSource: LocalSource

    @Before
    fun init() {
        localSource = Mockito.mock(LocalSource::class.java)
    }

    @Test
    fun `insert artist favourite`() = runBlocking {
        val given = TestUtil.mockedArtistEntity
        localSource.insertArtist(given)
        Mockito.verify(localSource,times(1)).insertArtist(given)
        Mockito.verifyNoMoreInteractions(localSource)
    }

    @Test
    fun `get artist by Id`() = runBlocking {
        val given = TestUtil.mockedArtistEntity
        Mockito.`when`(localSource.getArtistById(given.id)).thenReturn(given)
        val actual = localSource.getArtistById(given.id)
        Assert.assertEquals(actual, given)
    }

    @Test
    fun `delete artist favourite`() = runBlocking {
        val given = TestUtil.mockedArtistEntity
        localSource.deleteArtist(given)
        Mockito.verify(localSource, times(1)).deleteArtist(given)
        Mockito.verifyNoMoreInteractions(localSource)
    }

    @Test
    fun `insert song favourite`() = runBlocking {
        val given = TestUtil.mockedSongEntity
        localSource.insertSong(given)
        Mockito.verify(localSource,times(1)).insertSong(given)
        Mockito.verifyNoMoreInteractions(localSource)
    }

    @Test
    fun `get song by Id`() = runBlocking {
        val given = TestUtil.mockedSongEntity
        Mockito.`when`(localSource.getSongById(given.id)).thenReturn(given)
        val actual = localSource.getSongById(given.id)
        Assert.assertEquals(actual, given)
    }

    @Test
    fun `delete song favourite`() = runBlocking {
        val given = TestUtil.mockedSongEntity
        localSource.deleteSong(given)
        Mockito.verify(localSource, times(1)).deleteSong(given)
        Mockito.verifyNoMoreInteractions(localSource)
    }
}