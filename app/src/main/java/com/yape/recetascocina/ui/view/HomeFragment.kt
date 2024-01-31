package com.yape.recetascocina.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yape.recetascocina.R
import com.yape.recetascocina.data.model.Receta
import com.yape.recetascocina.databinding.FragmentHomeBinding
import com.yape.recetascocina.ui.adapters.RecetaAdapter
import com.yape.recetascocina.ui.viewmodel.HomeViewModel
import com.yape.recetascocina.ui.viewmodel.HomeViewModelFactory


class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding
    private var recetaList = mutableListOf<Receta>()
    private lateinit var adapter: RecetaAdapter
    private val tempArrayList = mutableListOf<Receta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = RecetaAdapter(this)
        binding.recyclerView.adapter = adapter

        viewModel.getRecetas()?.observe(viewLifecycleOwner, Observer{ recetas ->
            recetas.let{
                if (it.recetas.isNotEmpty()){
                    recetaList = it.recetas.toMutableList()
                    adapter.recetasList(it.recetas)
                }
            }
        })

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText = newText!!.lowercase()

                tempArrayList.clear()
                if (searchText.isNotEmpty()){
                    recetaList.forEach{
                        if (it.nombre.lowercase().contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(recetaList)
                }
                adapter.recetasList(tempArrayList)
                adapter.notifyDataSetChanged()

                return false
            }
        })
    }
}