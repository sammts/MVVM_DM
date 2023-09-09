package com.example.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdm.data.remote.AnimeProvider
import com.example.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _anime = MutableLiveData<AnimeDto>() //Esta es la version mutable y privada
    val anime: LiveData<AnimeDto> = _anime //Esta se accede publicamente pero es read-only

    private val _test = MutableLiveData<String>() //Esta es la version mutable y privada
    val test: LiveData<String> = _test //Esta se accede publicamente pero es read-only

    fun updateAnimeRestApi(){
        viewModelScope.launch {
            _anime.postValue(AnimeProvider.getAnimeRestApi())
        }
    }

}