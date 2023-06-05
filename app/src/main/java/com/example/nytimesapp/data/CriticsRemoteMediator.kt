package com.example.nytimesapp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.nytimesapp.data.local.critics.CriticItemDB
import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.remote.RetrofitService
import com.example.nytimesapp.domain.critics.CriticItemShort

@OptIn(ExperimentalPagingApi::class)
class CriticsRemoteMediator(
    private val criticsDao: CriticsDao,
    private val criticsApi:RetrofitService,
    private val mapperCritic: MapperCritic
):RemoteMediator<Int, CriticItemShort>() {

    private var pageIndex = 0

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CriticItemShort>
    ): MediatorResult {
        pageIndex = getPageIndex(loadType) ?:
                return MediatorResult.Success(endOfPaginationReached = true)

        val limit = state.config.pageSize
        val offset = pageIndex * limit

        return try {
            val critics = fetchCritics()
            if (loadType == LoadType.REFRESH) {
                criticsDao.updateCriticsDB(critics)
            } else {
                criticsDao.getListCritics()
            }
            MediatorResult.Success(
                endOfPaginationReached = critics.size < limit
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private fun getPageIndex(loadType: LoadType): Int? {
        pageIndex = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return null
            LoadType.APPEND -> ++pageIndex
        }
        return pageIndex
    }

    private suspend fun fetchCritics(): List<CriticItemDB> {
        return mapperCritic.mapperRemote.mapListRemoteToDB(
            criticsApi.getAllCritics("ua0FkUM6o203AZt9iYPIrah9Wos0a4Yf")
                .body()?.criticsList ?: emptyList()
        )
    }

}