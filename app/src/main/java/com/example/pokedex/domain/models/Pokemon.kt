package com.example.pokedex.domain.models

import javax.inject.Singleton


data class Pokemon(
    @Singleton
    val name: String="",
    val type1: String="",
    val type2: String? = null,
    val weight: Float=0f,
    val height: Float=0f,
    val statHP: Float=0.0f,
    val statATK: Float=0.0f,
    val statDEF: Float=0.0f,
    val statSPD: Float=0.0f,
    val statSD: Float=0.0f,
    val statSA: Float=0.0f,
    val statEXP: Float=0.0f,
    val imagen:String = "",
    val id:Int = 0
)

