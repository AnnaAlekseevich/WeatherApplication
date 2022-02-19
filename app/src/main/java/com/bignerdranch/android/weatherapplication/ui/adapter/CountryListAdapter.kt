package com.bignerdranch.android.weatherapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.weatherapplication.R
import com.bignerdranch.android.weatherapplication.databinding.ItemCountryBinding
import com.bignerdranch.android.weatherapplication.data.models.Country

class CountryListAdapter() :
    RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private val data = mutableListOf<Country>()

    fun addCountry( coins : List<Country>){
        data.addAll(coins)
        //todo notifyItemRangeInserted
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCountryBinding.bind(itemView)

        fun updateCountry(country: Country) {
            binding.imageView.setImageResource(country.imageResId)
            binding.tvCountry.text = country.countryName
            binding.tvCapital.text = country.capitalName

            binding.clItem.setOnClickListener {
//                countryListItemClickListener.invoke(country)
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