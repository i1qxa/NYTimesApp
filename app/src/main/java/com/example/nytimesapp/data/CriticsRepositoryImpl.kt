package com.example.nytimesapp.data

import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.remote.RetrofitService
import com.example.nytimesapp.domain.critics.CriticItem
import com.example.nytimesapp.domain.critics.CriticItemShort
import com.example.nytimesapp.domain.critics.CriticsRepository

class CriticsRepositoryImpl(
    private val criticsDao: CriticsDao,
    private val retrofitService: RetrofitService, private val mapperCritic: MapperCritic
):CriticsRepository {

    override suspend fun getCriticsList(): List<CriticItemShort> {
        var listCriticsDao = criticsDao.getListCritics()
        if (listCriticsDao.isEmpty()){
            updateCriticsList()
            listCriticsDao = criticsDao.getListCritics()
        }
        val listCriticItem = mapperCritic.mapperDB.mapListDBToListCriticsItem(listCriticsDao)
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