package com.yape.recetascocina.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.yape.recetascocina.R
import com.yape.recetascocina.databinding.FragmentDetailBinding
import com.yape.recetascocina.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val imagen = arguments?.getString("imagen")
        val nombre = arguments?.getString("nombre")
        val descripcion = arguments?.getString("descripcion")
        val geolocalizacion = arguments?.getString("geolocalizacion")

        Glide.with(this).load(imagen).into(binding.ImagenView)
        binding.titulo.text = nombre
        binding.descripcion.text = descripcion

        binding.mapaBtn.setOnClickListener{
          val bundle = bundleOf(
                "geolocalizacion" to geolocalizacion
            )

            this.findNavController().navigate(R.id.action_detailFragment_to_mapFragment, bundle)
        }

        return binding.root
    }


}