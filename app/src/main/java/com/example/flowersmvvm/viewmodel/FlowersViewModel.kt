package com.example.flowersmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowersmvvm.model.FlowersModel
import com.example.flowersmvvm.repositories.FlowerRepository
import com.example.flowersmvvm.util.Coroutines

class FlowersViewModel : ViewModel() {

    var flowersList = MutableLiveData<List<FlowersModel>>()

    init {
        refreshList()
    }


    fun refreshList() {

        Coroutines.main {
            val flowersResponse = FlowerRepository().getFlowers()
            if (flowersResponse.isSuccessful) {
                flowersResponse.body()?.let {

                    flowersList.value = it
                    Log.d("flowers_list", flowersList.toString())
                }
            }
        }
    }
}