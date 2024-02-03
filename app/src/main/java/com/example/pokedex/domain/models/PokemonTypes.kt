package com.example.pokedex.domain.models

import androidx.compose.ui.graphics.Color

class PokemonTypes {

    fun type1(pokemon: Pokemon): Color {
        var color = PokemonType.NORMAL

        if (pokemon.type1.isNotEmpty()) {
            val pokemonType = PokemonType.values().find { it.name == pokemon.type1.toUpperCase() }

            if (pokemonType != null) {
                color = pokemonType
            }
        }

        return color.color
    }

    fun type2(pokemon: Pokemon): Color {
        var color = PokemonType.NORMAL

        if (pokemon.type2?.isNotEmpty() == true) {
            val pokemonType = PokemonType.values().find { it.name == pokemon.type2.toUpperCase() }

            if (pokemonType != null) {
                color = pokemonType
            }
        }

        return color.color
    }
}