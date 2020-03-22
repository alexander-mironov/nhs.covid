package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class HasPart(
    @SerializedName("@type") val type: String,
    val name: String,
    val url: String,
    val description: String,
    val text: String
)