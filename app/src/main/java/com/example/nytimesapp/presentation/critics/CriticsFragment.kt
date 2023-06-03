package com.example.nytimesapp.presentation.critics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.nytimesapp.R
import com.example.nytimesapp.databinding.FragmentCriticsBinding
import kotlinx.coroutines.launch

class CriticsFragment : Fragment() {

    private var _binding: FragmentCriticsBinding? = null
    private val binding: FragmentCriticsBinding
        get() = _binding!!
    private lateinit var viewModel: CriticsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CriticsViewModel::class.java]
        _binding = FragmentCriticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getCriticsList()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}