package com.example.nytimesapp.domain.critics

interface CriticsRepository {

    suspend fun getCriticsList():List<CriticItemShort>

    suspend fun updateCriticsList()

    suspend fun getCriticFullInfo():CriticItem

}