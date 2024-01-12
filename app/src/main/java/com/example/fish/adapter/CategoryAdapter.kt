package com.example.fish.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fish.R
import java.util.Locale

class CategoryAdapter : ListAdapter<Locale.Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        // Bind your category data to the views in the item_category layout
        holder.bind(category)
    }

    fun submitList() {

    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryNameTextView: TextView = itemView.findViewById(R.id.settingUpdateImage)

        fun bind(category: Locale.Category) {
            // Bind your category data to the views in the item_category layout
            categoryNameTextView.text = category.name
        }
    }

    private class CategoryDiffCallback : DiffUtil.ItemCallback<Locale.Category>() {
        override fun areItemsTheSame(oldItem: Locale.Category, newItem: Locale.Category): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Locale.Category, newItem: Locale.Category): Boolean {
            return oldItem == newItem
        }
    }
}
