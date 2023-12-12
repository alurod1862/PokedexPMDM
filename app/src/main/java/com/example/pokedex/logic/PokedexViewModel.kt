package com.example.pokedex.logic

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.IOException

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
    val imagen:String = "",
    val id:Int = 0
)


class PokedexViewModel(application: Application) : AndroidViewModel(application) {


    private val _pokemonLiveData = MutableLiveData<Pokemon>()
    val pokemonLiveData: LiveData<Pokemon> get() = _pokemonLiveData
    val appContext = getApplication<Application>().applicationContext


    init {
        loadPokemon(pokemonName = "charizard.json")
    }


    private fun loadPokemon(pokemonName :String){
        val gson = GsonBuilder().registerTypeAdapter(Pokemon::class.java,PokemonDeserializer()).create()
        val pokemon = gson.fromJson(getPokemon(appContext,pokemonName),Pokemon::class.java)
        println(_pokemonLiveData.value?.name)
        _pokemonLiveData.value = pokemon
    }

   fun getPokemon(context : Context,pokemonName:String):String?{
       val jsonString: String
       try {
           jsonString = context.assets.open(pokemonName).bufferedReader().use { it.readText() }
       } catch (ioException: IOException) {
           ioException.printStackTrace()
           return null
       }
       return jsonString
    }



}


