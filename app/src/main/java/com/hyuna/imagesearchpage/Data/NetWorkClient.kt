package com.hyuna.imagesearchpage.Data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetWorkClient {
    private const val IMAGE_SEARCH_URL = "https://dapi.kakao.com/"

    val apiService: NetWorkInterface
        get() = instance.create(NetWorkInterface::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(IMAGE_SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}