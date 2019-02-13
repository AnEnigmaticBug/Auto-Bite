package com.bitecode.autobite.screens.history.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.history.core.HistoryViewModel
import com.bitecode.autobite.screens.history.core.HistoryViewModelFactory
import com.bitecode.autobite.screens.history.core.UiOrder
import com.bitecode.autobite.screens.shared.core.Trip
import kotlinx.android.synthetic.main.fra_history.view.tripsRCY

class HistoryFragment : Fragment(), TripsAdapter.ClickListener {

    private val viewModel by lazy {
        ViewModelProviders.of(this, HistoryViewModelFactory())[HistoryViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_history, container, false)

        rootPOV.tripsRCY.adapter = TripsAdapter(this)

        viewModel.orderData.observe(this, Observer { order ->
            when(order) {
                is UiOrder.ShowWorking -> showWorkingState(order.trips)
                is UiOrder.ShowFailure -> showFailureState(order.error)
            }
        })

        return rootPOV
    }


    override fun onTripClicked(id: Long) {
        // Code for showing the trip details dialog
    }


    private fun showWorkingState(trips: List<Trip>) {
        view?.let { view ->
            (view.tripsRCY.adapter as TripsAdapter).trips = trips
        }
    }

    private fun showFailureState(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}