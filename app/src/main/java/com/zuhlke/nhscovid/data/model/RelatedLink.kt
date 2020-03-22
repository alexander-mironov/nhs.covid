package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class RelatedLink(
    @SerializedName("@type") val type: String,
    val url: String,
    val linkRelationship: String,
    val position: Int,
    val name: String,
    val alternativeHeadline: String
)