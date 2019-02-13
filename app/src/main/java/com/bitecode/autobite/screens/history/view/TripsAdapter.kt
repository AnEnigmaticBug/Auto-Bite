package com.bitecode.autobite.screens.history.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.shared.core.Trip
import com.bitecode.autobite.screens.shared.util.asTwoDigit
import kotlinx.android.synthetic.main.row_trips.view.*

class TripsAdapter(private val listener: ClickListener) : RecyclerView.Adapter<TripsAdapter.TripVHolder>() {

    interface ClickListener {

        fun onTripClicked(id: Long)
    }

    var trips = listOf<Trip>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = trips.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripVHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TripVHolder(inflater.inflate(R.layout.row_trips, parent, false))
    }

    override fun onBindViewHolder(holder: TripVHolder, position: Int) {
        val trip = trips[position]

        val date = trip.datetime.toLocalDate()
        holder.dateLBL.text = "${date.dayOfMonth.asTwoDigit()}-${date.monthValue.asTwoDigit()}-${date.year.toString().takeLast(2)}"
        val time = trip.datetime.toLocalTime()
        holder.timeLBL.text = "${time.hour.asTwoDigit()}:${time.minute.asTwoDigit()}"
        holder.fareLBL.text = "₹${trip.cost}"

        holder.rootPOV.setOnClickListener { listener.onTripClicked(trip.id) }
    }

    class TripVHolder(val rootPOV: View) : RecyclerView.ViewHolder(rootPOV) {

        val dateLBL: TextView = rootPOV.dateLBL
        val timeLBL: TextView = rootPOV.timeLBL
        val fareLBL: TextView = rootPOV.fareLBL
    }
}