package dev.carlosivis.pokedex.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

internal class HearderInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader(name = "accept", value = "application/json")
            .build()
        return chain.proceed(newRequest)
    }
}