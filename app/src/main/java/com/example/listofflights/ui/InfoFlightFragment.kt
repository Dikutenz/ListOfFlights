package com.example.listofflights.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofflights.databinding.FragmentInfoFlightBinding
import com.example.listofflights.ui.adapters.TripsAdapter
import com.example.listofflights.viewmodels.FlightViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class InfoFlightFragment : Fragment() {

    private var fragmentBinding: FragmentInfoFlightBinding? = null
    private val flightViewModel: FlightViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInfoFlightBinding.inflate(inflater, container, false)
        fragmentBinding = binding
        setUI(binding)
        return binding.root
    }

    private fun setUI(binding: FragmentInfoFlightBinding) {
        binding.typeTextView.text = "Класс перелета: ${flightViewModel.flight.prices[0].getSType()}"
        binding.amountTextView.text =
            "Стоимость: ${flightViewModel.flight.prices[0].amount}  ${flightViewModel.flight.getSCurrency()}"
        val adapter = TripsAdapter(flightViewModel.flight.trips)

        binding.tripsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.tripsRecyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}