package com.bignerdranch.android.weatherapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.weatherapplication.data.models.Country
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import com.bignerdranch.android.weatherapplication.databinding.FragmentCountriesListBinding
import com.bignerdranch.android.weatherapplication.ui.adapter.CountryItemClickListener
import com.bignerdranch.android.weatherapplication.ui.adapter.CountryListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesListFragment : Fragment(), CountryItemClickListener {

    private lateinit var binding: FragmentCountriesListBinding
    private var countryAdapter: CountryListAdapter? = null
    private val viewModel by viewModels<CountriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesListBinding.inflate(layoutInflater)
        countryAdapter = CountryListAdapter(this)
        binding.cryptosRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cryptosRecyclerView.adapter = countryAdapter

        viewModel.countriesList.observe(viewLifecycleOwner) { list ->
            Log.d("CheckProblem", "list in fragment = $list")
            addCountry(list)
        }

        return binding.root
    }

private fun addCountry(countries: List<CountryApi>) {
    countryAdapter?.addCountry(countries)
}

    override fun onCountryClicked(country: CountryApi) {
        Log.d("CheckClick", "onCountryClicked")
    }

}