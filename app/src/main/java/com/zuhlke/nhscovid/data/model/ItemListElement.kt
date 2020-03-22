package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class ItemListElement(
    @SerializedName("@type") val type: String,
    val position: Int,
    val item: Item
)