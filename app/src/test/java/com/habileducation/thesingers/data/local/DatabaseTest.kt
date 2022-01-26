package com.habileducation.thesingers.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.habileducation.thesingers.data.local.dao.ArtistDao
import com.habileducation.thesingers.data.local.dao.SongDao
import com.habileducation.thesingers.data.util.TestUtil
import com.habileducation.thesingers.util.jsonParser.JsonParser
import com.habileducation.thesingers.util.jsonParser.JsonParserImpl
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class DatabaseTest {
    private lateinit var artistDao: ArtistDao
    private lateinit var songDao: SongDao
    private lateinit var db: AppDatabase
    private lateinit var jsonParser: JsonParser

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        artistDao = db.artistDao()
        songDao = db.songDao()
        jsonParser = JsonParserImpl()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun `write and read artist`() = runBlocking {
        /**given*/
        val expected = TestUtil.mockedArtistEntity
        artistDao.insertArtist(expected)

        /**result*/
        val actual = artistDao.getArtistById(expected.id)
        assert(actual?.names == expected.names)
    }

    @Test
    @Throws(Exception::class)
    fun `write and read song`() = runBlocking {
        /**given*/
        val expected = TestUtil.mockedSongEntity
        songDao.insertSong(expected)

        /**result*/
        val actual = songDao.getSongById(expected.id)
        assert(actual?.title == expected.title)
    }

    @Test
    fun `write and delete artist`() = runBlocking {

        /**given and deleted*/
        val given = TestUtil.mockedArtistEntity
        artistDao.insertArtist(given)
        artistDao.deleteArtist(given)
        /**actual should be null*/
        val actual = artistDao.getArtistById(given.id)
        assert(actual == null)
    }

    @Test
    fun `write and delete song`() = runBlocking {

        /**given and deleted*/
        val given = TestUtil.mockedSongEntity
        songDao.insertSong(given)
        songDao.deleteSong(given)

        /**actual should be null*/
        val actual = songDao.getSongById(given.id)
        assert(actual == null)
    }

}