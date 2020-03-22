package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class CoronavirusResponse(
    @SerializedName("@context") val context: String,
    @SerializedName("@type") val type: String,
    val copyrightHolder: CopyrightHolder,
    val license: String,
    val author: Author,
    val name: String,
    val description: String,
    val url: String,
    val lastReviewed: List<String>,
    val breadcrumb: Breadcrumb,
    val dateModified: String,
    val genre: String,
    val hasPart: List<HasPart>,
    val relatedLink: List<RelatedLink>,
    val keywords: List<String>,
    val alternateName: List<String>,
    val interactionStatistic: List<InteractionStatistic>,
    val mainEntityOfPage: List<MainEntityOfPage>,
    val alternativeHeadline: String
)