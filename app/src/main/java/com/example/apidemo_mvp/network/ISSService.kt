package com.example.apidemo_mvp.network

import com.example.apidemo_mvp.ISS_ENDPOINT
import com.example.apidemo_mvp.model.ISSResponse
import com.example.apidemo_mvp.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ISSService {

    @GET("population/{country}/{age}")
    fun getISSPasses(@Path("country") country: String,
                     @Path("age") age: Int): Call<List<Response>>
}