package com.bignerdranch.android.weatherapplication.ui.fragments.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.weatherapplication.R
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

        val example = viewModel.loadExampleRequest(latitude, longitude).toString()
        Log.d("CheckExample", "example = $example")

        binding.btnGoToFilters.setOnClickListener {
            findNavController().navigate(
                R.id.action_weatherFragment_to_filterFragment
            )
        }

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}