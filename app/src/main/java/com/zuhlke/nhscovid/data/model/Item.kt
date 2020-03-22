package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("@id") val id: String,
    val name: String,
    val genre: String
)