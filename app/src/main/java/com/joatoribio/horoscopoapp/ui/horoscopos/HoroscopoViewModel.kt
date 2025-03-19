package com.joatoribio.horoscopoapp.ui.horoscopos

import androidx.lifecycle.ViewModel
import com.joatoribio.horoscopoapp.data.providers.HoroscopoProvider
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopoProvider: HoroscopoProvider):ViewModel() {


    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo:StateFlow<List<HoroscopoInfo>> = _horoscopo

    init {
        _horoscopo.value = horoscopoProvider.getHoroscopes()
    }
}