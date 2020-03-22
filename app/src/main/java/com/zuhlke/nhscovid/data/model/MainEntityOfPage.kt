package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class MainEntityOfPage(
    val identifier: Int,
    val name: String,
    val position: Int,
    @SerializedName("@type") val type: String,
    val headline: String?,
    val text: String?,
    val mainEntityOfPage: List<MainEntityOfPage>?
)