package com.yape.recetascocina.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yape.recetascocina.data.model.Receta
import com.yape.recetascocina.data.model.Recetas
import com.yape.recetascocina.domain.repository.RecetasRepository

class HomeViewModel: ViewModel() {

    var recetasLiveData: MutableLiveData<Recetas>?= null

    fun getRecetas(): MutableLiveData<Recetas>?{

        recetasLiveData = RecetasRepository.getRecetasApiCall()
        return recetasLiveData
    }
}