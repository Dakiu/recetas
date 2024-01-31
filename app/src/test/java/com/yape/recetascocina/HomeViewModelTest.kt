package com.yape.recetascocina

import androidx.lifecycle.MutableLiveData
import com.yape.recetascocina.data.model.Recetas
import com.yape.recetascocina.domain.repository.RecetasRepository
import com.yape.recetascocina.ui.viewmodel.HomeViewModel
import io.mockk.*
import org.junit.Test
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.assertNotNull
import org.junit.Before

class HomeViewModelTest {


    @RelaxedMockK
    lateinit var repository : RecetasRepository

    @RelaxedMockK
    lateinit var viewModel :HomeViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `obtener recetas de repository`(){
        every { repository.getRecetasApiCall() } returns MutableLiveData<Recetas>()
        val recetas = viewModel.getRecetas()
        assertNotNull(recetas)

    }










}