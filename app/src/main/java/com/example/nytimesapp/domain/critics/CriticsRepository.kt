package com.example.nytimesapp.domain.critics

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface CriticsRepository {

    fun getCriticsList():Flow<PagingData<CriticItemShort>>

    suspend fun updateCriticsList()

     suspend fun getCriticFullInfo():CriticItem

}