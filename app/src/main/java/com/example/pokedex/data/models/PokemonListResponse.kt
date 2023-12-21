package com.example.pokedex.data.models

data class PokemonListResponse(
    val count: Int,
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val url: String
)
