package com.example.nytimesapp.di

import com.example.nytimesapp.data.local.reviews.MapperReviewDB
import com.example.nytimesapp.data.remote.reviews.MapperReviewRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReviewMapperModule {

    @Singleton
    @Provides
    fun provideReviewRemoteMapper() = MapperReviewRemote()

    @Singleton
    @Provides
    fun provideReviewDBMapper() = MapperReviewDB()

}