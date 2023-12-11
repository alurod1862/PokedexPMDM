package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.logic.PokedexViewModel
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.view.MyTopAppBarView
import com.example.pokedex.view.PokemonView
import com.example.pokedex.logic.Pokemon
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemon = Pokemon("prueba","prueba","prueba",90.5f,2f,1f,1f,1f,1f,1f,"001","R.drawable.charizrd",1)
                val pokedexViewModel = ViewModelProvider(this)[PokedexViewModel::class.java]
                Scaffold(
                    //topBar = { MyTopAppBarView(pokedexViewModel.loadPokemon(pokemonNmae = "ditto"))}
                    //topBar = { MyTopAppBarView(pokemon) }

                )
                {
                    PokemonView(pokedexViewModel.loadPokemon(pokemonNmae = "ditto"))
                    //PokemonView(pokemon)
                }
            }
        }
    }
}

