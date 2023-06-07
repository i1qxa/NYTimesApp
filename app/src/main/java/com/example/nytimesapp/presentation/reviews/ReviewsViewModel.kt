package com.example.nytimesapp.presentation.reviews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.nytimesapp.domain.reviews.ReviewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor (
    private val reviewsRepository: ReviewsRepository
) : ViewModel() {

    val reviewsFlow = reviewsRepository.getReviewsList(null).cachedIn(viewModelScope)

}
