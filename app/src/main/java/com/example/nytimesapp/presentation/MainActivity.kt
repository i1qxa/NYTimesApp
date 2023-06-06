package com.example.nytimesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nytimesapp.R
import com.example.nytimesapp.data.Repositories
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Repositories.init(this)
    }
}