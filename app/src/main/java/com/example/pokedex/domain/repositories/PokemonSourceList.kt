package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.PokemonList

interface PokemonSourceList {

    suspend fun loadPokemonList(): PokemonList?
}