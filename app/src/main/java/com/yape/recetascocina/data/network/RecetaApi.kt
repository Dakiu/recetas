package com.yape.recetascocina.data.network

import retrofit2.Call
import com.yape.recetascocina.data.model.Recetas
import retrofit2.http.GET

interface RecetaApi {

    @GET("recetas")
    fun getRecetas(): Call<Recetas>

}