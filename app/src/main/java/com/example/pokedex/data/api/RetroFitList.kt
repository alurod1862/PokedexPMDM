package com.example.pokedex.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitList {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getPokemonListApiService(): PokemonListApiService {
        return getRetrofit().create(PokemonListApiService::class.java)
    }
}

