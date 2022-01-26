package com.habileducation.thesingers.data.util

import com.habileducation.thesingers.data.remote.dto.ArtistResult
import com.habileducation.thesingers.data.remote.dto.SearchResult
import com.habileducation.thesingers.data.remote.dto.SongResult
import com.habileducation.thesingers.util.jsonParser.JsonParserImpl
import org.junit.Test

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class SerializationTest {

    @Test
    fun `artist detail serialization test`(){
        val jsonParser = JsonParserImpl()
        val resource = this::class.java.classLoader!!.getResourceAsStream("artis_detail.json").bufferedReader().use { it.readText() }
        val result = jsonParser.fromJson<ArtistResult>(resource, ArtistResult::class.java)
        assert(result?.response?.artistDto?.names?.get(0) == "Marshall Bruce Mathers III")
    }

    @Test
    fun `song detail serialization test`(){
        val jsonParser = JsonParserImpl()
        val resource = this::class.java.classLoader!!.getResourceAsStream("song_detail.json").bufferedReader().use { it.readText() }
        val result = jsonParser.fromJson<SongResult>(resource, SongResult::class.java)
        assert(result?.response?.songDetail?.title == "Rap God")
    }

    @Test
    fun `search result serialization test`(){
        val jsonParser = JsonParserImpl()
        val resource = this::class.java.classLoader!!.getResourceAsStream("search_song.json").bufferedReader().use { it.readText() }
        val result = jsonParser.fromJson<SearchResult>(resource, SearchResult::class.java)
        assert(result?.response?.hits?.get(0)?.songPreview?.id == 235729)
    }
}