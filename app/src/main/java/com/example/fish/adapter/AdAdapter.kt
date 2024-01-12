package com.example.fish.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fish.R

class AdAdapter: ListAdapter<Int, AdAdapter.AdViewHolder>(AdDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_advertisement, parent, false)
        return AdViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdViewHolder, position: Int) {
        val adImageResource = getItem(position)
        // Bind your advertisement data to the views in the item_advertisement layout
        holder.bind(adImageResource)
    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val adImageView: ImageView = itemView.findViewById(R.id.imgItem)

        fun bind(adImageResource: Int) {
            // Bind your advertisement data to the views in the item_advertisement layout
            adImageView.setImageResource(adImageResource)
        }
    }

    private class AdDiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
}
