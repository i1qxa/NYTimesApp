package com.example.nytimesapp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.nytimesapp.data.local.reviews.ReviewItemDB
import com.example.nytimesapp.data.local.reviews.ReviewsDao
import com.example.nytimesapp.data.remote.reviews.MapperReviewRemote
import com.example.nytimesapp.data.remote.reviews.ReviewItemRemote
import com.example.nytimesapp.data.remote.reviews.ReviewsApi
import com.example.nytimesapp.domain.reviews.ReviewQueryParams
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class NewRemoteMediator @AssistedInject constructor(
    private val reviewsDao: ReviewsDao,
    private val reviewApi: ReviewsApi,
    private val mapper: MapperReviewRemote,
    @Assisted private val reviewQueryParams: ReviewQueryParams?
) : RemoteMediator<Int, ReviewItemDB>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ReviewItemDB>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()

                    if (lastItem == null) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }

                    lastItem.id
                }
            }


            val response = state.anchorPosition?.let { it -> fetchReviewsRemote(it) }

            if (loadType == LoadType.REFRESH) {
                response?.let { reviewsDao.updateReviewsData(it) }
            }
            else if (loadType == LoadType.APPEND) response?.let { reviewsDao.insertListReviews(it)}

            MediatorResult.Success(
//                endOfPaginationReached = response.nextKey == null
                endOfPaginationReached = true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
    private suspend fun fetchReviewsRemote(offset:Int):List<ReviewItemDB>{
        return mapper.mapListReviewRemoteToListDB(reviewApi.getAllReviews(
            offset = offset,
            query = reviewQueryParams?.query,
            dateRange = reviewQueryParams?.dateRange,
        ).body()?.reviewsList?: emptyList())
    }
}