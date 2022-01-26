package com.habileducation.thesingers.util.jsonParser

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
class JsonParserImpl: JsonParser {

    private val moshi = Moshi.Builder().build()
    override fun <T> fromJson(json: String, type: Type): T? {
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(type)
        return jsonAdapter.fromJson(json)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(type)
        return jsonAdapter.toJson(obj)
    }
}