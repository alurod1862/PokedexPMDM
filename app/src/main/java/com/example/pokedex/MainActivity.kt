package com.example.pokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.local.PokemonLocalDataSourceList
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.PokemonTypes
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.components.MyTopAppBarView
import com.example.pokedex.ui.screens.PokemonListScreen
import com.example.pokedex.ui.screens.PokemonView
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()

                Scaffold {
                    NavHost(navController = navController, startDestination = "pokemonList") {
                        composable("pokemonList"){PokemonListScreen(pokemonListViewModel= PokemonListViewModel(PokemonLocalDataSourceList(application)),navController)}
                        composable("pokemon/{pokemonName}/{pokemonName}") { backStackEntry ->
                            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
                            PokemonView(
                                PokemonDetailViewModel(PokemonRemoteDataSource(),PokemonLocalDataSource(application),pokemonName),
                                PokemonTypes(),navController
                            )
                        }
                    }
                }
            }
        }
    }
}

