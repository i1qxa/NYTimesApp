package com.example.nytimesapp.domain.critics

data class CriticItem(
    val id:Float,
    val displayName:String,
    val sortName:String,
    val status:String,
    val bio:String,
    val seoName:String?,
    val criticItemImg: CriticItemImg?,
)
