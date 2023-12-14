package com.example.pokedex.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.models.PokemonDeserializer
import com.example.pokedex.data.models.PokemonType
import com.google.gson.GsonBuilder
import java.io.IOException


class PokedexViewModel(application: Application) : AndroidViewModel(application) {

    private val _pokemonLiveData = MutableLiveData<Pokemon>()
    val pokemonLiveData: LiveData<Pokemon> get() = _pokemonLiveData
    val appContext = getApplication<Application>().applicationContext


    init {
        loadPokemon(pokemonName = pokemonName("charizard"))
    }


    private fun loadPokemon(pokemonName: String) {
        val gson =
            GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()
        val pokemon = gson.fromJson(getPokemon(appContext, pokemonName), Pokemon::class.java)
        println(_pokemonLiveData.value?.name)
        _pokemonLiveData.value = pokemon
    }

    fun getPokemon(context: Context, pokemonName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(pokemonName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    fun pokemonName(name: String): String {

        val json = ".json"
        val pokemon = name + json

        return pokemon
    }


    fun type1(pokemon: Pokemon): Color {
        var color = PokemonType.NORMAL

        if (pokemon.type1.isNotEmpty()) {
            val pokemonType = PokemonType.values().find { it.name == pokemon.type1.toUpperCase() }

            if (pokemonType != null) {
                color = pokemonType
            }
        }

        return color.color
    }

    fun type2(pokemon: Pokemon): Color {
        var color = PokemonType.NORMAL

        if (pokemon.type2?.isNotEmpty() == true) {
            val pokemonType = PokemonType.values().find { it.name == pokemon.type2.toUpperCase() }

            if (pokemonType != null) {
                color = pokemonType
            }
        }

        return color.color
    }


}


