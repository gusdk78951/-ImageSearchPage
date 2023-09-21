package com.hyuna.imagesearchpage

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetWorkInterface {
    @GET("v2/search/image")
    fun getImage(
        @Header("Authorization") Authorization: String?,
        @Query("search") search: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ImageSearch
}