package com.example.nytimesapp.data.remote.critics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CriticsResponse(
    val status:String,
    val copyright:String,
    @SerialName("num_results")
    val numResults:Int,
    @SerialName("results")
    val criticsList:List<CriticItemRemote>
)
