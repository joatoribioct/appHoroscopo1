package com.joatoribio.horoscopoapp.data.providers

import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopoInfo> {
        return listOf(
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
}