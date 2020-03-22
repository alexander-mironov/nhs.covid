package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class Author(
    val url: String,
    val logo: String,
    val email: String,
    @SerializedName("@type") val type: String,
    val name: String
)