package com.example.listofflights.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofflights.R
import com.example.listofflights.databinding.FragmentListFlightBinding
import com.example.listofflights.model.entity.Flight
import com.example.listofflights.ui.adapters.FlightListAdapter
import com.example.listofflights.viewmodels.FlightViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFlightFragment : Fragment(), FlightListAdapter.OnItemClickListener,
    TypeDialogFragment.OnDismissListener {

    private val navController: NavController by lazy { findNavController() }
    private var fragmentBinding: FragmentListFlightBinding? = null
    private val flightViewModel: FlightViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListFlightBinding.inflate(inflater, container, false)
        fragmentBinding = binding
        getFlights(binding)
        return binding.root
    }

    private fun getFlights(binding: FragmentListFlightBinding) {
        flightViewModel.getFlights().enqueue(object : Callback<MutableList<Flight>> {
            override fun onResponse(
                call: Call<MutableList<Flight>>,
                response: Response<MutableList<Flight>>
            ) {
                val adapter = FlightListAdapter(
                    response.body() as MutableList<Flight>,
                    this@ListFlightFragment
                )
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<Flight>>, t: Throwable) {}
        })
    }

    override fun onItemClicked(flight: Flight) {
        flightViewModel.flight = flight
        val dialogFragment = TypeDialogFragment(this)
        dialogFragment.show(requireActivity().supportFragmentManager, "TypeDialogFragment")
    }

    override fun onDismiss(type: String) {
        flightViewModel.flight.prices = flightViewModel.flight.prices.filter { it.type == type }
        navController.navigate(R.id.action_listFlight_to_infoFlight)
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }

}