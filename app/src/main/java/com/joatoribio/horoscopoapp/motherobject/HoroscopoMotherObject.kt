package com.joatoribio.horoscopoapp.motherobject

import com.joatoribio.horoscopoapp.data.network.reponse.PredictionResponse
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo.*


object HoroscopoMotherObject {
    val anyResponse = PredictionResponse("data", "prediction", "taurus")

    val horoscopoInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}