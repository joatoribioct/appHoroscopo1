package com.joatoribio.horoscopoapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class LuckyMode(
    @DrawableRes val image:Int,
    @StringRes val text:Int
)