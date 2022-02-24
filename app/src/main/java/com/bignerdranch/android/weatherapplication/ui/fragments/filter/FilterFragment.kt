package com.bignerdranch.android.weatherapplication.ui.fragments.filter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bignerdranch.android.weatherapplication.databinding.FragmentFilterBinding
import com.bignerdranch.android.weatherapplication.ui.fragments.filter.adapter.FilterItemClickListener
import com.bignerdranch.android.weatherapplication.ui.fragments.filter.adapter.FiltersAdapter
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment

@AndroidEntryPoint
class FilterFragment : MvpAppCompatFragment(), FilterContract, FilterItemClickListener {

    private lateinit var binding: FragmentFilterBinding
    private var filterAdapter: FiltersAdapter? = null
    private var listFilters: List<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(layoutInflater)
        listFilters = listOf("one", "two", "three", "four")

        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.alignItems = AlignItems.CENTER
        binding.rvFilters.layoutManager = layoutManager
        filterAdapter = FiltersAdapter(listFilters!!, this)

        binding.rvFilters.adapter = filterAdapter

        return binding.root
    }

    override fun showToast(toastText: String) {
        Toast.makeText(requireContext(), toastText, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar(loading: Boolean) {
        if (loading) {
            binding.prBar.visibility = View.VISIBLE
        } else {
            binding.prBar.visibility = View.GONE
        }
    }

    override fun onShowLog(log: String) {
        Log.d("CheckLog", "log = $log")
    }

    override fun onFilterClicked(item: String) {
        when(item) {
            "one" -> showProgressBar(true)
            "two" -> showProgressBar(false)
            "three" -> showToast(item)
            "four" -> onShowLog(item)

        }
    }
}