package com.joatoribio.horoscopoapp.data.network

import com.joatoribio.horoscopoapp.data.network.reponse.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {

    @GET("/{sign}")
    suspend fun getHoroscopo(@Path("sign") sign:String):PredictionResponse
}