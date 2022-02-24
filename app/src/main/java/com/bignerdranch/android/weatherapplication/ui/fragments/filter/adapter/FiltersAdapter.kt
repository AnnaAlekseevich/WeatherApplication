package com.bignerdranch.android.weatherapplication.ui.fragments.filter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.weatherapplication.databinding.ItemFilterBinding

class FiltersAdapter(private var data: List<String>, val filterItemClickListener: FilterItemClickListener) :
    RecyclerView.Adapter<FiltersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemFilterBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setFilters(data[position])
    }

    inner class ViewHolder(private val itemFilterBinding: ItemFilterBinding) :
        RecyclerView.ViewHolder(itemFilterBinding.root) {
        private val binding = ItemFilterBinding.bind(itemView)

        fun setFilters(item: String) {
            binding.tvFilterName.text = item

            binding.itFl.setOnClickListener {
                filterItemClickListener.onFilterClicked(item)
            }
        }
    }
}
