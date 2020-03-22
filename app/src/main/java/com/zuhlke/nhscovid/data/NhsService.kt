package com.zuhlke.nhscovid.data

import com.zuhlke.nhscovid.data.model.CoronavirusResponse
import retrofit2.Call
import retrofit2.http.GET

interface NhsService {
    @GET("conditions/coronavirus-covid-19/?url=www.nhs.uk")
    fun getCoronavirusInfo(): Call<CoronavirusResponse>
}