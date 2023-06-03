package com.example.nytimesapp.data.remote

import com.example.nytimesapp.data.remote.critics.CriticsResponse
import com.example.nytimesapp.data.remote.reviews.ReviewsResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("critics/all.json?")
    suspend fun getAllCritics(@Query("api-key") appKey:String): Response<CriticsResponse>
//    suspend fun getAllCritics(): Response<CriticsResponse>

    @GET("reviews/search.json?")
    suspend fun getAllReviews(@Query("app_key") appKey:String):Response<ReviewsResponse>

    companion object {

        val appKey = "ua0FkUM6o203AZt9iYPIrah9Wos0a4Yf"
        val defaultRemoteOffset = 20

        private fun createOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(createLoggingInterceptor())
//                .addInterceptor(createAuthorizationInterceptor())
                .build()
        }

        private fun createLoggingInterceptor(): Interceptor {
            return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        }

//        private fun createAuthorizationInterceptor(): Interceptor {
//            return Interceptor { chain ->
//                val newBuilder = chain.request().newBuilder()
//                    .addHeader("app_key", appKey)
//                return@Interceptor chain.proceed(newBuilder.build())
//            }
//        }

        const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"
        var retrofitService: RetrofitService? = null
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(createOkHttpClient())
                    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}