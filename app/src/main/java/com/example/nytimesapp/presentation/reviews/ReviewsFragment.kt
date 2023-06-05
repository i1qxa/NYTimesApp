package com.example.nytimesapp.presentation.reviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nytimesapp.databinding.FragmentReviewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewsFragment : Fragment() {

    private val viewModel by viewModels<ReviewsViewModel>()
    private val binding by lazy { FragmentReviewsBinding.inflate(layoutInflater) }
    private val adapter by lazy {
        ReviewPaggingAdapter(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvReviewsList.adapter = adapter
    }


}