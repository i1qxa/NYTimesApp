package com.example.nytimesapp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.nytimesapp.data.local.reviews.MapperReviewDB
import com.example.nytimesapp.data.local.reviews.ReviewsDao
import com.example.nytimesapp.domain.reviews.ReviewItem
import com.example.nytimesapp.domain.reviews.ReviewQueryParams
import com.example.nytimesapp.domain.reviews.ReviewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class ReviewRepositoryImpl @Inject constructor(
    private val reviewsDao: ReviewsDao,
    private val remoteMediatorFactory: ReviewsRemoteMediator.Factory,
    private val mapper: MapperReviewDB
) : ReviewsRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getReviewsList(query:String, pageSize:Int)
            : Flow<PagingData<ReviewItem>> {
        return Pager(config = PagingConfig(
            pageSize = PAGE_SIZE,
            initialLoadSize = PAGE_SIZE*3,
        ),
            remoteMediator = remoteMediatorFactory.create(query, pageSize)
        ){
            reviewsDao.getAllReviews(query)
        }
            .flow
            .map { pagingData ->
                pagingData.map { reviewItemDB ->
                    mapper.mapReviewDBToReviewItem(reviewItemDB)
                }
            }
    }

    private companion object {
        const val PAGE_SIZE = 20
    }
}