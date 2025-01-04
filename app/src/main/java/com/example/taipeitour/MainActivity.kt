package com.example.taipeitour

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taipeitour.data.Spot
import com.example.taipeitour.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private val job = Job() + Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        launch {
//            val client = OkHttpClient()
//            val request = Request.Builder()
//                .url("https://www.travel.taipei/open-api/zh-tw/Events/Activity?page=1")
//                .get()
//                .addHeader("accept", "application/json")
//                .build()
//            val response = client.newCall(request).execute()
////            Log.d(TAG, "onCreate1: ${response.body?.string()}")
//            val spot = Gson().fromJson(response.body?.string(), Spot::class.java)
//        }
    }

    override val coroutineContext: CoroutineContext
        get() = job
}