package com.example.nytimesapp.data.local.critics

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface CriticsDao {

    @Query("SELECT * FROM CriticItemDB")
    fun getListCritics():PagingSource<Int, CriticItemDB>

    @Insert
    suspend fun insertListCritics(listCritics:List<CriticItemDB>)

    @Query("DELETE FROM CriticItemDB")
    suspend fun clearCriticsDB()

    @Transaction
    suspend fun updateCriticsDB(newListCritics:List<CriticItemDB>){
        clearCriticsDB()
        insertListCritics(newListCritics)
    }

}