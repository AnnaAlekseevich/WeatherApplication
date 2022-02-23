package com.bignerdranch.android.weatherapplication.ui.fragments.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bignerdranch.android.weatherapplication.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherViewModel>()
    private var latitude: String = ""
    private var longitude: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)

        latitude = arguments?.getString("latitude")!!
        longitude = arguments?.getString("longitude")!!
        
        viewModel.loadData(latitude, longitude).toString()
        viewModel.tempLiveData.observe (viewLifecycleOwner) {
            binding.tvTemp.text = it
        }

        return binding.root
    }
}