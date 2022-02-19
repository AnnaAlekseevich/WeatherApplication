package com.bignerdranch.android.weatherapplication.ui.activity

import dagger.hilt.android.AndroidEntryPoint


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.weatherapplication.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}