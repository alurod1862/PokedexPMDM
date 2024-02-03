package com.example.pokedex.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import com.example.pokedex.domain.models.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarView(navController: NavController,numPok:String) {
    TopAppBar(
        title = { Text(text = "Pokedex", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("pokemonList") }) {
                Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
            }
        }, actions = {
            IconButton(onClick = {}) {
                Text(text = "#$numPok", color = Color.White)
            }
        }
    )

}