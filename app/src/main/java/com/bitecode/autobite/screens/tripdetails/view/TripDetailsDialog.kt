package com.bitecode.autobite.screens.tripdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.shared.util.asTwoDigit
import com.bitecode.autobite.screens.tripdetails.core.TripDetailsViewModel
import com.bitecode.autobite.screens.tripdetails.core.TripDetailsViewModelFactory
import com.bitecode.autobite.screens.tripdetails.core.UiOrder
import kotlinx.android.synthetic.main.dia_trip_details.view.closeBTN
import kotlinx.android.synthetic.main.dia_trip_details.view.dateLBL
import kotlinx.android.synthetic.main.dia_trip_details.view.destinationLBL
import kotlinx.android.synthetic.main.dia_trip_details.view.distanceLBL
import kotlinx.android.synthetic.main.dia_trip_details.view.fareLBL
import kotlinx.android.synthetic.main.dia_trip_details.view.pickupPointLBL
import kotlinx.android.synthetic.main.dia_trip_details.view.timeLBL

class TripDetailsDialog : DialogFragment() {

    private val viewModel by lazy {
        val id = arguments!!.getLong("TRIP_ID")
        ViewModelProviders.of(this, TripDetailsViewModelFactory(id))[TripDetailsViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.dia_trip_details, container, false)

        rootPOV.closeBTN.setOnClickListener {
            dismiss()
        }

        viewModel.orderData.observe(this, Observer { order ->
            when(order) {
                is UiOrder.ShowWorking -> {
                    val date = order.trip.datetime.toLocalDate()
                    rootPOV.dateLBL.text = "${date.dayOfMonth.asTwoDigit()}-${date.monthValue.asTwoDigit()}-${date.year}"
                    val time = order.trip.datetime.toLocalTime()
                    rootPOV.timeLBL.text = "${time.hour.asTwoDigit()}:${time.minute.asTwoDigit()}"
                    rootPOV.distanceLBL.text = "${order.trip.distance}km"
                    rootPOV.pickupPointLBL.text = order.trip.pickupPoint
                    rootPOV.destinationLBL.text = order.trip.destination
                    rootPOV.fareLBL.text = "₹${order.trip.cost}"
                }
            }
        })

        return rootPOV
    }
}