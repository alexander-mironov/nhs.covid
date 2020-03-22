package com.zuhlke.nhscovid.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nhs.uk/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val nhsService: NhsService = retrofit.create(NhsService::class.java)
}