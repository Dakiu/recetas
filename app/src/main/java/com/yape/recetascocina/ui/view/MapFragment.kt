package com.yape.recetascocina.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yape.recetascocina.R
import com.yape.recetascocina.databinding.FragmentHomeBinding
import com.yape.recetascocina.databinding.FragmentMapBinding


class MapFragment : Fragment(), OnMapReadyCallback{

    private lateinit var binding : FragmentMapBinding
    private lateinit var mMap: GoogleMap
    private var latitud: Double = 0.0
    private var longitud: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)

        val geolocalizacion = arguments?.getString("geolocalizacion")
        latitud = geolocalizacion!!.split(',')[0].toDouble()
        longitud = geolocalizacion!!.split(',')[1].toDouble()

        val mapFragment = childFragmentManager.findFragmentById(binding.mapa.id) as SupportMapFragment// sirve
        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val ubicacion = LatLng(latitud, longitud)
        mMap.addMarker(
            MarkerOptions()
            .position(ubicacion)
            .title("Marcador"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion))
    }


}