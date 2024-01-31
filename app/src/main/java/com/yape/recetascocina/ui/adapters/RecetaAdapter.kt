package com.yape.recetascocina.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yape.recetascocina.R
import com.yape.recetascocina.data.model.Receta
import com.yape.recetascocina.databinding.RecetaItemBinding

class RecetaAdapter(private val fragment: Fragment): RecyclerView.Adapter<RecetaViewHolder>() {

    private var recetas: List<Receta> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecetaItemBinding.inflate(inflater, parent, false)
        return RecetaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = recetas[position]

        Glide.with(fragment).load(receta.imagen).into(holder.recetaImagen)
        holder.recetaNombre.text = receta.nombre

        holder.contenedor.setOnClickListener{view->

            val bundle = bundleOf(
                "imagen" to receta.imagen,
                "nombre" to receta.nombre,
                "descripcion" to receta.descripcion,
                "geolocalizacion" to receta.geolocalizacion
            )

            view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)

        }


    }

    override fun getItemCount(): Int {
        return recetas.size
    }

    fun recetasList(list: List<Receta>){
        recetas = list
        notifyDataSetChanged()
    }

}

class RecetaViewHolder(var binding: RecetaItemBinding): RecyclerView.ViewHolder(binding.root){

    val recetaImagen = binding.imagen
    val recetaNombre = binding.nombre
    val contenedor = binding.container


}