package com.example.mvvmdm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdm.R
import com.example.mvvmdm.data.remote.model.AnimeDto
import com.example.mvvmdm.databinding.ActivityMainBinding
import com.example.mvvmdm.ui.adapters.AnimesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var animes = mutableListOf<AnimeDto>()

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = AnimesAdapter(animes) {anime, animeSize ->
            Toast.makeText(this@MainActivity,
                "El anime seleccioando es: ${anime.titulo}, y hay $animeSize animes",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        binding.btnAdd.setOnClickListener{
            mainViewModel.updateAnimeRestApi()
        }

        mainViewModel.anime.observe(this, Observer { anime ->
            animes.add(anime)

            myAdapter.notifyItemInserted(animes.size-1)
        })
    }
}