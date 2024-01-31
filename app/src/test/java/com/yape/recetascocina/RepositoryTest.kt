package com.yape.recetascocina

import com.yape.recetascocina.domain.repository.RecetasRepository
import com.yape.recetascocina.utils.RetrofitClient
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class RepositoryTest {


     var repository: RecetasRepository = mockk()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `comprobar retrofit`() {

        val instance = RetrofitClient
        assert(instance.baseUrl == "http://demo5060604.mockable.io/")
    }

    @Test
    fun `comprobar repository`() {

        val response = RetrofitClient.apiInterface.getRecetas().execute()

        if (response.isSuccessful) {
            Assert.assertNotNull(response.body())
        }


    }






}