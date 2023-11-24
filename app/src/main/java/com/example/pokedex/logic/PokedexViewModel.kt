package com.example.pokedex.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PokedexViewModel : ViewModel(){


    private var _pokemonName = MutableLiveData<String>("")
    val pokemonName : LiveData<String> = _pokemonName

    private var _pokemonType1 = MutableLiveData<String>("")
    val pokemonType1 : LiveData<String> = _pokemonType1

    private var _pokemonType2 = MutableLiveData<String>("")
    val pokemonType2 : LiveData<String> = _pokemonType2

    private var _pokemonHeight = MutableLiveData<Int>()
    val pokemonHeight : LiveData<Int> = _pokemonHeight

    private var _pokemonWeight = MutableLiveData<Int>()
    val pokemonWeight : LiveData<Int> = _pokemonWeight

    private var _pokemonStatHP = MutableLiveData<Int>()
    val pokemonStatHP : LiveData<Int> = _pokemonStatHP

    private var _pokemonStatATK = MutableLiveData<Int>()
    val pokemonStatATK : LiveData<Int> = _pokemonStatATK

    private var _pokemonStatDEF = MutableLiveData<Int>()
    val pokemonStatDEF : LiveData<Int> = _pokemonStatDEF

    private var _pokemonStatSPD = MutableLiveData<Int>()
    val pokemonStatSPD : LiveData<Int> = _pokemonStatSPD


    private var _pokemonStatEXP = MutableLiveData<Int>()
    val pokemonStatEXP : LiveData<Int> = _pokemonStatEXP





}