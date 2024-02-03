package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.Pokemon

interface PokemonSource {
    suspend fun loadPokemon(name: String): Pokemon?
}