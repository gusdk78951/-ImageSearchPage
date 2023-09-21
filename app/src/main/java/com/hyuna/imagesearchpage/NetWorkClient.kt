package com.hyuna.imagesearchpage

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {
    private const val IMAGE_SEARCH_URL = "https://dapi.kakao.com/"

    private val imageSearchRetrofit = Retrofit.Builder()
        .baseUrl(IMAGE_SEARCH_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val imageSearchNetwork: NetWorkInterface = imageSearchRetrofit.create(NetWorkInterface::class.java)
}