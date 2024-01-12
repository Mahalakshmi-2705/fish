package com.example.fish.model

// CategoryViewModel.kt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fish.adapter.Category


class CategoryViewModel : ViewModel() {
    val categories: MutableLiveData<List<Category>> = MutableLiveData()

    init {
        // Sample data, replace with your actual data fetching logic
        categories.value = listOf(
            Category("Category 1"),
            Category("Category 2"),
            Category("Category 3")
            // Add more categories as needed
        )
    }
}
