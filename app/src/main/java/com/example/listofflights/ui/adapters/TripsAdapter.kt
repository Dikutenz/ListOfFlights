package com.example.listofflights.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listofflights.R
import com.example.listofflights.model.entity.Trip

class TripsAdapter(private val trips: List<Trip>) :
    RecyclerView.Adapter<TripsAdapter.TripHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TripHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_trip, parent, false)
    )

    override fun onBindViewHolder(holder: TripHolder, position: Int) {
        holder.bind(trips[position])
    }

    override fun getItemCount(): Int = trips.size

    class TripHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val toTextView: TextView = itemView.findViewById(R.id.toTextView)
        private val fromTextView: TextView = itemView.findViewById(R.id.fromTextView)

        fun bind(trip: Trip) {
            fromTextView.text = trip.getSFromAirport()
            toTextView.text = trip.getSToAirport()
        }

    }


}