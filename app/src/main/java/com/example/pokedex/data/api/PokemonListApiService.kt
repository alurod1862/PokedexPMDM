package com.example.pokedex.data.api

import com.example.pokedex.data.models.Pokemon
import com.example.pokedex.data.models.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonListApiService {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>
}
