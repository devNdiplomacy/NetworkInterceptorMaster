package com.devndiplomacy.networkinterceptormaster.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApplicationInterceptor: BaseInterceptor() {

    override fun intercept(chain: Interceptor.Chain): Response {

        logOnInterceptEvent(javaClass.simpleName)
        return chain.proceed(chain.request())

    }
}