package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class CopyrightHolder(
    val name: String,
    @SerializedName("@type") val type: String
)