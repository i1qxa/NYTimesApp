package com.example.nytimesapp.domain.critics

data class CriticItemImg(
    val id:Long,
    val srcRemote:String,
    val srcLocal:String,
    val imgHeight:Int,
    val imgWidth:Int,
    val credit:String?,
)
