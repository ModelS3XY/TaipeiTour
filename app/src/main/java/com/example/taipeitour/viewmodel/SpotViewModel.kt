package com.example.taipeitour.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taipeitour.data.Spot
import com.example.taipeitour.data.Spots
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class SpotViewModel: ViewModel() {

    private val TAG = SpotViewModel::class.java.simpleName
    val spotLiveData = MutableLiveData<List<Spot>>()
    val selectedSpot = MutableLiveData<Spot>()

    fun fetchSpot() {
        val client = OkHttpClient()
        viewModelScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://www.travel.taipei/open-api/zh-tw/Attractions/All?page=1")
                .get()
                .addHeader("accept", "application/json")
                .build()
            val response = client.newCall(request).execute()
//            Log.d(TAG, "onCreate1: ${response.body?.string()}")
            val spots = Gson().fromJson(response.body?.string(), Spots::class.java)
            spotLiveData.postValue(spots.data)
        }
    }

    fun selectedSpot(spot: Spot) {
        selectedSpot.value = spot
    }
}