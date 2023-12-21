package com.example.pokedex.data.api

import com.example.pokedex.data.models.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(@Path("pokemonName") pokemonName: String): Pokemon
}
