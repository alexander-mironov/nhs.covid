package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class InteractionService(
    val url: String,
    @SerializedName("@type") val type: String,
    val name: String
)