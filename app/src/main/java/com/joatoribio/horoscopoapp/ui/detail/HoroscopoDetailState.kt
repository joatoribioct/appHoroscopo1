package com.joatoribio.horoscopoapp.ui.detail

import com.joatoribio.horoscopoapp.domain.model.HoroscopoModel

sealed class HoroscopoDetailState {
    data object Logading:HoroscopoDetailState()
    data class Error(val error:String):HoroscopoDetailState()
    data class Success(val prediction:String, val sign:String, val horoscopoModel: HoroscopoModel):HoroscopoDetailState()
}