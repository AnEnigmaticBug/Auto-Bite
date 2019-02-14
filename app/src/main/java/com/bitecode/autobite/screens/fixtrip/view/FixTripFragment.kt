package com.bitecode.autobite.screens.fixtrip.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bitecode.autobite.R
import kotlinx.android.synthetic.main.fra_fix_trip.*
import kotlinx.android.synthetic.main.fra_fix_trip.view.destinationTXT
import kotlinx.android.synthetic.main.fra_fix_trip.view.findRideBTN
import kotlinx.android.synthetic.main.fra_fix_trip.view.pickupPointTXT

class FixTripFragment : Fragment() {

    private data class Location(val name: String, val lat: Double, val lng: Double)

    private val locations = listOf(
        Location("Vyas Bhawan", 0.0, 0.0),
        Location("VK Rehdi", 0.0, 0.0),
        Location("Varanasi, UP", 0.0, 0.0),
        Location("Srinivasan Ramanujan Bhawan", 0.0, 0.0),
        Location("Food King, BITS Pilani", 0.0, 0.0)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_fix_trip, container, false)

        rootPOV.pickupPointTXT.apply {
            setAdapter(ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, locations.map { it.name }))
            threshold = 1
        }

        rootPOV.destinationTXT.apply {
            setAdapter(ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, locations.map { it.name }))
            threshold = 1
        }

        rootPOV.findRideBTN.setOnClickListener {
            if(pickupPointTXT.text.toString().isBlank() || destinationTXT.text.toString().isBlank()) {
                Toast.makeText(context, "Please fill both the fields", Toast.LENGTH_SHORT).show()
            } else if(pickupPointTXT.text.toString() == destinationTXT.text.toString()) {
                Toast.makeText(context, "Please ensure that pickup point and destination are different", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_map_to_showRoute)
            }
        }

        return rootPOV
    }
}