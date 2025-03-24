package com.joatoribio.horoscopoapp.data.network.reponse

import com.joatoribio.horoscopoapp.motherobject.HoroscopoMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test


class PredictionResponseTest{
    @Test
    fun `toDomain should return a corrrect predictionModel`(){
        val horoscopoResponse = anyResponse
        val predictionModel = horoscopoResponse.toDomain()

        predictionModel.sign shouldBe  horoscopoResponse.sign
        predictionModel.horoscope shouldBe horoscopoResponse.horoscope
    }
}