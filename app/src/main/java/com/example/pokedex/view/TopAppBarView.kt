package com.example.pokedex.view

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pokedex.logic.PokedexViewModel
import com.example.pokedex.logic.Pokemon
import com.example.pokedex.logic.PokemonType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarView(pokedexViewModel: PokedexViewModel) {
    val pokemon by pokedexViewModel.pokemonLiveData.observeAsState(initial = Pokemon())

    val numPok = pokemon.id
    TopAppBar(
        title = { Text(text = "Pokedex", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = {/*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
            }
        }, actions = {
            IconButton(onClick = {}) {
                Text(text = "#$numPok", color = Color.White)
            }
        }
    )

}