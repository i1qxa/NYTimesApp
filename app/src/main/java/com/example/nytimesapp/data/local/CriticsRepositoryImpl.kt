package com.example.nytimesapp .data.local

import com.example.nytimesapp.data.MapperCritic
import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.remote.RetrofitService
import com.example.nytimesapp.domain.critics.CriticItem
import com.example.nytimesapp.domain.critics.CriticItemShort
import com.example.nytimesapp.domain.critics.CriticsRepository

class CriticsRepositoryImpl(criticsDao:CriticsDao, retrofitService:RetrofitService, mapperCritic: MapperCritic):CriticsRepository {

    private val retrofitService = retrofitService
    private val criticsDao = criticsDao
    private val mapperCritic = mapperCritic

    override suspend fun getCriticsList(): List<CriticItemShort> {
        val listCriticItem = mapperCritic.mapperDB.mapListDBToListCriticsItem(criticsDao.getListCritics())
        return mapperCritic.mapListCriticItemToCriticItemShort(listCriticItem)
    }

    override suspend fun updateCriticsList() {
        val response = retrofitService.getAllCritics("ua0FkUM6o203AZt9iYPIrah9Wos0a4Yf")
        if (response.isSuccessful){
            val listCriticsRemote = response.body()?.criticsList
            if (listCriticsRemote!=null){
                criticsDao.updateCriticsDB(mapperCritic.mapperRemote.mapListRemoteToDB(listCriticsRemote))
            }
        }
        else{

        }
    }

    override suspend fun getCriticFullInfo(): CriticItem {
        TODO("Not yet implemented")
    }
}