package com.example.listofflights.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.listofflights.R
import com.example.listofflights.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var fragmentBinding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStartBinding.inflate(inflater, container, false)
        fragmentBinding = binding
        setUI(binding)
        return binding.root
    }

    private fun setUI(binding: FragmentStartBinding) {
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_start_to_listFlight, null)
        )
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }

}