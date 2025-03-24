package com.joatoribio.horoscopoapp.ui.provides

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RamdomCardProviderTest{
    @Test
    fun `getRamdomCard should a ramdom card`(){
        val ramdomCard = RamdomCardProvider()

        val card = ramdomCard.getLucky()


        assertNotNull(card)
    }
}