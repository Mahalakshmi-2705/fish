package com.example.fish.fragment

// HomeFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.fish.R
import com.example.fish.databinding.FragmentProductListingBinding
import com.example.fish.model.HomeViewModel

class ProductListing : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentProductListingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_listing, container, false
        )

        // Set the ViewModel for the binding
        binding.viewModel = HomeViewModel()

        // Set the lifecycle owner for LiveData to update
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}
