package com.joatoribio.horoscopoapp.ui.horoscopos.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.joatoribio.horoscopoapp.databinding.ItemHoroscopoBinding
import com.joatoribio.horoscopoapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit){

        val context = binding.tvTitle.context
        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvTitle.text = context.getString(horoscopoInfo.name)
        binding.parent.setOnClickListener {
            starRotationAnimation(binding.ivHoroscopo, newLambda = {onItemSelected(horoscopoInfo)})
        //onItemSelected(horoscopoInfo)
        }
    }


    private fun starRotationAnimation(view: View, newLambda:() -> Unit) {
        view.animate().apply {
            duration = 300
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ newLambda() }
            start()
        }
    }
}