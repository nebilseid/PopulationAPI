package com.example.ui.home

import com.example.apidemo_mvp.model.ISSResponse
import com.example.apidemo_mvp.network.ISSService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val issService: ISSService,
    private val view: HomeContract.View) : HomeContract.Presenter {



    override fun getISSPasses(country: String, age: Int) {
        issService.getISSPasses(country.toString(), age.toInt()).enqueue(object : Callback<List<com.example.apidemo_mvp.model.Response>> {
            override fun onFailure(call: Call<List<com.example.apidemo_mvp.model.Response>>, t: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(
                call: Call<List<com.example.apidemo_mvp.model.Response>>,
                response: Response<List<com.example.apidemo_mvp.model.Response>>
            ) {
                if (response.isSuccessful) {
                    view.showResults(response.body() ?: emptyList())
                } else {
                    view.showError("An unknown error occurred")
                }
            }


        })
    }

}
