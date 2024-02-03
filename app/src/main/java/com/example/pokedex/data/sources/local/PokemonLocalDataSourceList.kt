package com.example.pokedex.data.sources.local

import android.app.Application
import android.content.Context
import com.example.pokedex.data.repositories.PokemonDeserializerList
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonSourceList
import com.google.gson.GsonBuilder
import java.io.IOException
import javax.inject.Inject

class PokemonLocalDataSourceList @Inject constructor(private val application: Application): PokemonSourceList {
    private val gson = GsonBuilder()
        .registerTypeAdapter(PokemonList::class.java, PokemonDeserializerList())
        .create()
    override suspend fun loadPokemonList(): PokemonList {
        val jsonString = getPokemonJson(application.applicationContext)
        return gson.fromJson(jsonString, PokemonList::class.java)
    }


    private fun getPokemonJson(context: Context): String? {
        return try {
            context.assets.open("pokemonList.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }
}