package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.viewmodels.PokedexViewModel
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.components.MyTopAppBarView
import com.example.pokedex.ui.screens.HomeCard
import com.example.pokedex.ui.screens.PokemonView

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel = PokedexViewModel(application)
                val navController = rememberNavController()
                Scaffold(
                    //topBar = { MyTopAppBarView(pokemonViewModel) }
                )
                {
                    NavHost(navController = navController, startDestination = "homeCard"){
                        composable("homeCard"){ HomeCard(navController)}
                        composable("pokemonViewModel"){PokemonView(pokemonViewModel) }
                    }
                }
            }
        }
    }
}

