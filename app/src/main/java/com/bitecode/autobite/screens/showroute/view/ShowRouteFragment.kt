package com.bitecode.autobite.screens.showroute.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitecode.autobite.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions

class ShowRouteFragment : Fragment(), OnMapReadyCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_show_route, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        return rootPOV
    }

    override fun onMapReady(googleMap: GoogleMap) {

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

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(28.358049, 75.587330), 15.0f))
    }
}