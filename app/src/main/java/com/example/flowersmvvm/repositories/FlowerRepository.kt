package com.example.flowersmvvm.repositories

import com.example.flowersmvvm.api.ApiInterface
import com.example.flowersmvvm.api.RetrofitClient
import com.example.flowersmvvm.model.FlowersModel
import retrofit2.Response

class FlowerRepository {
    suspend fun getFlowers(): Response<List<FlowersModel>> {
        return RetrofitClient.getFlowerService(ApiInterface::class.java).getFlowerslist()
    }
}