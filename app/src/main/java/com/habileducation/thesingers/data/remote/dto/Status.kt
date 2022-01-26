package com.habileducation.thesingers.data.remote.dto

import com.squareup.moshi.Json

data class Status(
    @field:Json(name = "status") val status: Int
)