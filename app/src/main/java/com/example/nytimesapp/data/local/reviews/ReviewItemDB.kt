package com.example.nytimesapp.data.local.reviews

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class ReviewItemDB(
    @PrimaryKey(autoGenerate = true)
    val id: Float,
    val displayTitle: String,
    val mpaaRating: String,
    val criticsPick: Int,
    val byline: String,
    val headline: String,
    val summaryShort: String,
    val publicationDate: Date,
    val opening_date: Date,
    val dateUpdated: String,
    val link: String,
    val imgSrcLocal: String,
)
