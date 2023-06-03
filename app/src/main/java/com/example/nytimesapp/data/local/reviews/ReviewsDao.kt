package com.example.nytimesapp.data.local.reviews

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ReviewsDao {

    @Query("SELECT * FROM ReviewItemDB")
    suspend fun getAllReviews():List<ReviewItemDB>

    @Insert
    suspend fun insertListReviews(listReviews:List<ReviewItemDB>)

    @Delete
    suspend fun clearReviewsDB()

    @Transaction
    suspend fun updateReviewsData(newListReviews:List<ReviewItemDB>){
        clearReviewsDB()
        insertListReviews(newListReviews)
    }

}