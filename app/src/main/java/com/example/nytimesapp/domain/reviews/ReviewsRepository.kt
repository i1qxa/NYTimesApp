package com.example.nytimesapp.domain.reviews

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface ReviewsRepository {

    fun getReviewsList(query:String, pageSize:Int):Flow<PagingData<ReviewItem>>

}