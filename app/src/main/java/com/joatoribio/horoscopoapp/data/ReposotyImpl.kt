package com.joatoribio.horoscopoapp.data

import android.util.Log
import com.joatoribio.horoscopoapp.data.network.HoroscopoApiService
import com.joatoribio.horoscopoapp.data.network.reponse.PredictionResponse
import com.joatoribio.horoscopoapp.domain.Repository
import com.joatoribio.horoscopoapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class ReposotyImpl @Inject constructor(private val apiService: HoroscopoApiService) :Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {
        //llamar retrofit o peticion
         runCatching { apiService.getHoroscopo(sign) }.onSuccess { return it.toDomain() }.onFailure { Log.i("joa", "ha ocurrido un error  ${it.message}") }
        return null
    }
}