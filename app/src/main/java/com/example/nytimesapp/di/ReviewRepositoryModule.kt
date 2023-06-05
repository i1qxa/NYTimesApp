package com.example.nytimesapp.di

import androidx.paging.ExperimentalPagingApi
import com.example.nytimesapp.data.ReviewRepositoryImpl
import com.example.nytimesapp.domain.reviews.ReviewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
interface ReviewRepositoryModule {
    @Binds
    fun bindReviewRepository(
        reviewRepository: ReviewRepositoryImpl
    ): ReviewsRepository
}