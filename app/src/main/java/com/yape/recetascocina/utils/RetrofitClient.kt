package com.yape.recetascocina.utils

import com.yape.recetascocina.data.network.RecetaApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    const val baseUrl = "http://demo5060604.mockable.io/"

    val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }

    val apiInterface: RecetaApi by lazy {
        retrofitClient
            .build()
            .create(RecetaApi::class.java)
    }
}