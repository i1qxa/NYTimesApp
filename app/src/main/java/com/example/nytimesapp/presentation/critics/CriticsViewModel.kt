package com.example.nytimesapp.presentation.critics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.data.Repositories
import kotlinx.coroutines.launch

class CriticsViewModel():ViewModel() {

    private val criticsRepository = Repositories.criticsRepositoryImpl

    suspend fun getCriticsList(){
        viewModelScope.launch {
            criticsRepository.updateCriticsList()
        }
    }

}