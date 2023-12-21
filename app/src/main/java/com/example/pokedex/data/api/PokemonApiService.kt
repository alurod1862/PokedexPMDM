package com.example.pokedex.data.api

import android.telecom.Call
import com.example.pokedex.data.models.Pokemon
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApiService {
    @GET("pokemon/{pokemonName}")
    fun getPokemonInfo(@Path("pokemonName") pokemonName: String): Pokemon
}