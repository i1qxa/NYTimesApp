package com.example.nytimesapp.data.remote.critics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CriticItemRemote(
    @SerialName("display_name")
    val displayName:String,
    @SerialName("sort_name")
    val sortName:String,
    val status:String,
    val bio:String,
    @SerialName("seo_name")
    val seoName:String,
    val multimedia:MultimediaRemote?,
)