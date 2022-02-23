package com.bignerdranch.android.weatherapplication.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.data.models.CountryApi
import com.bignerdranch.android.weatherapplication.databinding.ItemCountryBinding
import com.bumptech.glide.Glide

class CountryListAdapter(val countryItemClickListener: CountryItemClickListener) :
    RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private val data = mutableListOf<CountryApi>()

    fun addCountry(countries: List<CountryApi>) {
        data.addAll(countries)
        //todo notifyItemRangeInserted
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCountryBinding.bind(itemView)

        fun updateCountry(country: CountryApi) {
            binding.imageView.setImageURI(country.flagUrl.flagURL.toUri())
            binding.tvCountry.text = country.countryName.name
            binding.tvCapital.text = country.capitalName.toString()
            binding.tvTimeZone.text = country.timezones.toString()

            country.flagUrl.flagURL.toUri().let {
                Glide
                    .with(binding.imageView.context)
                    .load(it)
                    .into(binding.imageView)
            }

            binding.clItem.setOnClickListener {
                countryItemClickListener.onCountryClicked(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateCountry(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

//for converting String to Uri
private fun String.toUri(): Uri = Uri.parse(this)