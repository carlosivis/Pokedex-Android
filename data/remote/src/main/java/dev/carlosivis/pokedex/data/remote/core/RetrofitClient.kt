package dev.carlosivis.pokedex.data.remote.core

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val TIMEOUT_LIMIT: Long = 5

    operator fun invoke(
        interceptor: Interceptor?
    ): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            interceptor?.let { addInterceptor(it) }
            // Logging interceptor for debug if (BuildConfig.DEBUG)
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            connectTimeout(TIMEOUT_LIMIT, TimeUnit.MINUTES)
            callTimeout(TIMEOUT_LIMIT, TimeUnit.MINUTES)
            readTimeout(TIMEOUT_LIMIT, TimeUnit.MINUTES)
            writeTimeout(TIMEOUT_LIMIT, TimeUnit.MINUTES)
        }.build()
    }
}