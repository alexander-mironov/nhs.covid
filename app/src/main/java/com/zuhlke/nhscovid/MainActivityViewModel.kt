package com.zuhlke.nhscovid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zuhlke.nhscovid.data.RetrofitService
import com.zuhlke.nhscovid.data.model.CoronavirusResponse
import com.zuhlke.nhscovid.data.model.MainEntityOfPage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivityViewModel: ViewModel() {

    private val _entities = MutableLiveData<List<MainEntityOfPage>>()
    val entities: LiveData<List<MainEntityOfPage>> = _entities

    fun loadData() {
        RetrofitService.nhsService.getCoronavirusInfo().enqueue(object: Callback<CoronavirusResponse> {
            override fun onFailure(call: Call<CoronavirusResponse>, t: Throwable) {
                Timber.e(t, "Can't get response")
            }

            override fun onResponse(
                call: Call<CoronavirusResponse>,
                response: Response<CoronavirusResponse>
            ) {
                Timber.d("Got the response")
                handle(response.body())
            }
        })
    }

    private fun handle(coronavirusResponse: CoronavirusResponse?) {
        if (coronavirusResponse == null) {
            return
        }

        val flattenList = mutableListOf<MainEntityOfPage>()
        coronavirusResponse.mainEntityOfPage.forEach {
            flatMapAll(it, flattenList)
        }

        _entities.value = flattenList
    }

    private fun flatMapAll(mainEntityOfPage: MainEntityOfPage, list: MutableList<MainEntityOfPage>) {
        list.add(mainEntityOfPage)
        if (mainEntityOfPage.mainEntityOfPage != null) {
            for (entity in mainEntityOfPage.mainEntityOfPage) {
                flatMapAll(entity, list)
            }
        }
    }
}