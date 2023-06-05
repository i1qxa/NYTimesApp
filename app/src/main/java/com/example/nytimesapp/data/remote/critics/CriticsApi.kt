package com.example.nytimesapp.data.remote.critics

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CriticsApi {
    @GET("critics/all.json?")
    suspend fun getAllCritics(@Query("api-key") appKey: String = "ua0FkUM6o203AZt9iYPIrah9Wos0a4Yf"): Response<CriticsResponse>
}