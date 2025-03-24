package com.joatoribio.horoscopoapp.ui.provides

import com.joatoribio.horoscopoapp.R
import com.joatoribio.horoscopoapp.ui.model.LuckyMode
import javax.inject.Inject
import kotlin.random.Random

class RamdomCardProvider @Inject constructor() {
    fun getLucky():LuckyMode?{
        return when(Random.nextInt(0, 32)){
            0 -> LuckyMode(R.drawable.card_fool, R.string.luck_0)
            1 -> LuckyMode(R.drawable.card_moon, R.string.luck_1)
            2 -> LuckyMode(R.drawable.card_hermit, R.string.luck_2)
            3 -> LuckyMode(R.drawable.card_star, R.string.luck_3)
            4 -> LuckyMode(R.drawable.card_sun, R.string.luck_4)
            5 -> LuckyMode(R.drawable.card_sword, R.string.luck_5)
            6 -> LuckyMode(R.drawable.card_chariot, R.string.luck_6)
            7 -> LuckyMode(R.drawable.card_death, R.string.luck_7)
            8 -> LuckyMode(R.drawable.card_devil, R.string.luck_8)
            9 -> LuckyMode(R.drawable.card_empress, R.string.luck_9)
            10 -> LuckyMode(R.drawable.card_hierophant, R.string.luck_10)
            11 -> LuckyMode(R.drawable.card_ace_pentacles, R.string.luck_11)
            12 -> LuckyMode(R.drawable.card_judgement, R.string.luck_12)
            13 -> LuckyMode(R.drawable.card_world, R.string.luck_13)
            14 -> LuckyMode(R.drawable.card_wheel_fortune, R.string.luck_14)
            15 -> LuckyMode(R.drawable.card_tower, R.string.luck_15)
            16 -> LuckyMode(R.drawable.card_temperance, R.string.luck_16)
            17 -> LuckyMode(R.drawable.card_strength, R.string.luck_17)
            18 -> LuckyMode(R.drawable.card_queen_wands, R.string.luck_18)
            19 -> LuckyMode(R.drawable.card_queen_swords, R.string.luck_19)
            20 -> LuckyMode(R.drawable.card_priestess, R.string.luck_20)
            21 -> LuckyMode(R.drawable.card_nine_wands, R.string.luck_21)
            22 -> LuckyMode(R.drawable.card_page_wands, R.string.luck_22)
            23 -> LuckyMode(R.drawable.card_magician, R.string.luck_23)
            24 -> LuckyMode(R.drawable.card_king_pentacles, R.string.luck_24)
            25 -> LuckyMode(R.drawable.card_two_pentacles, R.string.luck_25)
            26 -> LuckyMode(R.drawable.card_queen_pentacles, R.string.luck_26)
            27 -> LuckyMode(R.drawable.card_justice, R.string.luck_27)
            28 -> LuckyMode(R.drawable.card_king_swords, R.string.luck_28)
            29 -> LuckyMode(R.drawable.card_king_wands, R.string.luck_29)
            30 -> LuckyMode(R.drawable.card_king_cups, R.string.luck_30)
            31 -> LuckyMode(R.drawable.card_king_pentacles, R.string.luck_31)
            else -> null
        }
    }
}