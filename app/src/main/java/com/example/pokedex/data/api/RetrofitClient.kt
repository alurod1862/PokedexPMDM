package com.example.pokedex.data.api

import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.models.PokemonDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val gson = GsonBuilder().registerTypeAdapter(Pokemon::class.java, PokemonDeserializer()).create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val pokemonApiService: PokemonApiService = retrofit.create(PokemonApiService::class.java)
}
