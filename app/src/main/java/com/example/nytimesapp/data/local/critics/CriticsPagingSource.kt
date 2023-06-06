package com.example.nytimesapp.data.local.critics

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.nytimesapp.data.Repositories
import com.example.nytimesapp.domain.critics.CriticItemShort

class CriticsPagingSource:PagingSource<Int, CriticItemShort>() {
    val repo = Repositories.criticsRepositoryImpl
    override fun getRefreshKey(state: PagingState<Int, CriticItemShort>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CriticItemShort> {
//        val pageIndex = params.key?:0
//        return try {
//            val criticsDB:List<CriticItemDB> = repo.getCriticsList()
//        }
//        catch (e:Exeption){
//
//        }
        TODO()
    }
}