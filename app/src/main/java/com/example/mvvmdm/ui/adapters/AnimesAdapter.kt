package com.example.mvvmdm.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdm.data.remote.model.AnimeDto
import com.example.mvvmdm.databinding.AnimesElementBinding

class AnimesAdapter(
    private val animes: MutableList<AnimeDto>,
    private val onAnimeClicked: (AnimeDto, Int) -> Unit
): RecyclerView.Adapter<AnimesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: AnimesElementBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(anime: AnimeDto){
            binding.apply {
                tvTitulo.text = anime.titulo
                tvTipo.text = anime.tipo
                tvFecha.text = anime.fecha
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimesElementBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = animes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animes[position]
        holder.bind(anime)

        holder.itemView.setOnClickListener {
            onAnimeClicked(anime, animes.size)
        }
    }

}
