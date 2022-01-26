package com.habileducation.thesingers.util.jsonParser

import java.lang.reflect.Type

/**
 * Created by Annas Surdyanto on 23/12/21.
 *
 */
interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?
    fun <T> toJson(obj: T, type: Type): String?
}