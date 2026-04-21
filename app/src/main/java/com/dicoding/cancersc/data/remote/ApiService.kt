package com.dicoding.cancersc.data.remote

import com.dicoding.cancersc.data.response.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getCancerNews(
        @Query("q") q: String = "cancer",
        @Query("language") language: String = "en",
        @Query("category") category: String = "health",
    ): Call<Response>
}