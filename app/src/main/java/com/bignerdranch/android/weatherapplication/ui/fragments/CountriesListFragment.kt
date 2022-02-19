package com.bignerdranch.android.weatherapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.databinding.FragmentCountriesListBinding
import com.bignerdranch.android.weatherapplication.ui.adapter.CountryListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesListFragment : Fragment() {

    private lateinit var binding: FragmentCountriesListBinding
    private var countryAdapter: CountryListAdapter? = null
    private val viewModel by viewModels<CountriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesListBinding.inflate(layoutInflater)
        countryAdapter = CountryListAdapter()
        binding.cryptosRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cryptosRecyclerView.adapter = countryAdapter

        Log.d("CheckProblem", "viewModel.listData = $viewModel.listData")
        viewModel.checkData()
        addCountry(viewModel.listData)

        return binding.root
    }

//    private fun generateSubData():List<Country> {
//        val countryStubList = mutableListOf<Country>()
//        val country1 = Country("Germany", "Berlin", R.drawable.ic_flag_germany)
//        val country2 = Country("Austria", "Vienna", R.drawable.ic_flag_austria)
//        val country3 = Country("France", "Paris", R.drawable.ic_flag_france)
//        val country4 = Country("Italy", "Roma", R.drawable.ic_flag_italy)
//        val country5 = Country("Switzerland", "Bern", R.drawable.ic_flag_switzerland)
//
//        countryStubList.add(country1)
//        countryStubList.add(country2)
//        countryStubList.add(country3)
//        countryStubList.add(country4)
//        countryStubList.add(country5)
//
//        return countryStubList
//    }
//
//
    private fun addCountry(countries: List<Country>){
        countryAdapter?.addCountry(countries)
    }

//    override fun onCountryClicked(coin: Country?, itemTextView: View) {
//        TODO("Not yet implemented")
//    }

}