package com.joatoribio.horoscopoapp.ui.horoscopos

import com.joatoribio.horoscopoapp.data.providers.HoroscopoProvider
import com.joatoribio.horoscopoapp.motherobject.HoroscopoMotherObject.horoscopoInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HoroscopoViewModelTest{

    @MockK
    lateinit var horoscopoProvider: HoroscopoProvider

    private lateinit var viewModel: HoroscopoViewModel
    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loeaded`(){
        every { horoscopoProvider.getHoroscopes() } returns horoscopoInfoList
        viewModel = HoroscopoViewModel(horoscopoProvider)

        val horoscopos = viewModel.horoscopo.value

        assertTrue(horoscopos.isNotEmpty())
    }
}
