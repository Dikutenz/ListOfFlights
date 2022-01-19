package com.example.listofflights.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listofflights.R
import com.example.listofflights.model.entity.Flight

class FlightListAdapter(
    private val flights: List<Flight>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<FlightListAdapter.FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FlightViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
    )

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(flights[position], listener)
    }

    override fun getItemCount(): Int = flights.size

    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
        private val numTransferTextView: TextView = itemView.findViewById(R.id.numTransferTextView)
        private val toTextView: TextView = itemView.findViewById(R.id.toTextView)
        private val fromTextView: TextView = itemView.findViewById(R.id.fromTextView)

        fun bind(flight: Flight, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onItemClicked(flight) }

            fromTextView.text = flight.trips.first().getSFromAirport()
            toTextView.text = flight.trips.last().getSToAirport()
            numTransferTextView.text = "Кол-во пересадок: ${flight.trips.size}"
            amountTextView.text =
                "${if (flight.prices.size > 1) "от " else ""} ${flight.prices.minOf { it.amount!! }} ${flight.getSCurrency()}"
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(flight: Flight)
    }
}