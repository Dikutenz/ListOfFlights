package com.example.listofflights.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.example.listofflights.databinding.FragmentTypeDialogBinding
import com.example.listofflights.viewmodels.FlightViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TypeDialogFragment(private val onDismissListener: OnDismissListener) : DialogFragment() {

    private var fragmentBinding: FragmentTypeDialogBinding? = null
    private val flightViewModel: FlightViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTypeDialogBinding.inflate(inflater, container, false)
        fragmentBinding = binding
        setUI(binding)
        return binding.root
    }

    private fun setUI(binding: FragmentTypeDialogBinding) {
        if (flightViewModel.flight.prices.any { it.type == "bussiness" }) {
            binding.businessRadioButton.isVisible = true
            binding.businessRadioButton.isChecked = true
        } else {
            binding.businessRadioButton.isVisible = false
        }
        if (flightViewModel.flight.prices.any { it.type == "economy" }) {
            binding.economyRadioButton.isVisible = true
            binding.economyRadioButton.isChecked = true
        } else {
            binding.economyRadioButton.isVisible = false
        }

        binding.okButton.setOnClickListener {
            onDismissListener.onDismiss(
                if (binding.economyRadioButton.isChecked) "economy" else "bussiness"
            )
            dismiss()
        }
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }

    interface OnDismissListener {
        fun onDismiss(type: String)
    }


}