package com.devndiplomacy.networkinterceptormaster

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devndiplomacy.networkinterceptormaster.interceptor.ApplicationInterceptor
import com.devndiplomacy.networkinterceptormaster.interceptor.NetworkInterceptor
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class InterceptorViewModel(
    applicationInterceptor: ApplicationInterceptor = ApplicationInterceptor(),
    networkInterceptor: NetworkInterceptor = NetworkInterceptor(),
) : ViewModel() {

    //This will ideally be in Some Hilt or Dagger Module but for now , I am adding it here
    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(applicationInterceptor)
        .addNetworkInterceptor(networkInterceptor)
        .eventListener(CustomOkhttpEventListener())
        .build()

    private var url = "https://api.spacexdata.com/v3"

    fun initiateDummyCall() {
        viewModelScope.launch {
            val request = Request.Builder().url(url).build()
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                    Log.d("InterceptorViewModel", "onFailure() called with: call = $call, e = $e")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("InterceptorViewModel", "onResponse() called with: call = $call, response = ${response.body?.string()}")
                }

            })
        }
    }


}