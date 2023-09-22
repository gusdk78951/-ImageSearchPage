package com.hyuna.imagesearchpage.Data

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Call

interface NetWorkInterface {
    @GET("v2/search/image")
    fun getImage(
        @Header("Authorization") Authorization: String?,
        @Query("search") search: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<ImageSearch?>?
}