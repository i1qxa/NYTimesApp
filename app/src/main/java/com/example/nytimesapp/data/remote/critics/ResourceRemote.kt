package com.example.nytimesapp.data.remote.critics

import kotlinx.serialization.Serializable

@Serializable
data class ResourceRemote(
    val type:String,
    val src:String,
    val height:Int,
    val width:Int,
    val credit:String,
)
