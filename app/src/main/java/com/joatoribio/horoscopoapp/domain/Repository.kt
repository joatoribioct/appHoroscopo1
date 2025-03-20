package com.joatoribio.horoscopoapp.domain
import com.joatoribio.horoscopoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}