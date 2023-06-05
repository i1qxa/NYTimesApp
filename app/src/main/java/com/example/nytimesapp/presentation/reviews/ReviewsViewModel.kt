package com.example.nytimesapp.presentation.reviews

import androidx.lifecycle.ViewModel
import com.example.nytimesapp.domain.reviews.ReviewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor (
    private val reviewsRepository: ReviewsRepository
) : ViewModel() {
    // TODO: Implement the ViewModel
}