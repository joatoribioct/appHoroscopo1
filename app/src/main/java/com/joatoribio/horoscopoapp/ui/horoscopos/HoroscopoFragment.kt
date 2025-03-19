package com.joatoribio.horoscopoapp.ui.horoscopos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.joatoribio.horoscopoapp.databinding.FragmentHoroscopoBinding
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo.*
import com.joatoribio.horoscopoapp.domain.model.HoroscopoModel
import com.joatoribio.horoscopoapp.ui.horoscopos.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()

    private lateinit var horoscopoadapter: HoroscopoAdapter
    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniUI()
    }

    private fun iniUI() {
        iniList()
        iniUIState()
    }

    private fun iniList() {
        horoscopoadapter = HoroscopoAdapter(onItemSelected = {
            val type = when(it) {
                Aquarius -> HoroscopoModel.Aquarius
                Aries -> HoroscopoModel.Aries
                Cancer -> HoroscopoModel.Cancer
                Capricorn -> HoroscopoModel.Capricorn
                Gemini -> HoroscopoModel.Gemini
                Leo -> HoroscopoModel.Leo
                Libra -> HoroscopoModel.Libra
                Pisces -> HoroscopoModel.Pisces
                Sagittarius -> HoroscopoModel.Sagittarius
                Scorpio -> HoroscopoModel.Scorpio
                Taurus -> HoroscopoModel.Taurus
                Virgo -> HoroscopoModel.Virgo
            }
            type
            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHorosocpoDetailActivity(type)
            )
        })
        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoadapter
        }
    }

    private fun iniUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect{
                    horoscopoadapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}