package com.example.mvvmdm.data.remote

import com.example.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.delay

class AnimeProvider {

    companion object {

        private val animes = mutableListOf<AnimeDto>()

        init {
            for (i in 1..40) {
                val animeTmp = AnimeDto(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
                animes.add(animeTmp)
            }
        }


        suspend fun getAnimeRestApi(): AnimeDto {
            val position = (0..39).random()
            delay(2000)
            //val position2 = Random.nextInt(0,39)
            return animes[position]
        }

    }

}