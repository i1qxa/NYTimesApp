package com.example.nytimesapp.data.local.critics

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class CriticItemDB(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val displayName:String,
    val sortName:String,
    val status:String,
    val bio:String,
    val seoName:String,
    val imgSrcLocal: String,
)
