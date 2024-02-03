package com.example.pokedex.data.sources.remote

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.data.repositories.RetrofitClient
import com.example.pokedex.domain.repositories.PokemonSource
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(){
         suspend fun loadPokemon(pokemonName: String): Pokemon? {
            return try {
                RetrofitClient.pokemonApiService(RetrofitClient.provideRetrofit()).getPokemonInfo(pokemonName)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }