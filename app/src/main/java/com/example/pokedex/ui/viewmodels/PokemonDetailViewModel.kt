package com.example.pokedex.ui.viewmodels

//import com.example.pokedex.data.sources.remote.RetrofitClient.pokemonApiService
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repositories.RetrofitClient
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.local.PokemonLocalDataSourceList
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel (
    private val remotePokemonRepository: PokemonRemoteDataSource,
    private val localPokemonRepository: PokemonLocalDataSource,
    private val pokemonName: String?
) : ViewModel() {

    private val _pokemonLiveData = MutableLiveData<Pokemon>()
    val pokemonLiveData: LiveData<Pokemon> get() = _pokemonLiveData

    init {
        viewModelScope.launch {
            if (pokemonName != null) {
                _pokemonLiveData.value = remotePokemonRepository.loadPokemon(pokemonName)
            }
        }
    }
}

