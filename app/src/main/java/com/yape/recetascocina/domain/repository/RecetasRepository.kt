package com.yape.recetascocina.domain.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yape.recetascocina.data.model.Receta
import com.yape.recetascocina.data.model.Recetas
import com.yape.recetascocina.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RecetasRepository {

    val RecetasItems = MutableLiveData<Recetas>()

    fun getRecetasApiCall(): MutableLiveData<Recetas>{

        val call = RetrofitClient.apiInterface.getRecetas()

        call?.enqueue(object: Callback<Recetas>{

            override fun onFailure(call: Call<Recetas>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<Recetas>, response: Response<Recetas>) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                RecetasItems.value = data!!
            }
        })

        return RecetasItems
    }
}