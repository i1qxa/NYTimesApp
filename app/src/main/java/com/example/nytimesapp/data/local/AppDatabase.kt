package com.example.nytimesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nytimesapp.data.local.critics.CriticItemDB
import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.local.reviews.ReviewItemDB
import com.example.nytimesapp.data.local.reviews.ReviewsDao

@Database(
    version = 1,
    entities = [
        CriticItemDB::class,
        ReviewItemDB::class
    ],
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun criticsDao():CriticsDao
    abstract fun reviewsDao():ReviewsDao

}