package com.joatoribio.horoscopoapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.joatoribio.horoscopoapp.R
import com.joatoribio.horoscopoapp.databinding.ActivityHorosocpoDetailBinding
import com.joatoribio.horoscopoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HorosocpoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorosocpoDetailBinding
    private val horoscopoDetailViewModel:HoroscopoDetailViewModel by viewModels()

    private val args:HorosocpoDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorosocpoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
    }
}