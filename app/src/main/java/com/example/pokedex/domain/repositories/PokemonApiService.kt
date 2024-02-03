package com.example.pokedex.domain.repositories

import android.telecom.Call
import com.example.pokedex.domain.models.Pokemon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(@Path("pokemonName") pokemonName: String): Pokemon
}