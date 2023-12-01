package com.example.pokedex.logic

import androidx.lifecycle.ViewModel

class Pokemon(
    val name: String="",
    val type1: String="",
    val type2: String? = null,
    val weight: Float=0.0f,
    val height: Float=0.0f,
    val statHP: Float=0.0f,
    val statATK: Float=0.0f,
    val statDEF: Float=0.0f,
    val statSPD: Float=0.0f,
    val statEXP: Float=0.0f,
    val numPokemon: String = "",
    val imagen:Int = 0,
)

class PokedexViewModel : ViewModel() {



}


