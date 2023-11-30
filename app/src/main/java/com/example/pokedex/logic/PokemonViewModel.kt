package com.example.pokedex.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PokemonViewModel : ViewModel() {

    private var _pokemonName = MutableLiveData("")
    val pokemonName : LiveData<String> = _pokemonName

    private var _pokemonType1 = MutableLiveData<String>("")
    val pokemonType1 : LiveData<String> = _pokemonType1

    private var _pokemonType2 = MutableLiveData<String>("")
    val pokemonType2 : LiveData<String> = _pokemonType2

    private var _pokemonHeight = MutableLiveData<Float>()
    val pokemonHeight : LiveData<Float> = _pokemonHeight

    private var _pokemonWeight = MutableLiveData<Float>()
    val pokemonWeight : LiveData<Float> = _pokemonWeight

    private var _pokemonStatHP = MutableLiveData<Float>()
    val pokemonStatHP : LiveData<Float> = _pokemonStatHP

    private var _pokemonStatATK = MutableLiveData<Float>()
    val pokemonStatATK : LiveData<Float> = _pokemonStatATK

    private var _pokemonStatDEF = MutableLiveData<Float>()
    val pokemonStatDEF : LiveData<Float> = _pokemonStatDEF

    private var _pokemonStatSPD = MutableLiveData<Float>()
    val pokemonStatSPD : LiveData<Float> = _pokemonStatSPD

    private var _pokemonStatEXP = MutableLiveData<Float>()
    val pokemonStatEXP : LiveData<Float> = _pokemonStatEXP

    private var _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    fun createPokemon() {
        val newPokemon = Pokemon(
            _pokemonName.value.orEmpty(),
            _pokemonType1.value.orEmpty(),
            _pokemonType2.value.orEmpty(),
            _pokemonHeight.value ?: 0.0f,
            _pokemonWeight.value ?: 0.0f,
            _pokemonStatHP.value ?: 0.0f,
            _pokemonStatATK.value ?: 0.0f,
            _pokemonStatDEF.value ?: 0.0f,
            _pokemonStatSPD.value ?: 0.0f,
            _pokemonStatEXP.value ?: 0.0f
        )

        _pokemon.value = newPokemon
    }

}