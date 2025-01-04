package com.example.taipeitour.viewmodel

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

    val spotLiveData = MutableLiveData<List<Spot>>()
    val selectedSpot = MutableLiveData<Spot>()
    var langLiveData = MutableLiveData("zh-tw")

    fun fetchSpot() {
        val client = OkHttpClient()
        viewModelScope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://www.travel.taipei/open-api/${langLiveData.value}/Attractions/All?page=1")
                .get()
                .addHeader("accept", "application/json")
                .build()
            val response = client.newCall(request).execute()
            val spots = Gson().fromJson(response.body?.string(), Spots::class.java)
            spotLiveData.postValue(spots.data)
        }
    }

    fun selectedLang(lang: String) {
        this.langLiveData.value = lang
    }
}