package com.bignerdranch.android.weatherapplication.ui.fragments.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.data.models.CountryResponseData
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
            addCountry(list)
        }

        return binding.root
    }

private fun addCountry(countries: List<CountryResponseData>) {
    countryAdapter?.addCountry(countries)
}

    override fun onCountryClicked(country: CountryResponseData) {
        val latitude = country.latlng[0]
        val longitude = country.latlng[1]
        val bundle: Bundle = Bundle(2)
            .apply {
                putString("latitude", latitude)
                putString("longitude", longitude)
            }
        findNavController().navigate(
            R.id.action_countriesListFragment_to_weatherFragment, bundle
        )
    }

}