package com.example.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.sources.local.PokemonLocalDataSourceList
import com.example.pokedex.domain.models.Pokemon
import kotlinx.coroutines.launch
import com.example.pokedex.domain.models.PokemonResult

class PokemonListViewModel(
    private val localPokemonRepositoryList: PokemonLocalDataSourceList
) : ViewModel() {
    private val _pokemonListLiveData = MutableLiveData<List<PokemonResult>>()
    val pokemonListLiveData : LiveData<List<PokemonResult>> = _pokemonListLiveData

    init {
        viewModelScope.launch {
            val pokemonList = localPokemonRepositoryList.loadPokemonList()
            _pokemonListLiveData.value = pokemonList?.results


        }
    }
}