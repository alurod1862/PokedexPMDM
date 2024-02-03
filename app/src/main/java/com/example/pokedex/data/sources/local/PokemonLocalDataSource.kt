package com.example.pokedex.data.sources.local

import android.app.Application
import android.content.Context
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.data.repositories.PokemonDeserializer
import com.example.pokedex.domain.repositories.PokemonSource
import com.google.gson.GsonBuilder
import java.io.IOException
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(private val application: Application): PokemonSource {
    private val gson = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

    override suspend fun loadPokemon(pokemonName: String): Pokemon? {
        val jsonString = getPokemonJson(application.applicationContext, pokemonName(pokemonName))
        return gson.fromJson(jsonString, Pokemon::class.java)
    }

    private fun getPokemonJson(context: Context, pokemonName: String): String? {
        return try {
            context.assets.open(pokemonName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }

    private fun pokemonName(name: String): String {
        val json = ".json"
        return name + json
    }

}