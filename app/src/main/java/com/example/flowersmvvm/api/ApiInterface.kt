package com.example.flowersmvvm.api

import com.example.flowersmvvm.model.FlowersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("feeds/flowers.json")
    suspend fun getFlowerslist(): Response<List<FlowersModel>>
}