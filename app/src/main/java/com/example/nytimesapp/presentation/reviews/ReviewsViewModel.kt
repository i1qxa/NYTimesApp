package com.example.nytimesapp.presentation.reviews

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.nytimesapp.domain.reviews.ReviewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor (
    private val reviewsRepository: ReviewsRepository,
    private val savedStateHandle:SavedStateHandle,
) : ViewModel() {

    fun showSubreddit(subreddit: String) {
        if (!shouldShowSubreddit(subreddit)) return
        savedStateHandle.set(KEY_SUBREDDIT, subreddit)
    }

    private fun shouldShowSubreddit(subreddit: String): Boolean {
        return savedStateHandle.get<String>(KEY_SUBREDDIT) != subreddit
    }

    val reviews = savedStateHandle.getLiveData<String>(KEY_SUBREDDIT)
        .asFlow()
        .flatMapLatest { reviewsRepository.getReviewsList(it, 20) }
        // cachedIn() shares the paging state across multiple consumers of posts,
        // e.g. different generations of UI across rotation config change
        .cachedIn(viewModelScope)

//    val reviewsFlow = reviewsRepository.getReviewsList(null).cachedIn(viewModelScope)

    companion object {
        const val KEY_SUBREDDIT = "subreddit"
        const val DEFAULT_SUBREDDIT = "androiddev"
    }
}
