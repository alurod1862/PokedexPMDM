package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.view.MyTopAppBarView
import com.example.pokedex.view.PokemonView
import com.example.pokedex.logic.Pokemon

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemon = Pokemon("Charizard", "Flying","Fire",90.5f,1.7f,0.33f,0.36f,0.73f,0.93f,0.93f,"006",R.drawable.charizard)
                Scaffold(
                    topBar = { MyTopAppBarView(pokemon) }
                )
                {
                    PokemonView(pokemon)
                }
            }
        }
    }
}

