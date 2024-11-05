package com.devndiplomacy.networkinterceptormaster.interceptor

import android.util.Log
import okhttp3.Interceptor


abstract class BaseInterceptor : Interceptor {

    private val TAG:String = javaClass.simpleName

    fun logOnInterceptEvent(name:String){
        Log.d(TAG, "onIntercept () called by $name")
    }

}