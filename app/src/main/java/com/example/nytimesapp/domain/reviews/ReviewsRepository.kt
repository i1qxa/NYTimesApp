package com.example.nytimesapp.domain.reviews

interface ReviewsRepository {

    suspend fun updateReviews()

    suspend fun getReviewsList():List<ReviewItem>

}