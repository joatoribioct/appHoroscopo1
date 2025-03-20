package com.joatoribio.horoscopoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joatoribio.horoscopoapp.domain.model.HoroscopoModel
import com.joatoribio.horoscopoapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetailViewModel  @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel(){
    private var _state = MutableStateFlow<HoroscopoDetailState>(HoroscopoDetailState.Logading)
    val state:StateFlow<HoroscopoDetailState> = _state

    lateinit var horoscope:HoroscopoModel

    fun getHoroscopo(sign: HoroscopoModel){
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopoDetailState.Logading
            val result = withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) }
            if (result!=null) {
                _state.value = HoroscopoDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = HoroscopoDetailState.Error("Ha ocurrido un error intentar mas tarder")
            }
        }
    }
}