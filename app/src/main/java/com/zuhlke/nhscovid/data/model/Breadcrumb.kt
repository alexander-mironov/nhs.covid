package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class Breadcrumb(
    @SerializedName("@context") val context: String,
    @SerializedName("@type") val type: String,
    val itemListElement: List<ItemListElement>
)