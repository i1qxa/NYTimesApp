package com.example.nytimesapp.data

import android.content.Context
import androidx.room.Room
import com.example.nytimesapp.data.local.AppDatabase
import com.example.nytimesapp.data.local.critics.CriticsDao
import com.example.nytimesapp.data.local.critics.MapperCriticsDB
import com.example.nytimesapp.data.local.reviews.ReviewsDao
import com.example.nytimesapp.data.remote.RetrofitService
import com.example.nytimesapp.data.remote.critics.MapperCriticsRemote

object Repositories {

    private lateinit var applicationContext:Context

    fun init(context:Context){
        applicationContext = context
    }

    private val database:AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "NYTimesDB").build()
    }

    val criticsRepositoryImpl by lazy { CriticsRepositoryImpl(criticsDao, retrofitService,
        mapperCritic) }

    //Mappers
    private val mapperCriticRemote by lazy { MapperCriticsRemote() }

    private val mapperCriticDB by lazy {MapperCriticsDB()}

    private val mapperCritic by lazy { MapperCritic(mapperCriticRemote, mapperCriticDB) }


    //Dao
    private val criticsDao:CriticsDao by lazy { database.criticsDao() }

    private val reviewsDao:ReviewsDao by lazy { database.reviewsDao() }

    //Retrofit
    private val retrofitService:RetrofitService by lazy { RetrofitService.getInstance() }

}