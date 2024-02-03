package com.example.pokedex.ui.screens

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.pokedex.data.sources.local.PokemonLocalDataSourceList
import com.example.pokedex.ui.viewmodels.PokemonListViewModel
import kotlinx.coroutines.launch
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.util.Locale


@ExperimentalFoundationApi
@Composable
fun PokemonListScreen(pokemonListViewModel: PokemonListViewModel, navController: NavController) {
    val pokemonList by pokemonListViewModel.pokemonListLiveData.observeAsState()

    if (pokemonList != null) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)) {
            items(pokemonList!!) { pokemon ->
                Card(
                    modifier = Modifier.padding(5.dp).clickable { navController.navigate("pokemon/${pokemon.name}/${pokemon.name}")}
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = pokemon.name.toUpperCase(Locale.ROOT),
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}
