package com.example.nytimesapp.data.remote.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkRemote(
    val type:String,
    val url:String,
    @SerialName("suggested_link_text")
    val suggestedLinkText:String,
)
