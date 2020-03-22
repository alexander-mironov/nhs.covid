package com.zuhlke.nhscovid.data.model

import com.google.gson.annotations.SerializedName

data class InteractionStatistic(
    val interactionService: InteractionService,
    @SerializedName("@type") val type: String
)