package com.bitecode.autobite.screens.showroute.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.showroute.core.ShowRouteViewModel
import com.bitecode.autobite.screens.showroute.core.ShowRouteViewModelFactory
import com.bitecode.autobite.screens.showroute.core.UiOrder
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.fra_show_route.view.*

class ShowRouteFragment : Fragment(), OnMapReadyCallback {

    private val viewModel by lazy {
        ViewModelProviders.of(this, ShowRouteViewModelFactory())[ShowRouteViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_show_route, container, false)

        setLoading(true)

        rootPOV.callRickshawBTN.setOnClickListener {
            viewModel.callRickshaw()
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        viewModel.initializeForLocation(0.0, 0.0)

        viewModel.toastData.observe(this, Observer { toast ->
            if(toast != null) {
                Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
            }
        })

        return rootPOV
    }

    override fun onMapReady(googleMap: GoogleMap) {

        setLoading(false)

        viewModel.orderData.observe(this, Observer { order ->

            setLoading(false)

            googleMap.clear()

            showPolylineForEndpoints(googleMap, 0.0, 0.0, 0.0, 0.0)

            when(order) {
                is UiOrder.ShowLoading          -> {
                    setLoading(true)

                }
                is UiOrder.ShowCloseByRickshaws -> {
                    order.rickshaws.forEach { rickshaw ->
                        Log.d("ShowRouteFragment", "(${rickshaw.lat}, ${rickshaw.lng})")
                        googleMap.addMarker(
                            MarkerOptions()
                                .position(LatLng(rickshaw.lat, rickshaw.lng))
                                .title(rickshaw.registrationNumber)
                        )
                    }
                }
                is UiOrder.ShowAllottedRickshaw -> {
                    Log.d("ShowRouteFragment", "Rickshaw Allotted")
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(order.rickshaw.lat, order.rickshaw.lng))
                            .title(order.rickshaw.registrationNumber)
                    )
                }
            }
        })

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(28.358049, 75.587330), 15.0f))
    }

    private fun showPolylineForEndpoints(googleMap: GoogleMap, lat1: Double, lng1: Double, lat2: Double, lng2: Double) {
        // First mile
        val polyline1 = googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .color(Color.RED)
                .add(
                    LatLng(28.357268, 75.585980),
                    LatLng(28.357508, 75.587369),
                    LatLng(28.358049, 75.587330)
                )
        )

        // Middle mile
        val polyline2 = googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .color(Color.BLACK)
                .add(
                    LatLng(28.358049, 75.587330),
                    LatLng(28.358267, 75.588718),
                    LatLng(28.363142, 75.587847),
                    LatLng(28.363247, 75.588751)
                )
        )

        // Last mile
        val polyline3 = googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .color(Color.GREEN)
                .add(
                    LatLng(28.363247, 75.588751),
                    LatLng(28.365311, 75.588379)

                )
        )
    }


    private fun setLoading(value: Boolean) {
        view?.let { view ->
            when(value) {
                true  -> {
                    view.loaderPBR.visibility = View.VISIBLE
                    view.callRickshawBTN.visibility = View.GONE
                    view.mapHolderFRM.visibility = View.GONE
                }
                false -> {
                    view.loaderPBR.visibility = View.GONE
                    view.callRickshawBTN.visibility = View.VISIBLE
                    view.mapHolderFRM.visibility = View.VISIBLE
                }
            }
        }
    }
}