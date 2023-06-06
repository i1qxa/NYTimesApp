package com.example.nytimesapp.data

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.remote.RetrofitService
import com.example.nytimesapp.domain.critics.CriticItem
import com.example.nytimesapp.domain.critics.CriticItemShort
import com.example.nytimesapp.domain.critics.CriticsRepository
import kotlinx.coroutines.flow.Flow

class CriticsRepositoryImpl(
    private val criticsDao: CriticsDao,
    private val retrofitService: RetrofitService, private val mapperCritic: MapperCritic
):CriticsRepository {

    override fun getCriticsList(): Flow<PagingData<CriticItemShort>> {
        var listCriticsDao = criticsDao.getListCritics()
//        if (listCriticsDao.isEmpty()){
//            updateCriticsList()
//            listCriticsDao = criticsDao.getListCritics()
//        }
//        val listCriticItem = mapperCritic.mapperDB.mapListDBToListCriticsItem(listCriticsDao)
//        return mapperCritic.mapListCriticItemToCriticItemShort(listCriticItem)
        return TODO()
    }

    override suspend fun updateCriticsList() {
            val response = retrofitService.getAllCritics("ua0FkUM6o203AZt9iYPIrah9Wos0a4Yf")
//        val response = retrofitService.getAllCritics()
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